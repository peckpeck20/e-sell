package e_sell.e_sell_back_end.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
	
	//one user can have 0..* items
	@OneToMany(cascade= CascadeType.ALL,mappedBy ="user")
	private List<Item>items;
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	//generated ID column 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "userid",nullable=false,updatable=false)
	private long id;
	

	@NotNull
	@Column(name="firstname")
	@Size(min=2,max=30)
	private String firstName;
	
	@NotNull
	@Size(min=2,max=30)
	@Column(name="lastname")
	private String lastName;
	
	@NotNull
	@Size(min=2,max=50)
	@Column(name="email")
	private String email;
	 // Username with unique constraint
	@Column(name="username",nullable=false,unique=true)
	private String username;

	
	@Size(min=7)
	@Column(name="password",nullable=false)
	private String password;
	
	//what type of user it is
	@Column(name="role",nullable=false)
	//set default role of USER
	private String role ="USER";
	

	
	public User( ){
		
	};

	public User(String firstName, String lastName, String email, String username, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [items=" + items + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}



	
	
	
}
