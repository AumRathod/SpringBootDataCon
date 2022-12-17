package com.firstweb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.firstweb.demo.dao.AlienRepo;
import com.firstweb.demo.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.html";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.html";
	}
	
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
//		System.out.println("hiii");
		ModelAndView mv = new ModelAndView("showAlien.html");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		System.out.println(alien);
		return mv;
	}
}
