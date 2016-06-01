package com.hrs.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="HRS_ROOMS")
public class Room implements Serializable{


	private static final long serialVersionUID = -9218309151169088300L;

		@Id
		@Column(name="R_ID")
		private Integer id; 
		
		@OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="R_TYPE")
		private RoomType type; 
		
		@Column(name="R_FLOOR")
		private Integer floor; 
		
		@Column(name="R_NUM")
        private Integer number;
		
		@OneToMany(mappedBy="room", targetEntity = Booking.class)
		@LazyCollection(LazyCollectionOption.FALSE)
		private List<Booking> bookings = null;
		
		public Room(){}

		public Room(Integer id, RoomType type, Integer floor, Integer number, List<Booking> bookings) {
			super();
			this.id = id;
			this.type = type;
			this.floor = floor;
			this.number = number;
			this.bookings = bookings;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public RoomType getType() {
			return type;
		}

		public void setType(RoomType type) {
			this.type = type;
		}

		public Integer getFloor() {
			return floor;
		}

		public void setFloor(Integer floor) {
			this.floor = floor;
		}

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public List<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(List<Booking> bookings) {
			this.bookings = bookings;
		}

		@Override
		public String toString() {
			return "Room [id=" + id + ", type=" + type + ", floor=" + floor + ", number=" + number + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bookings == null)||(bookings.isEmpty()) ? 0 : bookings.hashCode());
			result = prime * result + ((floor == null) ? 0 : floor.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((number == null) ? 0 : number.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			//System.out.println("JFISDFOESSFOKFSNEFOESKFOESKFKDSFJEOSFDKG");
			if (this == obj)
				return true;
			if (obj == null){
				System.out.println("1");
				return false;
			}
			if (getClass() != obj.getClass()){
				System.out.println("2");
				return false;
			}
			Room other = (Room) obj;
			if (bookings == null) {
				if (other.bookings != null){
					System.out.println("3");
					return false;
				}
			} else if (!bookings.equals(other.bookings)){
				if(bookings.isEmpty()){
					System.out.println("this's bookings are empty");
					if(other.bookings.isEmpty()){
					//System.out.println("Other is empty too");
					}
					else{
						System.out.println("3");
						return false;
				}
				}
				else {
					System.out.println("4");
					return false;
			    }
				//System.out.println("The problem is that bookings is not equal to other bookings");
				//return false;
			}
			if (floor == null) {
				if (other.floor != null){
					System.out.println("5");
					return false;
				}
			} else if (!floor.equals(other.floor)){
				System.out.println("6");
				return false;
			}
			if (id == null) {
				if (other.id != null){
					System.out.println("7");
					return false;
				}
			} else if (!id.equals(other.id)){
				System.out.println("8");
				return false;
		}
			if (number == null) {
				if (other.number != null){
					System.out.println("9");
					return false;
				}
			} else if (!number.equals(other.number)){
				System.out.println("10");
				return false;
			}
			if (type == null) {
				if (other.type != null){
					System.out.println("11");
					return false;
				}
			} else if (!type.equals(other.type)){
				System.out.println("12");
				System.out.println(type);
				System.out.println(other.type);
				return false;
		}
			return true;
		}
		
		
}
