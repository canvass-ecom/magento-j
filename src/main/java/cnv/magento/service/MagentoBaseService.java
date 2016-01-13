/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento.service;

import cnv.magento.MagentoClient;
import cnv.magento.MagentoThreeLeggedOAuth;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 *
 * @author Owner
 */
public class MagentoBaseService {

    protected MagentoClient client;
    protected String baseUrl;

    MagentoBaseService() {
    }

    public MagentoClient getClient() {
        return client;
    }

    public void setClient(MagentoClient client) {
        this.client = client;
        this.baseUrl = client.getBaseUrl();
    }

    protected Response execute(String queryString) {
        OAuthService service = new ServiceBuilder().provider(new MagentoThreeLeggedOAuth(client.getCredentials().getShopUrl())).
                apiKey(client.getCredentials().getConsumerKey()).
                apiSecret(client.getCredentials().getConsumerSecret()).
                build();
        Token permanentToken = new Token(client.getCredentials().getAccessKey(), client.getCredentials().getAccessSecret());
        OAuthRequest request = new OAuthRequest(Verb.GET, client.getBaseUrl() + queryString);
        request.addHeader("Content-Type", "application/json");
        service.signRequest(permanentToken, request);
        Response response = request.send();
        return response;
    }
}
