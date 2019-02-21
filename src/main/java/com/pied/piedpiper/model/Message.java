package com.pied.piedpiper.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="message")
@EntityListeners(AuditingEntityListener.class)
public class Message implements Serializable {
	
	@Id
	@Column(name="idmessage")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmessage;
	
	@Column(name="idemisor")
	private int idemisor;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="message")
	private String message;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="iduser_follower")
	User_Follower user_followerMessage;

	public Message(int idmessage, int idemisor, Date fecha, String message) {
		super();
		this.idmessage = idmessage;
		this.idemisor = idemisor;
		this.fecha = fecha;
		this.message = message;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdmessage() {
		return idmessage;
	}

	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}

	public int getIdemisor() {
		return idemisor;
	}

	public void setIdemisor(int idemisor) {
		this.idemisor = idemisor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
