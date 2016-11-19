package com.sample.test.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


	@Entity
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
	public class User implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		private Long id;

		@Temporal(TemporalType.DATE)
		@Column(name="user_dob")
		private Date userDob;

		@Column(name="user_firstname")
		private String userFirstname;

		@Column(name="user_lastname")
		private String userLastname;

		//bi-directional many-to-one association to UserRating
		@OneToMany(mappedBy="user")
		private List<UserRating> userRatings;

		public User() {
		}

	

	
    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }



    public Date getUserDob() {
			return this.userDob;
		}

		public void setUserDob(Date userDob) {
			this.userDob = userDob;
		}

		public String getUserFirstname() {
			return this.userFirstname;
		}

		public void setUserFirstname(String userFirstname) {
			this.userFirstname = userFirstname;
		}

		public String getUserLastname() {
			return this.userLastname;
		}

		public void setUserLastname(String userLastname) {
			this.userLastname = userLastname;
		}

		public List<UserRating> getUserRatings() {
			return this.userRatings;
		}

		public void setUserRatings(List<UserRating> userRatings) {
			this.userRatings = userRatings;
		}

		public UserRating addUserRating(UserRating userRating) {
			getUserRatings().add(userRating);
			userRating.setUser(this);

			return userRating;
		}

		public UserRating removeUserRating(UserRating userRating) {
			getUserRatings().remove(userRating);
			userRating.setUser(null);

			return userRating;
		}

	}

