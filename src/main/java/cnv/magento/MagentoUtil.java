/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Owner
 */
public class MagentoUtil {

    public static Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public static void main(String[] args) {
    }
}