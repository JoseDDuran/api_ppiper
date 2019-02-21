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
@Table(name="song")
@EntityListeners(AuditingEntityListener.class)
public class Song implements Serializable{
	
	@Id
	@Column(name="idsong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idsong;
	
	@Column(name="song")
	private String song;
	
	@Column(name="composer")
	private String composer;
	
	@Column(name="song_url")
	private String song_url;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="idalbum")
	Album albumSong;
	
	@ManyToOne(optional=true , fetch=FetchType.EAGER)
	@JoinColumn(name="idcategory")
	Category categorySong;

	public Song(int idsong, String song, String composer, String song_url, String description) {
		super();
		this.idsong = idsong;
		this.song = song;
		this.composer = composer;
		this.song_url = song_url;
		this.description = description;
	}

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdsong() {
		return idsong;
	}

	public void setIdsong(int idsong) {
		this.idsong = idsong;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getSong_url() {
		return song_url;
	}

	public void setSong_url(String song_url) {
		this.song_url = song_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
