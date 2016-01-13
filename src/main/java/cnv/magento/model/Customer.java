/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 *
 * @author Owner
 */
public class Customer extends MagentoBaseModel {
    
    @SerializedName(value = "firstname")
    private String firstName;
    @SerializedName(value = "lastname")
    private String lastName;
    @SerializedName(value = "email")
    private String email;
    @SerializedName(value = "created_at")
    private Date registeredDate;
    @SerializedName(value = "gender")
    private String gender;
    @SerializedName(value = "last_order_id")
    private Long lastOrderId = -1L;
    @SerializedName(value = "total_spent")
    private Float totalSpent;
    @SerializedName(value = "orders_count")
    private Integer totalOrders = 0;

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getLastOrderId() {
        return lastOrderId;
    }

    public void setLastOrderId(Long lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    public Integer getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Float getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Float totalSpent) {
        this.totalSpent = totalSpent;
    } 
    
}