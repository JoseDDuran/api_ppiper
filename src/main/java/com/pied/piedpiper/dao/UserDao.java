package com.pied.piedpiper.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pied.piedpiper.model.User;
import com.pied.piedpiper.repository.UserRepository;

@Service
public class UserDao {
	@Autowired
	UserRepository userRepo;
	
	@PersistenceContext 
	private EntityManager entityManager;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}
	
	public User saveUser(User user){
		return userRepo.save(user);
	}
	
	public Optional<User> findOne(Long id){
		return userRepo.findById(id);
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	public List<Object[]> getInformationByEmail(Map<String, Object> json) {
		String email = json.get("email").toString();
		String password = json.get("password").toString();
		return entityManager.createNativeQuery("SELECT u.iduser, u.name, u.lastname,u.email,u.description ,u.idrol,u.url_profile FROM"
				+ " user u WHERE u.email = :email AND u.password = :password")
				.setParameter("email", email).setParameter("password", password).getResultList();
	} 
	
	public List<Object[]> getDescriptionById(Map<String, Object> json){
		int iduser = Integer.parseInt(json.get("iduser").toString());
		return entityManager.createNativeQuery("SELECT * FROM user WHERE iduser = :id")
				.setParameter("id", iduser).getResultList();
	}
	
	
	
	
}
