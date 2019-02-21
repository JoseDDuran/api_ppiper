package com.pied.piedpiper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pied.piedpiper.model.Follower;
import com.pied.piedpiper.repository.FollowerRepository;

@Service
public class FollowerDao {
	@Autowired
	FollowerRepository followerRepo;
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Transactional
	public void createFollower(Long idfollower) {
		entityManager.joinTransaction();
		entityManager.createNativeQuery("INSERT INTO follower (idfollower) VALUES (:idfo)")
				.setParameter("idfo", idfollower).executeUpdate();
	}
	
}
