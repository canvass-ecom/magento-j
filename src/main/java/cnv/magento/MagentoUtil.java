/**
 *
 * @author Rohit Shinde @Canvass
 * 13 Jan, 2016
 */
package cnv.magento;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MagentoUtil {

    public static Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public static void main(String[] args) {
    }
}