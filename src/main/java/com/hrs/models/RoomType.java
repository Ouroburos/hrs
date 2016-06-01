package com.hrs.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="HRS_ROOMTYPE")
public class RoomType implements Serializable{
	
	  
	private static final long serialVersionUID = 6926376675679481858L;

		@Id
		@Column(name="RT_ID")
		private Integer id; 
		
		@Column(name="RT_TYPE")
		private String name;
		
		@Column(name="RT_DESCRIPTION")
		private String description; 
		
		@Column(name="RT_CAPACITY")
		private Integer capacity; 
		
		@Column(name="RT_PRICE")
        private Double price;
		
		@ManyToMany
		@LazyCollection(LazyCollectionOption.FALSE)
		@JoinTable(name="HRS_TYPE_AMENITIES", joinColumns=@JoinColumn(name="RT_ID"), inverseJoinColumns=@JoinColumn(name="A_ID"))
		private List<Amenity> amenities; 
		
		
		public RoomType(){}

		public RoomType(Integer id, String name, String description, Integer capacity, Double price) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.capacity = capacity;
			this.price = price;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Amenity> getAmenities() {
			return amenities;
		}

		public void setAmenities(List<Amenity> amenities) {
			this.amenities = amenities;
		}

		public Integer getCapacity() {
			return capacity;
		}

		public void setCapacity(Integer capacity) {
			this.capacity = capacity;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "RoomType [id=" + id + ", name=" + name + ", description=" + description + ", capacity=" + capacity
					+ ", price=" + price + ", amenities=" + amenities + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((amenities == null)||(amenities.isEmpty()) ? 0 : amenities.hashCode());
			result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null){
				System.out.println("13");
				return false;
			}
			if (getClass() != obj.getClass()){
				System.out.println("14");
				return false;
			}
			RoomType other = (RoomType) obj;
			if (amenities == null) {
				if (other.amenities != null){
					System.out.println("15");
					return false;
				}
			} else if (!myListEquals(amenities, other.amenities))
				if(amenities.isEmpty()){
					//System.out.println("this's amenities are empty");
					if(other.amenities.isEmpty()){
					//System.out.println("Other is empty too");
					}
					else{
						System.out.println("16");
						return false;
					}
				} else {
					System.out.println("17");
					System.out.println(amenities);
					System.out.println(other.amenities);
					return false;
			    }
				//System.out.println("The problem is that bookings is not equal to other bookings");
				//return false;
			if (capacity == null) {
				if (other.capacity != null){
					System.out.println("18");
					return false;
				}
			} else if (!capacity.equals(other.capacity))
				return false;
			if (description == null) {
				if (other.description != null){
					System.out.println("19");
					return false;
				}
			} else if (!description.equals(other.description)){
				System.out.println("20");
				return false;
			}
			if (id == null) {
				if (other.id != null){
					System.out.println("21");
					return false;
				}
			} else if (!id.equals(other.id)){
				System.out.println("22");
				return false;
			}
			if (name == null) {
				if (other.name != null){
					System.out.println("23");
					return false;
				}
			} else if (!name.equals(other.name)){
				System.out.println("24");
				return false;
			}
			if (price == null) {
				if (other.price != null){
					System.out.println("25");
					return false;
				}
			} else if (!price.equals(other.price)){
				System.out.println("26");
				return false;
			}
			return true;
		}		
		
		public <T> boolean myListEquals(List<T> a, List<T> b){
			
			if(a.size() != b.size()){
				return false;
			}
			
			for(int i=0;i<a.size();i++){
				if(!(a.get(i).equals(b.get(i)))){
					return false;
				}
			}
			
			return true;
		}
		
}
