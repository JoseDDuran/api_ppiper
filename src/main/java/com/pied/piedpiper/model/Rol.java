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
@Table(name="rol")
@EntityListeners(AuditingEntityListener.class)
public class Rol implements Serializable{
	
	@Id
	@Column(name="idrol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrol;
	
	@Column(name="rol")
	private String rol;
	
	@OneToMany(mappedBy="rolUser", cascade= CascadeType.ALL)
	List<User> users;

	public Rol(int idrol, String rol) {
		super();
		this.idrol = idrol;
		this.rol = rol;
	}

	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
