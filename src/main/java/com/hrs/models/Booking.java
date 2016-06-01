package com.hrs.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.models.utils.FormatUtil;

@Transactional
@Entity
@Table(name = "HRS_BOOKING")
public class Booking implements Serializable {

	private static final long serialVersionUID = 3127911362491663502L;

	@Id
	@Column(name = "B_ID")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "B_ROOM")
	private Room room;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "B_GUEST")
	private Customer guest;

	@Column(name = "B_CHECKIN")
	private Timestamp checkIn;

	@Column(name = "B_CHECKOUT")
	private Timestamp checkOut;

	@ManyToMany(fetch=FetchType.EAGER)
//	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "HRS_BOOKING_AMENITIES", joinColumns = @JoinColumn(name = "B_ID"), inverseJoinColumns = @JoinColumn(name = "A_ID"))
	private List<Amenity> amenities;

	public Booking() {
	}

	public Booking(Integer id, Room room, Customer guest, Timestamp checkIn, Timestamp checkOut) {
		super();
		this.id = id;
		this.room = room;
		this.guest = guest;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Customer getGuest() {
		return guest;
	}

	public void setGuest(Customer guest) {
		this.guest = guest;
	}

	public Timestamp getCheckIn(){
		return checkIn;
	}
	public String getFormattedCheckIn() {
		return FormatUtil.getFormattedTs(checkIn);
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return FormatUtil.getFormattedTs(checkOut);
	}

	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}

	public List<Amenity> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	@Override
	public String toString() {
		StringBuilder bookingInfo = new StringBuilder(room.getType().getName());
		if(!(amenities.isEmpty() || amenities == null)){
			bookingInfo.append(" Amenities: ");
			String comma = "";
			for(Amenity a: amenities){
				bookingInfo.append(comma);
				comma = ",";
				bookingInfo.append(a);
			}
		}
		bookingInfo.append(" check in: " + FormatUtil.getFormattedTs(checkIn));
		bookingInfo.append(" check out: " + FormatUtil.getFormattedTs(checkOut));
		return bookingInfo.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amenities == null)||(amenities.isEmpty()) ? 0 : amenities.hashCode());
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result + ((checkOut == null) ? 0 : checkOut.hashCode());
		result = prime * result + ((guest == null) ? 0 : guest.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
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
		Booking other = (Booking) obj;
		if (amenities == null) {
			if (other.amenities != null)
				return false;
		} else if (!amenities.equals(other.amenities))
			if(amenities.isEmpty()){
				//System.out.println("this's bookings are empty");
				if(other.amenities.isEmpty()){
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
		if (checkIn == null) {
			if (other.checkIn != null)
				return false;
		} else if (!checkIn.equals(other.checkIn))
			return false;
		if (checkOut == null) {
			if (other.checkOut != null)
				return false;
		} else if (!checkOut.equals(other.checkOut))
			return false;
		if (guest == null) {
			if (other.guest != null)
				return false;
		} else if (!guest.equals(other.guest))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

	
}
