package com.hrs.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
@Table(name = "HRS_AMENITIES")
public class Amenity implements Serializable {

	private static final long serialVersionUID = 6897795809402551838L;

	@Id
	@Column(name = "A_ID")
	private Integer id;

	@Column(name = "A_TYPE")
	private String type;

	@Column(name = "A_PRICE")
	private Double price;

	public Amenity() {
	}

	public Amenity(Integer id, String type, Double price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("in amenty equals******");
		if (this == obj)
			return true;
		if (obj == null) {
			System.out.println("27");
			return false;
		}
		if (getClass() != obj.getClass()) {
			System.out.println("28");
			return false;
		}
		Amenity other = (Amenity) obj;
		if (id == null) {
			if (other.id != null) {
				System.out.println("29");
				return false;
			}
		} else if (!id.equals(other.id)) {
			System.out.println("30");
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				System.out.println("31");
				return false;
			}
		} else if (!price.equals(other.price)) {
			System.out.println("32");
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				System.out.println("33");
				return false;
			}
		} else if (!type.equals(other.type)) {
			System.out.println("34");
			return false;
		}
		return true;
	}

}
