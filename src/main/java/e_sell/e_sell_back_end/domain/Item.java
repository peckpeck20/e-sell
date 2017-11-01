package e_sell.e_sell_back_end.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


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
	private String zipcode;
	@NotNull
	private Double price;
	
	//constructor
	public Item(String title, String description, String condition, String zipcode, Double price) {
		super();
		this.title = title;
		this.description = description;
		this.condition = condition;
		this.zipcode = zipcode;
		this.price = price;
	}
	
	//JPA constructor should be PROTECTED
	public Item(){}
	
	




	//getter n setter
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
		
		
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", description=" + description + ", condition=" + condition
				+ ", zipcode=" + zipcode + ", price=" + price + "]";
	}

	
	

}
