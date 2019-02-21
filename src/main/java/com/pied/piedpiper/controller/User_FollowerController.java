package com.pied.piedpiper.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pied.piedpiper.dao.User_FollowerDao;

@RestController
public class User_FollowerController {
	@Autowired
	User_FollowerDao user_FollowerDao;
	
	@RequestMapping(value = "/user_follower/crear" , method = RequestMethod.POST)
	public Map<String,Object> createRelationPath(@RequestBody Map<String, Integer> ids){
		Map<String,Object> map = new HashMap<String, Object>();
		Long iduser = ids.get("iduser").longValue();
		Long idfollower = ids.get("idfollower").longValue();
		try {
			user_FollowerDao.createRelation(iduser, idfollower);
			user_FollowerDao.createRelation(idfollower, iduser);
			map.put("message", "Relacion exitosa");
		} catch(Exception e) {
			System.out.println("error : " + e.getMessage());
			map.put("message", "Error al crear la relación");
		} finally {
			return map;
		}
		
	} 
	
	@RequestMapping(value = "/user_follower/eliminar" , method = RequestMethod.POST)
	public Map<String,Object> deleteRelationPath(@RequestBody Map<String, Integer> ids){
		Map<String,Object> map = new HashMap<String, Object>();
		Long iduser = ids.get("iduser").longValue();
		Long idfollower = ids.get("idfollower").longValue();
		try {
			user_FollowerDao.deleteRelation(iduser,idfollower);
			user_FollowerDao.deleteRelation(idfollower,iduser);
			map.put("message", "Relacion eliminada");
		} catch(Exception e) {
			System.out.println("error : " + e.getMessage());
			map.put("message", "Error al eliminar");
		} finally {
			return map;
		}
		
	} 
}
