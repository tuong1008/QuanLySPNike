package ptithcm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;


@Entity
public class Product implements Serializable{

	
	private static final long serialVersionUID = 10L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;

        
	@NotEmpty
        @Column(columnDefinition = "nvarchar(255)")
	private String productName;
	@NotEmpty
        @Column(columnDefinition = "nvarchar(255)")
	private String productBrand;
	@NotEmpty
        @Column(columnDefinition = "nvarchar(255)")
	private String productModel;
	
	@Range(min=0)
	@NotNull
	private Double productPrice;
	
	@Range(min=0)
	@NotNull
	private Integer unitInStock;
        @Column(columnDefinition = "nvarchar(255)")
	private String productCategory;
	@NotEmpty
        @Column(columnDefinition = "nvarchar(255)")
	private String productDescription;
	
	@Column(columnDefinition = "nvarchar(255)")
	private String productStatus;
	
	@Range(min=0)
	@NotNull
	private  Double discount;
	@Transient
        @JsonBackReference
	private MultipartFile productImage;
	
	@Transient
        @JsonBackReference
	private Map<String, String> categoryList;
	
	@JsonBackReference
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<CartItem> cartItems;
	
	
	
	public Map<String, String> getCategoryList() {
		return categoryList;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	public Product(String productName, String productBrand, String productModel, double productPrice, int unitInStock,
			String productCategory, String productDescription, String productStatus, double discount,
			MultipartFile productImage) {
		super();
		this.productName = productName;
		this.productBrand = productBrand;
		this.productModel = productModel;
		this.productPrice = productPrice;
		this.unitInStock = unitInStock;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productStatus = productStatus;
		this.discount = discount;
		this.productImage = productImage;
	}
	
	
	public Product() {
		
		
	    categoryList=new HashMap<>();
		categoryList.put("Lifestyle", "Lifestyle Shoes");
		categoryList.put("Running", "Running Shoes");
		categoryList.put("Football", "Football Boots");
		categoryList.put("TShirts", "T-Shirts");
		categoryList.put("LongSleeve", "Long Sleeve Shirts");
		categoryList.put("Sleeveless", "Sleeveless & Tank Tops");
		categoryList.put("Polos", "Polos");
		categoryList.put("Shorts", "Shorts");
		categoryList.put("Jogger", "Jogger Pants");
		categoryList.put("Bags", "Bags");
		categoryList.put("Hats", "Hats");
		categoryList.put("Socks", "Socks");
		categoryList.put("Trousers", "Trousers");
		categoryList.put("Training", "Training & Gym Shoes");
		categoryList.put("Athletics", "Athletics Shoes");
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductBrand() {
		return productBrand;
	}


	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}


	public String getProductModel() {
		return productModel;
	}


	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}


	


	

	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public String getProductStatus() {
		return productStatus;
	}


	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}


	


	public Double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


	public Integer getUnitInStock() {
		return unitInStock;
	}


	public void setUnitInStock(Integer unitInStock) {
		this.unitInStock = unitInStock;
	}


	public Double getDiscount() {
		return discount;
	}


	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public MultipartFile getProductImage() {
		return productImage;
	}


	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}


	


	

	
	
	
	
	
}
