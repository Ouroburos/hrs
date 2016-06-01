package com.hrs.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
@Table(name="HRS_CUSTOMER")
public class Customer implements Serializable{
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", reservations="
				+ reservations + "]";
	}


	private static final long serialVersionUID = 774153741493081654L;

	@Id
	@Column(name="C_ID")
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	private Integer id; 
	
	@NotEmpty
	@Column(name="C_FIRSTNAME")
	private String firstname;
	
	@NotEmpty
	@Column(name="C_LASTNAME")
	private String lastname;
	
	@NotEmpty
//	@Size(min=10, max=11)
	@Column(name="C_PHONE")
	private String phone;
	
	@NotEmpty
	@Column(name="C_EMAIL")
	private String email;
	
	@NotEmpty(message="Please enter a username")
	@Size(min=4, max=20)
	@Column(name="C_USERNAME")
	private String username;
	
	@NotEmpty
	@Column(name="C_PASSWORD")
	private String password;

	@OneToMany(mappedBy="guest", targetEntity = Booking.class)
	@LazyCollection(LazyCollectionOption.FALSE)	
	@OrderBy("id DESC")
    private List<Booking> reservations; 	
	
	
	public Customer(){}
	
	
	public Customer(Integer id, String firstname, String lastname, String phone, String email, String username,
			String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public Customer(String firstname, String lastname, String phone, String email, String username,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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


	public List<Booking> getReservations() {
		return reservations;
	}


	public void setReservations(List<Booking> reservations) {
		this.reservations = reservations;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((reservations == null)||(reservations.isEmpty()) ? 0 : reservations.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			if(reservations.isEmpty()){
				//System.out.println("this's bookings are empty");
				if(other.reservations.isEmpty()){
				//System.out.println("Other is empty too");
				}
				else
					return false;
			}
			else {
				return false;
		    }
			//System.out.println("The problem is that bookings is not equal to other bookings");
			//return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	} 

}
