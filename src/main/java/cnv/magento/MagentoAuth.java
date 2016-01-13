/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

/**
 *
 * @author Owner
 */
public final class MagentoAuth {

    static final String MAGENTO_API_KEY = "479d75994daa6d9aa912fe0453f8e7da";
    static final String MAGENTO_API_SECRET = "022fcf4033cead48292460aca0eaa8d3";
    static final String MAGENTO_ACCESS_KEY = "443e362c163a6f07b85e199a064b035e";
    static final String MAGENTO_ACCESS_SECRET = "427955c07ed90c2b1604a730e62ba773";
    static final String MAGENTO_REST_API_URL = "http://localhost/magento-1.x.x/api/rest";

    public static Token getRequestToken() {
        OAuthService service = new ServiceBuilder().provider(MagentoThreeLeggedOAuth.class).
                apiKey(MAGENTO_API_KEY).
                apiSecret(MAGENTO_API_SECRET).
                build();

        System.out.println("=== Mage v1.7.0.2 OAuth Workflow ===");
        System.out.println();

        // Obtain the Request Token
        System.out.println("Fetching the Request Token...");
        Token requestToken = service.getRequestToken();
        System.out.println("token: " + requestToken.getRawResponse());
        System.out.println();

        System.out.println("Now go and authorize Scribe here:");
        System.out.println(service.getAuthorizationUrl(requestToken));
        return requestToken;
    }

    public static void getAcessToken(String token, String tokenSecret, String verifierStr) {
        Token requestToken = new Token(token, tokenSecret);
        OAuthService service = new ServiceBuilder().provider(MagentoThreeLeggedOAuth.class).
                apiKey(MAGENTO_API_KEY).
                apiSecret(MAGENTO_API_SECRET).
                build();
        Verifier verifier = new Verifier(verifierStr);
        Token accessToken = service.getAccessToken(requestToken, verifier);
        System.out.println("accessToken = " + accessToken);
    }

    public static void showProducts() {
        OAuthService service = new ServiceBuilder().provider(MagentoThreeLeggedOAuth.class).
                apiKey(MAGENTO_API_KEY).
                apiSecret(MAGENTO_API_SECRET).
                build();
        Token permanentToken = new Token(MAGENTO_ACCESS_KEY, MAGENTO_ACCESS_SECRET);
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/products?limit=2");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/products/1");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/products/1/images");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/customers?filter[0][attribute]=created_at&filter[0][from][0]=2016-01-05%2000:00:00");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL + "/customers/8");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/orders?limit=1");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/orders?order=created_at&dir=dsc&filter[1][attribute]=customer_id&filter[1][in][0]=1&filter[1][in][1]=8");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/orders?filter[0][attribute]=created_at&filter[0][from][0]=2016-01-05%2000:00:00");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/coupondemo/rules/2/codes?limit=1");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/firecart/orders?order=created_at&dir=dsc&limit=1&cust_type=GUEST");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/firecart/orders?limit=1&cust_type=GUEST");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/firecart/orders/27");
        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/orders?order=created_at&dir=dsc&filter[1][attribute]=entity_id&filter[1][in][0]=1&filter[1][in][1]=27");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/firecart/customers?order=created_at&dir=dsc&limit=1");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL+ "/firecart/customers/8");
        request.addHeader("Content-Type", "application/json");
        service.signRequest(permanentToken, request);
        Response response = request.send();
        String responseBody = response.getBody();
        System.out.println();
        System.out.println(response.getCode());
        System.out.println(responseBody);
        System.out.println();
