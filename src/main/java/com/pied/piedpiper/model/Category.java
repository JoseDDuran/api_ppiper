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
@Table(name="category")
@EntityListeners(AuditingEntityListener.class)
public class Category implements Serializable {
	
	@Id
	@Column(name="idcategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcategory;
	
	@Column(name="category")
	private String category;
	
	@OneToMany(mappedBy="categorySong", cascade= CascadeType.ALL)
	List<Song> songs;

	public Category(int idcategory, String category) {
		super();
		this.idcategory = idcategory;
		this.category = category;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
}
