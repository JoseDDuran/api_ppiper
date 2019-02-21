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
import com.pied.piedpiper.model.Album;
import com.pied.piedpiper.model.User;

@RestController
public class AlbumController {
	@Autowired
	AlbumDao albumDao;
	
	@Autowired
	SongDao songDao;
	
	@RequestMapping(value ="/album/random" ,method = RequestMethod.GET)
	public List<Map<String,Object>> sendRandomAlbumes() {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map;
		List<Object[]> response = albumDao.getRandomAlbumes();
		for(int i = 0 ; i < response.size() ; i++) {
			map = new HashMap<String, Object>();
			map.put("idalbum", response.get(i)[0]);
			map.put("album", response.get(i)[1]);
			map.put("description", response.get(i)[2]);
			map.put("foto", response.get(i)[3]);
			map.put("iduser", response.get(i)[4]);
			list.add(map);
		}
		return list;
	} 
	
	
	@RequestMapping(value ="/album/listar" ,method = RequestMethod.POST)
	public List<Map<String,Object>> getAlbumes(@RequestBody Map<String, Integer> JSONid) {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map;
		List<Object[]> response = albumDao.getMyAlbumesById(JSONid.get("iduser").longValue());
		for(int i = 0 ; i < response.size() ; i++) {
			map = new HashMap<String, Object>();
			map.put("idalbum", response.get(i)[0]);
			map.put("album", response.get(i)[1]);
			map.put("description", response.get(i)[2]);
			map.put("foto", response.get(i)[3]);
			map.put("iduser", response.get(i)[4]);
			list.add(map);
		}
		return list;
	} 
	
	@RequestMapping(value ="/album/obtener_canciones" ,method = RequestMethod.POST)
	public Map<String,Object> getSongsByIdAlbum(@RequestBody Map<String, Integer> JSONid) {
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> map;
		Album album = albumDao.findAlbum(JSONid.get("idalbum").longValue());
		List<Object[]> response = songDao.getSongssByIdAlbum(album.getIdalbum());
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
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("album", album.getAlbum());
		map2.put("url_album", album.getFoto());
		map2.put("songs", list);
		return map2;
	} 
	
	@RequestMapping(value ="/album/editar" ,method = RequestMethod.POST)
	public Album updateAlbum(@RequestBody Map<String, Object> albumRequest) {
		Album album = albumDao.findAlbum(Long.parseLong(albumRequest.get("idalbum").toString()));
		album.setAlbum((albumRequest.get("album").toString()));
		album.setDescription((albumRequest.get("description").toString()));
		Album albumNew = albumDao.saveAlbum(album);
		return albumNew;
	} 
}
