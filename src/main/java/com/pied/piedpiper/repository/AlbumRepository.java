package com.pied.piedpiper.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pied.piedpiper.model.Album;
import com.pied.piedpiper.model.User;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

}