//        try{
//        Type type = new TypeToken<HashMap<String, Customer>>() {
//        }.getType();
//        HashMap<String, Customer> parse = MagentoResponseParser.parser().parse(responseBody, type);
//            List<Customer> values = new ArrayList<Customer>(parse.values());
//            System.out.println("values = " + values);
//        Type type = new TypeToken<HashMap<String, Order>>() {
//        }.getType();
//        HashMap<String, Order> parse = MagentoResponseParser.parser().parse(responseBody, type);
//            List<Order> values = new ArrayList<Order>(parse.values());
//            System.out.println("values = " + new Gson().toJson(values));
//            System.out.println("values = " + values);
//        } catch(Exception e){
//            e.printStackTrace(System.out);
//        }
    }

    public static void main(String[] args) {
//        getRequestToken();
//        getAcessToken("928eed172ebc499b2d801b57ef368f03", "98bdf0e669cdb3cc5e6a5599b82573fd", "2986424f6429b288f6708aaabf33fadf");
        showProducts();
    }

    public static void main1(String[] args) {
//        final String MAGENTO_API_KEY = "479d75994daa6d9aa912fe0453f8e7da";
//        final String MAGENTO_API_SECRET = "022fcf4033cead48292460aca0eaa8d3";
//        final String MAGENTO_REST_API_URL = "http://localhost/magento-1.x.x/api/rest";
//        OAuthService service = new ServiceBuilder().provider(MagentoThreeLeggedOAuth.class).
//                apiKey(MAGENTO_API_KEY).
//                apiSecret(MAGENTO_API_SECRET).
//                build();
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("=== Mage v1.7.0.2 OAuth Workflow ===");
//        System.out.println();
//
//        // Obtain the Request Token
//        System.out.println("Fetching the Request Token...");
//        Token requestToken = service.getRequestToken();
//        System.out.println("Got the Request Token!");
//        System.out.println();
//
//        System.out.println("Now go and authorize Scribe here:");
//        System.out.println(service.getAuthorizationUrl(requestToken));
//        System.out.println("And paste the verifier here");
//        System.out.print(">>");
//        Verifier verifier = new Verifier(in.nextLine());
//        System.out.println();
//
//        // Trade the Request Token and Verfier for the Access Token
//        System.out.println("Trading the Request Token for an Access Token...");
//        Token accessToken = service.getAccessToken(requestToken, verifier);
//        System.out.println("Got the Access Token!");
//        System.out.println("(if your curious it looks like this: " + accessToken + " )");
//        System.out.println();
//
//        // Now let's go and ask for a protected resource!
//        System.out.println("Now we're going to access a protected resource...");
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL + "/customers");
//        service.signRequest(accessToken, request);
//        Response response = request.send();
//        System.out.println("Got it! Lets see what we found...");
//        System.out.println();
//        System.out.println(response.getBody());
//
//        System.out.println();
//        System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
    }
//    
//    /**
//     * @param args
//     */
//    public static void main1(String[] args) {
//        final String MAGENTO_API_KEY = "e2f44d2c3148630f685583374a8a8711";
//        final String MAGENTO_API_SECRET = "4bcb5e9b01cb93061451f4b5d6aedd64";
//        final String MAGENTO_REST_API_URL = "http://fc-magento.website.cp-in-9.webhostbox.net/magento/index.php/api/rest";
//        // three-legged oauth
//        OAuthService service = new ServiceBuilder().
//                provider(MagentoThreeLeggedOAuth.class).
//                apiKey(MAGENTO_API_KEY).
//                apiSecret(MAGENTO_API_SECRET).
//                debug().build();
//        //OAuth10aServiceImpl service =(OAuth10aServiceImpl) new ServiceBuilder().provider(TestMage.MagentoThreeLeggedOAuth.class);
//
//        System.out.println("" + service.getVersion());
//        Scanner in = new Scanner(System.in);
//        System.out.println("Magento's OAuth Workflow");
//        System.out.println();
//
//        // Obtain the Request Token
//        System.out.println("Fetching the Request Token...");
//        Token requestToken = service.getRequestToken();
//        System.out.println("Got the Request Token!");
//        System.out.println();
//
//        System.out.println("Fetching the Authorization URL...");
//        String authorizationUrl = service.getAuthorizationUrl(requestToken);
//        System.out.println("Got the Authorization URL!");
//        System.out.println("Now go and authorize Main here:");
//        System.out.println(authorizationUrl);
//        System.out.println("And paste the authorization code here");
//        System.out.print(">>");
//
//        Verifier verifier = new Verifier(in.nextLine());
//        System.out.println();
//        System.out.println("Trading the Request Token for an Access Token...");
//
//        Token accessToken = service.getAccessToken(requestToken, verifier);
//        System.out.println("Got the Access Token!");
//        System.out.println("(if your curious it looks like this: "
//                + accessToken + " )");
//        System.out.println();
//
//        OAuthRequest request = new OAuthRequest(Verb.GET, MAGENTO_REST_API_URL + "/products", service);
//        service.signRequest(accessToken, request);
//
//        Response response = request.send();
//        System.out.println();
//        System.out.println(response.getCode());
//        System.out.println(response.getBody());
//        System.out.println();
//    }
}
