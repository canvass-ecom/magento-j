/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.magento.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Owner
 */
public class Address extends MagentoBaseModel {

    public enum AddressType {

        billing,
        shipping
    }
    @SerializedName("address_type")
    private AddressType addressType;
    @SerializedName("street")
    private String street;
    @SerializedName("city")
    private String city;
    @SerializedName("country_id")
    private String countryId;
    @SerializedName("postcode")
    private String pincode;
    @SerializedName("firstname")
    private String firstName;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("telephone")
    private String telephone;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTelephone() {
        return telephone == null ? "" : telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
