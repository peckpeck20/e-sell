package e_sell.e_sell_back_end.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//import java.io.Serializable;

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
	private double price;
	
	//JPA constructor should be PROTECTED
	public Item(){}
	
	
	//constructor
	public Item(String title, String description, String condition, String zipcode, double price) {
		super();
		this.title = title;
		this.description = description;
		this.condition = condition;
		this.zipcode = zipcode;
		this.price = price;
	}



	//getter n setter
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
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
	public String getzipcode() {
		return zipcode;
	}
	public void setzipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
		
		
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", description=" + description + ", condition=" + condition
				+ ", zipcode=" + zipcode + ", price=" + price + "]";
	}

	
	

}
