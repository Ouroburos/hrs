package com.hrs.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Entity
@Table(name="HRS_RATINGS")
public class Rating implements Serializable{
	

	private static final long serialVersionUID = 7626660870802200166L;

		@Id
		@Column(name="RTS_ID")
		@GenericGenerator(name="generator", strategy="increment")
		@GeneratedValue(generator="generator")
		private Integer id; 
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="RTS_GUEST")
		private Customer guest;
		
		@Column(name="RTS_STARS")
		private Integer stars; 
		
		@NotEmpty
		@Column(name="RTS_COMMENTS")
		private String comments; 
		
		@Column(name="RTS_DATE")
		private Timestamp date;
		
		@Column(name="RTS_DISPLAY")
		private Boolean display;
		
		
		public Rating(){}

		public Rating(Integer id, Customer guest, Integer stars, String comments, Timestamp date, Boolean display) {
			super();
			this.id = id;
			this.guest = guest;
			this.stars = stars;
			this.comments = comments;
			this.date = date;
			this.display = display;
		}

		public Rating(Customer guest, Integer stars, String comments, Timestamp date, Boolean display) {
			super();
			this.guest = guest;
			this.stars = stars;
			this.comments = comments;
			this.date = date;
			this.display = display;
		}

		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Customer getGuest() {
			return guest;
		}

		public void setGuest(Customer guest) {
			this.guest = guest;
		}

		public Integer getStars() {
			return stars;
		}

		public void setStars(Integer stars) {
			this.stars = stars;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public Timestamp getDate() {
			return date;
		}

		public void setDate(Timestamp date) {
			this.date = date;
		}

		public Boolean getDisplay() {
			return display;
		}

		public void setDisplay(Boolean display) {
			this.display = display;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comments == null) ? 0 : comments.hashCode());
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + ((display == null) ? 0 : display.hashCode());
			result = prime * result + ((guest == null) ? 0 : guest.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((stars == null) ? 0 : stars.hashCode());
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
			Rating other = (Rating) obj;
			if (comments == null) {
				if (other.comments != null)
					return false;
			} else if (!comments.equals(other.comments))
				return false;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (display == null) {
				if (other.display != null)
					return false;
			} else if (!display.equals(other.display))
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
			if (stars == null) {
				if (other.stars != null)
					return false;
			} else if (!stars.equals(other.stars))
				return false;
			return true;
		}
				
	
}
