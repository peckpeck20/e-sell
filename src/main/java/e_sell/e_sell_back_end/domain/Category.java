package e_sell.e_sell_back_end.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	//@id creates an ID column for the table
	@Id
	//Generates automatically a unique PK for every new entity object
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String type;
	
	//constructor
	public Category() {}
	
	public Category(String type) {
		super();
		this.type = type;
	}
	
	
	
	//getters n setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type + "]";
	}

	
	
	
	
	
}
