package com.pied.piedpiper.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="follower")
@EntityListeners(AuditingEntityListener.class)
public class Follower implements Serializable {
	
	@Id
	@Column(name="idfollower")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idfollower;
	
	@OneToMany(mappedBy="followerUser_Follower", cascade= CascadeType.ALL)
	List<User_Follower> user_followers;

	public Follower(Long idfollower) {
		super();
		this.idfollower = idfollower;
	}

	public Follower() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdfollower() {
		return idfollower;
	}

	public void setIdfollower(Long idfollower) {
		this.idfollower = idfollower;
	}

	public List<User_Follower> getUser_followers() {
		return user_followers;
	}

	public void setUser_followers(List<User_Follower> user_followers) {
		this.user_followers = user_followers;
	}
	
}
