package com.sample.test.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "dob")
	private Date dateOfBirth;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	// bi-directional many-to-one association to UserRating
	@OneToMany(mappedBy = "user")
	private List<UserRating> ratings;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<UserRating> getUserRatings() {
		return this.ratings;
	}

	public void setUserRatings(List<UserRating> userRatings) {
		this.ratings = userRatings;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
