package e_sell.e_sell_back_end.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Item {
	//generated ID column 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String title;
	@NotNull
	private String description;
	@NotNull
	private String condition;
	@NotNull
	private Integer zipcode;
	@NotNull
	@DecimalMin(value="0.1")
	private Double price;
	
	//create relationship or * to 1 between items to user
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userid")
	private User user;
	
	
	//Many items can have 1 category * to 1
	@ManyToOne
    /*entity relationship will
    cause endless loop (First student is serialized and it contains
    department which is then serialized which contains students which
    are then serialized
    */
    @JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;


	//constructor
	public Item(String title, String description, String condition, Integer zipcode, Double price, Category category, User user) {
		super();
		this.title = title;
		this.description = description;
		this.condition = condition;
		this.zipcode = zipcode;
		this.price = price;
		//added category as a FK in the relationship
		this.category = category;
		//added User as FK
		this.user = user;
	}	
	
	//JPA constructor should be PROTECTED
	public Item(){}
	
	

	//getter n setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
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
	//setters n getters for relationship
	
	public User getUser() {
			return user;
	}

	public void setUser(User user) {
			this.user = user;
	}
	
	
	//relationship G&S
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", description=" + description + ", condition=" + condition
				+ ", zipcode=" + zipcode + ", price=" + price + "]";
	}



	
	

}
