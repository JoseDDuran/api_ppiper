package com.pied.piedpiper.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pied.piedpiper.dao.FollowerDao;
import com.pied.piedpiper.dao.UserDao;
import com.pied.piedpiper.model.Follower;
import com.pied.piedpiper.model.User;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	
	@Autowired
	FollowerDao followerDao;
	
	@RequestMapping(value = "/user/crear" , method = RequestMethod.POST)
	public User createNewUser(@RequestBody User user) {
		User u = userDao.saveUser(user);
		followerDao.createFollower(u.getIduser());
		return u;		
	}
	
	@RequestMapping(value ="/user/usuarios" ,method = RequestMethod.GET)
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	@RequestMapping(value ="/user/usuarios/{id}",method = RequestMethod.GET)
	public User getUserById(@PathVariable(value = "id") Long id){
		if(userDao.findOne(id).isPresent()) {
			return userDao.findOne(id).get();
		} else {
			return null;
		}
	}
	
	@RequestMapping(value ="/user/login" ,method = RequestMethod.POST)
	public Map<String,Object> login(@RequestBody Map<String, Object> email ) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> response = userDao.getInformationByEmail(email);
		map.put("iduser", response.get(0)[0]);
		map.put("name", response.get(0)[1]);
		map.put("lastname", response.get(0)[2]);
		map.put("email", response.get(0)[3]);
		map.put("description", response.get(0)[4]);
		map.put("idrol", response.get(0)[5]);
		map.put("url_profile", response.get(0)[6]);
		return map;
	} 
	
	@RequestMapping(value ="/user/descripcion" ,method = RequestMethod.POST)
	public Map<String,Object> getDescription(@RequestBody Map<String, Object> profile ) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<Object[]> response = userDao.getDescriptionById(profile);
		map.put("iduser", response.get(0)[0]);
		map.put("name", response.get(0)[1]);
		map.put("lastname", response.get(0)[2]);
		map.put("email", response.get(0)[3]);
		map.put("password", response.get(0)[4]);
		map.put("description", response.get(0)[5]);
		map.put("idrol", response.get(0)[6]);
		return map;
	} 
	
	@RequestMapping(value = "/user/editar" ,method = RequestMethod.POST)
	public User putUser(@RequestBody Map<String, Object> userUpdate) {
		User user;
		if(userDao.findOne(Long.parseLong(userUpdate.get("iduser").toString())).isPresent()) {
			user = userDao.findOne(Long.parseLong(userUpdate.get("iduser").toString())).get();
			user.setName(userUpdate.get("name").toString());
			user.setLastname(userUpdate.get("lastname").toString());
			user.setEmail(userUpdate.get("email").toString());
			user.setDescription(userUpdate.get("description").toString());
			User updatedUser = userDao.saveUser(user);
			return updatedUser;
		} else {
			return null;
		}
	} 
	
}
