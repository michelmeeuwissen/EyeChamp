package com.eyechamp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="players")
public class Player {
	
	@Id
    private String name;

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    /** Getters and Setters**/
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
