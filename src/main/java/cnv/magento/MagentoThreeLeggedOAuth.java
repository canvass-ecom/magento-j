/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 *
 * @author Owner
 */
public class MagentoThreeLeggedOAuth extends DefaultApi10a {

    private String baseUrl;

    public MagentoThreeLeggedOAuth(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return baseUrl + "oauth/initiate";

    }

    @Override
    public String getAccessTokenEndpoint() {
        return baseUrl + "oauth/token";
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return baseUrl + "admin/oauth_authorize?oauth_token="
                + requestToken.getToken(); //this implementation is for admin roles only...
    }
}
