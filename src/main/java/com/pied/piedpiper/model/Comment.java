package com.pied.piedpiper.model;

import java.io.Serializable;

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
@Table(name="comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment implements Serializable {
	
	@Id
	@Column(name="idcomment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcomment;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="iduser")
	User userComment;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="idalbum")
	Album albumComment;

	public Comment(int idcomment, String comment) {
		super();
		this.idcomment = idcomment;
		this.comment = comment;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdcomment() {
		return idcomment;
	}

	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
