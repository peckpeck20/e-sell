package e_sell.e_sell_back_end.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="item")
public class Item {
	//generated ID column 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="itemid")
	private Long id;
	
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private String status;
	
	
	@Column(name="zipcode",length=5)
	private Integer zipcode;
	
	@Column(name="price")
	private Double price;
	

	//many items can be 1 user *..1
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="userid")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	
	//Many items can have 1 category *..1
	@ManyToOne
    @JsonIgnore
	@JoinColumn(name = "categoryid")
private Category category;

	//working ^^
	//JPA constructor
	public Item(){
	
	}

	public Item( String title, String description, String status, Integer zipcode, Double price,
			Category category) {
		super();

		this.title = title;
		this.description = description;
		this.status = status;
		this.zipcode = zipcode;
		this.price = price;
		this.category = category;
	}

	
	
	public Item(String title, String description, String status, Integer zipcode, Double price, Category category,
			User user) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.zipcode = zipcode;
		this.price = price;
		this.user = user;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", zipcode=" + zipcode + ", price=" + price + ", user=" + user + ", category=" + category + "]";
	}


	
	
}

	