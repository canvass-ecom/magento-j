/**
 *
 * @author Rohit Shinde @Canvass
 * 13 Jan, 2016
 */
package cnv.magento;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class MagentoThreeLeggedOAuth extends DefaultApi10a {

    private String baseUrl;
    private String customAdminPath = "/cadminpanel"; //hack for jubination

    public MagentoThreeLeggedOAuth(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return baseUrl + "/oauth/initiate";

    }

    @Override
    public String getAccessTokenEndpoint() {
        return baseUrl + "/oauth/token";
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return baseUrl + customAdminPath +"/oauth_authorize?oauth_token="
                + requestToken.getToken(); //this implementation is for admin roles only...
    }
}
