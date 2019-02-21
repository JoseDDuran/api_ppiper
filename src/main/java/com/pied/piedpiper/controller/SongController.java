package com.pied.piedpiper.controller;
import java.util.ArrayList;
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

import com.pied.piedpiper.dao.AlbumDao;
import com.pied.piedpiper.dao.SongDao;
import com.pied.piedpiper.model.Song;

@RestController
public class SongController {
	@Autowired
	SongDao songDao;
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(value ="/song/random" ,method = RequestMethod.GET)
	public List<Map<String,Object>> sendRandomSongs() {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map;
		List<Object[]> response = songDao.getRandomSongs();
		for(int i = 0 ; i < response.size() ; i++) {
			map = new HashMap<String, Object>();
			map.put("idsong", response.get(i)[0]);
			map.put("song", response.get(i)[1]);
			map.put("composer", response.get(i)[2]);
			map.put("song_url", response.get(i)[3]);
			map.put("description", response.get(i)[4]);
			map.put("idalbum", response.get(i)[5]);
			map.put("idcategory", response.get(i)[6]);
			list.add(map);
		}
		return list;
	} 
	
	@RequestMapping(value = "/song/search" , method = RequestMethod.POST)
	public List<Map<String,Object>> searchSongsByText(@RequestBody Map<String, Object> text){
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String, Object> map;
		if(!text.get("searchText").toString().equals("")) {
			List<Object[]> response = songDao.getSongsByParam(text.get("searchText").toString() + '%');
			for	(int i = 0 ; i < response.size() ; i++) {
				map = new HashMap<String, Object>();
				map.put("idsong", response.get(i)[0]);
				map.put("song", response.get(i)[1]);
				map.put("composer", response.get(i)[2]);
				map.put("song_url", response.get(i)[3]);
				map.put("description", response.get(i)[4]);
				map.put("idalbum", response.get(i)[5]);
				map.put("album_url", albumDao.findAlbum(Long.parseLong(response.get(i)[5].toString())).getFoto());
				map.put("idcategory", response.get(i)[6]);
				list.add(map);
			}
			return list;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/song/por_usuario" , method = RequestMethod.POST)
	public List<Map<String,Object>> searchSongsByUser(@RequestBody Map<String, Object> userJSON){
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String, Object> map;
		Long iduser = Long.parseLong(userJSON.get("iduser").toString());
		List<Object[]> response = songDao.getSongsByIdUser(iduser);
		for (int i = 0 ; i < response.size() ; i++) {
			map = new HashMap<String, Object>();
			map.put("idsong", response.get(i)[0]);
			map.put("song", response.get(i)[1]);
			map.put("composer", response.get(i)[2]);
			map.put("song_url", response.get(i)[3]);
			map.put("description", response.get(i)[4]);
			map.put("idalbum", response.get(i)[5]);
			map.put("idcategory", response.get(i)[6]);
			list.add(map);
		}
		return list;
	}
	
	
}
