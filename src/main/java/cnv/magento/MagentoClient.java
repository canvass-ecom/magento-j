/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento;

import cnv.magento.model.MagentoCredentials;
import cnv.magento.service.MagentoBaseService;
import java.util.HashMap;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 *
 * @author Owner
 */
public class MagentoClient {
    
    private HashMap<Class, MagentoBaseService> services;
    private MagentoCredentials creds;
    String baseUrl;
    private boolean debug = false;

    public void enableDebug() {
        debug = true;
    }

    public void disableDebug() {
        debug = false;
    }

    public boolean isDebugEnabled() {
        return debug;
    }
    
    public MagentoClient(MagentoCredentials credentails) {
        this.creds = credentails;
        String customRestApi = "";
        if(creds.getCustomRestApi() != null && !creds.getCustomRestApi().isEmpty()){
           customRestApi = "/"+creds.getCustomRestApi();
        }
        baseUrl = creds.getShopUrl()+"/api/rest"+customRestApi;
    }
    
    public MagentoCredentials getCredentials() {
        return creds;
    }
    
    public String getBaseUrl() {
        return baseUrl;
    }

    static void log(String msg) {
        System.out.println("[Magento] " + msg);
    }
    /**
     * This method will create the Given Service
     *
     * @param <T>
     * @param cls Service Class
     * @return the Service Object
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T extends MagentoBaseService> T getService(Class<T> cls) throws InstantiationException, IllegalAccessException {
        T obj = cls.newInstance();
        obj.setClient(this);
        return obj;
    }
    
    public HashMap getRequestTokenAndAuthorizationUrl(){
        HashMap map = new HashMap();
        OAuthService service = new ServiceBuilder().provider(new MagentoThreeLeggedOAuth(creds.getShopUrl())).
                apiKey(creds.getConsumerKey()).
                apiSecret(creds.getConsumerSecret()).
                build();
        Token requestToken = service.getRequestToken();
        map.put("token", requestToken.getToken());
        map.put("secret", requestToken.getSecret());
        map.put("authorizationUrl", service.getAuthorizationUrl(requestToken));
        return map;
    }
    
    public Token getAcessToken(String token, String tokenSecret, String verifierStr){
        OAuthService service = new ServiceBuilder().provider(new MagentoThreeLeggedOAuth(creds.getShopUrl())).
                apiKey(creds.getConsumerKey()).
                apiSecret(creds.getConsumerSecret()).
                build();
        Verifier verifier = new Verifier(verifierStr);
        Token requestToken = new Token(token, tokenSecret);
        Token accessToken = service.getAccessToken(requestToken, verifier);
        creds.setAccessKey(accessToken.getToken());
        creds.setAccessSecret(accessToken.getSecret());
        return accessToken;
    }
}
