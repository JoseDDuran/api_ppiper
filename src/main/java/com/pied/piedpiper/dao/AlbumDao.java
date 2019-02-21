package com.pied.piedpiper.dao;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pied.piedpiper.model.Album;
import com.pied.piedpiper.model.User;
import com.pied.piedpiper.repository.AlbumRepository;

@Service
public class AlbumDao {
	@Autowired
	AlbumRepository albumRepo;
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	public List<Object[]> getRandomAlbumes() {
		return entityManager.createNativeQuery("SELECT * FROM album ORDER BY RAND() LIMIT 2").getResultList();
	} 
	
	public List<Object[]> getMyAlbumesById(Long iduser){
		return entityManager.createNativeQuery("SELECT * FROM album WHERE iduser = :iduser")
				.setParameter("iduser", iduser).getResultList();
	}
	
	public Album saveAlbum(Album album) {
		return albumRepo.save(album);
	}
	
	public void deleteAlbum(Long id) {
		albumRepo.deleteById(id);
	}
	
	public Album findAlbum(Long id){
		if(albumRepo.findById(id).isPresent()) {
			return albumRepo.findById(id).get();
		} else {
			return null;
		}
	}
	
	public Album updateAlbum(Album albumUp) {
		Album album = this.findAlbum(Long.parseLong(String.valueOf(albumUp.getIdalbum())));
		album.setAlbum(albumUp.getAlbum());
		album.setFoto(albumUp.getFoto());
		album.setDescription(albumUp.getDescription());
		
		Album albumUpdated = this.saveAlbum(album);
		return albumUpdated;
		
	}
	
}
