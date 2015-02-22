package com.eyechamp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eyechamp.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {	
	public Player findByName(String name);
}
