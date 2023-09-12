package com.hr.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Value("${henry.valores.nombre}")
	private String henryValores;
	
	@GetMapping("/")
	public String home() {
		return "home/home";
	}
	
	@GetMapping("/nosotros")
	@ResponseBody
	public String nosotros() {
		return "Nosotros";
	}
	
	@GetMapping("/parametros/{id}/{slug}")
	@ResponseBody
	public String parametros(@PathVariable("id") Long id, @PathVariable("slug") String slug) {
		return "parametros" + id;
	}
	
	@GetMapping("/query-string")
	@ResponseBody
	public String query_string(@RequestParam("id") Long id, @RequestParam("slug") String slug) {
		return "query-string " + id + " Slug " + slug;
	}
	
	
	@GetMapping("/valores")
	@ResponseBody
	public String valores() {
		return "henry.valores.nombre " + this.henryValores;
	}
}
