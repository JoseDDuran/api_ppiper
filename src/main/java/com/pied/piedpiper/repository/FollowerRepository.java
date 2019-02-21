package com.pied.piedpiper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pied.piedpiper.model.Follower;

@Repository
public interface FollowerRepository extends JpaRepository<Follower,Long> {

}
