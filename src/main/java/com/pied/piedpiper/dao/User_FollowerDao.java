package com.pied.piedpiper.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User_FollowerDao {
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Transactional
	public void createRelation(Long iduser, Long idfollower) {
		entityManager.joinTransaction();
		entityManager.createNativeQuery("INSERT INTO user_follower (iduser,idfollower) VALUES (:iduser,:idfollower)")
				.setParameter("iduser", iduser).setParameter("idfollower", idfollower).executeUpdate();
	}
	
	@Transactional
	public void deleteRelation(Long iduser,Long idfollower) {
		entityManager.joinTransaction();
		entityManager.createNativeQuery("DELETE FROM user_follower WHERE iduser=:iduser AND idfollower=:idfollower")
			.setParameter("iduser", iduser).setParameter("idfollower", idfollower).executeUpdate();
	}
}
