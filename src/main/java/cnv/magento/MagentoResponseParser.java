/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/**
 *
 * @author Naga Srinivas @Canvass
 */
public class MagentoResponseParser {

    private static final MagentoResponseParser parser = new MagentoResponseParser();
    private Gson gson;

    private MagentoResponseParser() {
        gson = MagentoUtil.getGson();
    }

    public <T> T parse(String json, Class<T> cls) {
        T obj = null;
        try {
            obj = gson.fromJson(json, cls);
        } catch (Exception e) {
            System.out.println("Error while parsing the Magento Reponse: " + e);
        }
        return obj;
    }

    public <T> T parse(String json, Type type) {
        T obj = null;
        try {
            obj = gson.fromJson(json, type);
        } catch (Exception e) {
            System.out.println("Error while parsing the Magento Reponse: " + e);
        }
        return obj;
    }

    public static MagentoResponseParser parser() {
        return parser;
    }
}