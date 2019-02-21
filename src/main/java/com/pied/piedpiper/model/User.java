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
@Table(name="user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{
	
	@Id
	@Column(name="iduser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iduser;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="description")
	private String description;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="idrol")
	Rol rolUser;
	
	@OneToMany
	List<Album> albums;
	
	@OneToMany
	List<User_Follower> user_followers;
	
	@OneToMany
	List<Comment> comments;

	public User(Long iduser, String name, String lastname, String email, String description) {
		super();
		this.iduser = iduser;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.description = description;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<User_Follower> getUser_followers() {
		return user_followers;
	}

	public void setUser_followers(List<User_Follower> user_followers) {
		this.user_followers = user_followers;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	} 

}
