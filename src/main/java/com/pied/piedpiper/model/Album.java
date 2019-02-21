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
@Table(name="album")
@EntityListeners(AuditingEntityListener.class)
public class Album implements Serializable{
	
	@Id
	@Column(name="idalbum")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idalbum;
	
	@Column(name="album")
	private String album;
	
	@Column(name="description")
	private String description;
	
	@Column(name="foto")
	private String foto;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="iduser")
	User userAlbum;
	
	@OneToMany(mappedBy="albumComment", cascade= CascadeType.ALL)
	List<Comment> comments;
	
	@OneToMany(mappedBy="albumSong", cascade= CascadeType.ALL)
	List<Song> songs;

	public Album(Long idalbum, String album, String description, String foto) {
		super();
		this.idalbum = idalbum;
		this.album = album;
		this.description = description;
		this.foto = foto;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdalbum() {
		return idalbum;
	}

	public void setIdalbum(Long idalbum) {
		this.idalbum = idalbum;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

}
