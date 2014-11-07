package com.logic8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChampController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getViews()	throws Exception {
		return new ModelAndView("index");
	}
}
