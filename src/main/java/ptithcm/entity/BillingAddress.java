package ptithcm.entity;

import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BillingAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billingAddressId;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String strretName;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String apartmentNumber;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String city;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String district;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String country;

    @NotEmpty
    private String zipCode;

    public long getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getStrretName() {
        return strretName;
    }

    public void setStrretName(String strretName) {
        this.strretName = strretName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
