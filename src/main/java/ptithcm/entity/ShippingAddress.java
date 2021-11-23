package ptithcm.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ShippingAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shippingAddressId;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String address;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String city;

    @NotEmpty
    @Column(columnDefinition = "nvarchar(255)")
    private String country;

    @NotEmpty
    @Column(columnDefinition = "varchar(255)")
    private String zipCode;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(long shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public void merge(ShippingAddress updated) {
        setAddress(updated.address);
        setCity(updated.city);
        setCountry(updated.country);
        setZipCode(updated.zipCode);
    }
}