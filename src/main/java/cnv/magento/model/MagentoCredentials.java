/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento.model;

/**
 *
 * @author Owner
 */
public class MagentoCredentials {    
    private String shopUrl;
    private String consumerKey;
    private String consumerSecret;
    private String accessKey;
    private String accessSecret;
    private String customRestApi;

    private MagentoCredentials(String shopUrl, String consumerKey, String consumerSecret, String accessKey, String accessSecret) {
        this(shopUrl, consumerKey, consumerSecret, accessKey, accessSecret, "");
    }

    private MagentoCredentials(String shopUrl, String consumerKey, String consumerSecret, String accessKey, String accessSecret, String customRestApi) {
        this.shopUrl = shopUrl;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessKey = accessKey;
        this.accessSecret = accessSecret;
        this.customRestApi = customRestApi;
    }

    private MagentoCredentials(String shopUrl, String consumerKey, String consumerSecret) {
        this.shopUrl = shopUrl;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
    }

    public String getCustomRestApi() {
        return customRestApi;
    }

    public void setCustomRestApi(String customRestApi) {
        this.customRestApi = customRestApi;
    }
    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }
    public boolean hasAccessToken() {
        return (accessKey != null && accessKey.length() != 0) && (accessSecret != null && accessSecret.length() != 0);
    }

    public static MagentoCredentials create(String shopUrl, String consumerKey, String consumerSecret) {
        return new MagentoCredentials(shopUrl, consumerKey, consumerSecret);
    }

    public static MagentoCredentials createWithToken(String shopUrl, String consumerKey, String consumerSecret, String accessKey, String accessSecret) {
        return new MagentoCredentials(shopUrl, consumerKey, consumerSecret, accessKey, accessSecret);
    }

    public static MagentoCredentials createWithTokenCustomRestApi(String shopUrl, String consumerKey, String consumerSecret, String accessKey, String accessSecret, String customRestApi) {
        return new MagentoCredentials(shopUrl, consumerKey, consumerSecret, accessKey, accessSecret, customRestApi);
    }
}
