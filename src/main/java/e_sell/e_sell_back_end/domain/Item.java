package e_sell.e_sell_back_end.domain;

import javax.validation.constraints.NotNull;

//import java.io.Serializable;

public class Item {
	//implement Serializable
	//implements Serializable
	//private static final long serialVersionUID = 1L;
	@NotNull
	private String title;
	@NotNull
	private String description;
	@NotNull
	private String condition;
	@NotNull
	private String zipcode;
	
	private double price;
	
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
		return "Item [title=" + title + ", description=" + description + ", condition=" + condition + ", zipcode="
				+ zipcode + ", price=" + price + ", gettitle()=" + gettitle() + ", getDescription()=" + getDescription()
				+ ", getCondition()=" + getCondition() + ", getzipcode()=" + getzipcode() + ", getPrice()=" + getPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
