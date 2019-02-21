package com.pied.piedpiper.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="user_follower")
@EntityListeners(AuditingEntityListener.class)
public class User_Follower implements Serializable {
	
	@Id
	@Column(name="iduser_follower")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduser_follower;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="iduser")
	User userUser_follower;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="idfollower")
	Follower followerUser_Follower;
	
	@OneToMany(mappedBy="user_followerMessage", cascade= CascadeType.ALL)
	List<Message> messages;

	public User_Follower(int iduser_follower) {
		super();
		this.iduser_follower = iduser_follower;
	}

	public User_Follower() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIduser_follower() {
		return iduser_follower;
	}

	public void setIduser_follower(int iduser_follower) {
		this.iduser_follower = iduser_follower;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
