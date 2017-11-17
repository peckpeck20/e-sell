package e_sell.e_sell_back_end.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;



import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="item")
public class Item {
	//generated ID column 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="itemid")
	private long id;
	
	@NotNull
	@Column(name="title")
	private String title;
	
	@NotNull
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="condition")
	private String condition;
	
	@NotNull
	@Column(name="zipcode")
	private Integer zipcode;
	
	@NotNull
	@Column(name="price")
	private Double price;
	

	public Item(){}
	//
	public Item(String title, String description, String condition, Integer zipcode, Double price) {
		super();
		this.title = title;
		this.description = description;
		this.condition = condition;
		this.zipcode = zipcode;
		this.price = price;

	}	
	

	
	

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
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", description=" + description + ", condition=" + condition
				+ ", zipcode=" + zipcode + ", price=" + price + "]";
	}

	



	
	

}
