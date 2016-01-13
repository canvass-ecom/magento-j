/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento.service;

import cnv.magento.model.Customer;
import cnv.magento.MagentoResponseParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.scribe.model.Response;
/**
 *
 * @author Owner
 */
public class CustomerService extends MagentoBaseService {
    
    public List<Customer> getCustomers() throws Exception {
        return getCustomers(250);
    }

    public List<Customer> getCustomers(int limit) throws Exception {
        return getCustomers(1, limit);
    }

    public List<Customer> getCustomers(int page, int limit) throws Exception {
        List<Customer> customers = null;
        if (page < 1) {
            throw new IllegalArgumentException("Page should be a positive integer and > 0");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("Limit should be a positive integer and > 0");
        }
        String queryString = "/customers?page="+page+"&limit="+limit;
        Response response = execute(queryString);        
        String responseBody = response.getBody();
        System.out.println();
        System.out.println(response.getCode());
        System.out.println();
        try{
        Type type = new TypeToken<HashMap<String, Customer>>() {
        }.getType();
        HashMap<String, Customer> parse = MagentoResponseParser.parser().parse(responseBody, type);
             customers = new ArrayList<Customer>(parse.values());
        } catch(Exception e){
            e.printStackTrace(System.out);
        }
        return customers;
    }
}
