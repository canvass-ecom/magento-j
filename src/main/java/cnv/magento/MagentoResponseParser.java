/**
 *
 * @author Rohit Shinde @Canvass
 * 13 Jan, 2016 11:15:48 AM
 */
package cnv.magento;

import com.google.gson.Gson;
import java.lang.reflect.Type;

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