package com.springmvc.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
public class Ratings implements Serializable{
	 
	@Column(name="rating")
private int rate;
	@Id
	@Column(name="username")
private String username;

	@Id
	@Column(name="mid")
	private int mid;
	@ManyToOne(optional = false)
@JoinColumn(name = "username")
	private User user;


public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
*/public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}

}
