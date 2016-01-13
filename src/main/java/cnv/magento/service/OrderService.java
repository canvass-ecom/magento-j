/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento.service;

import cnv.magento.MagentoResponseParser;
import cnv.magento.model.Order;
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
public class OrderService extends MagentoBaseService {
    
    public List<Order> getOrders() throws Exception {
        return getOrders(250);
    }

    public List<Order> getOrders(int limit) throws Exception {
        return getOrders(1, limit);
    }

    public List<Order> getOrders(List<Long> orderIds) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("?filter[1][attribute]=entity_id");
        int counter = 0;
        for(Long orderId: orderIds){
            sb.append("&filter[1][in][");
            sb.append(counter++);
            sb.append("]=");
            sb.append(orderId);
        }
        String queryString = "/orders" + sb.toString();
        return getOrders(queryString);
    }
    
    public List<Order> getOrders(int page, int limit) throws Exception {
        if (page < 1) {
            throw new IllegalArgumentException("Page should be a positive integer and > 0");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("Limit should be a positive integer and > 0");
        }
        String queryString = "/orders?page="+page+"&limit="+limit;
        return getOrders(queryString);
    }
    
    private List<Order> getOrders(String queryString) throws Exception {
        List<Order> orders = null;
        Response response = execute(queryString);        
        String responseBody = response.getBody();
        System.out.println();
        System.out.println(response.getCode());
        System.out.println();
        try{
        Type type = new TypeToken<HashMap<String, Order>>() {
        }.getType();
        HashMap<String, Order> parse = MagentoResponseParser.parser().parse(responseBody, type);
             orders = new ArrayList<Order>(parse.values());
        } catch(Exception e){
            e.printStackTrace(System.out);
        }
        return orders;
    }
}
