package com.eyechamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eyechamp.model.Player;
import com.eyechamp.repositories.PlayerRepository;

@Controller
public class ChampController {	
	@Autowired
	private PlayerRepository playerRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getViews()	throws Exception {
		List<Player> players = playerRepository.findAll();
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("players", players );
		return modelAndView;
	}
	
	@RequestMapping(value = "/player/add/{name}", method = RequestMethod.GET)
	public ModelAndView addPlayer(@PathVariable String name) throws Exception {
		if(name.length()>0 && playerRepository.findByName(name) == null){
			Player player = new Player(name);
			playerRepository.save(player);
		}
		return getViews();
	}
	
	@RequestMapping(value = "/player/remove/{name}", method = RequestMethod.GET)
	public ModelAndView removePlayer(@PathVariable String name) throws Exception {
		playerRepository.delete(name);
		return getViews();
	}
}
