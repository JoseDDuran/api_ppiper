package com.pied.piedpiper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pied.piedpiper.repository.SongRepository;

@Service
public class SongDao {
	@Autowired
	SongRepository songRepository;
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	public List<Object[]> getRandomSongs() {
		return entityManager.createNativeQuery("SELECT * FROM song ORDER BY RAND() LIMIT 3").getResultList();
	} 
	
	public List<Object[]> getSongsByParam(String text){
		return entityManager.createNativeQuery("SELECT * FROM song WHERE song LIKE :param LIMIT 10")
				.setParameter("param", text).getResultList();
	}
	
	public List<Object[]> getSongsByIdUser(Long iduser){
		return entityManager.createNativeQuery("SELECT s.idsong, s.song, s.composer, s.song_url, s.description, s.idalbum, s.idcategory FROM"
				+ " song s,album a,user u WHERE s.idalbum = a.idalbum AND a.iduser = u.iduser AND u.iduser = :iduser")
				.setParameter("iduser", iduser).getResultList();
	}
	
	public List<Object[]> getSongssByIdAlbum(Long idalbum){
		return entityManager.createNativeQuery("SELECT * FROM song WHERE idalbum = :idalbum")
				.setParameter("idalbum", idalbum).getResultList();
				
	}
}
