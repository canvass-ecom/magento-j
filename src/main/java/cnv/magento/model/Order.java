/**
 *
 * @author Rohit Shinde @Canvass
 * 13 Jan, 2016
 */
package cnv.magento.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class Order extends MagentoBaseModel {

    @SerializedName(value = "discount_amount")
    private float discountAmount;
    @SerializedName(value = "grand_total")
    private float grandtotal;
    private float orderAmount;
    @SerializedName(value = "status")
    private String status;
    @SerializedName(value = "customer_id")
    private Long customerId;
    @SerializedName(value = "email")
    private String email;
    @SerializedName(value = "base_currency_code")
    private String currency;
    @SerializedName(value = "created_at")
    private Date purchaseDate;
    @SerializedName(value = "addresses")
    private List<Address> addresses;
    @SerializedName(value = "order_items")
    private List<OrderItem> orderItems;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(float grandtotal) {
        this.grandtotal = grandtotal;
    }

    public float getOrderAmount() {
        return grandtotal + discountAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * Inner class that represents an Item in an Order
     */
    public static class OrderItem {

        @SerializedName("item_id")
        private long id;
        @SerializedName("name")
        private String name;
        @SerializedName("price")
        private float price;
        @SerializedName("product_url")
        private String productUrl;
        @SerializedName("image_url")
        private String imgUrl;

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getProductUrl() {
            return productUrl;
        }

        public void setProductUrl(String productUrl) {
            this.productUrl = productUrl;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
}
