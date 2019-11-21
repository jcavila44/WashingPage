package com.washer.shoewasher.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/Home")
public class HomeController {
	@Value("${tittle}")
	private String tittle;

	@Value("${design}")
	private String design;

	@Value("${version}")
	private String version;

	@Value("${actualizado}")
	private String update;

	@GetMapping(path = "/Home")
	public String listarAll(Model model) {
		return "/home/index.html";
	}
}
