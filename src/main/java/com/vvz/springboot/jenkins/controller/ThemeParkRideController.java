package com.vvz.springboot.jenkins.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vvz.springboot.jenkins.entity.ThemeParkRide;
import com.vvz.springboot.jenkins.repository.ThemeParkRideRepository;

@RestController
public class ThemeParkRideController {
	
	@Autowired
	ThemeParkRideRepository themeParkRideRepository;
	
	/**
	public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {
		this.themeParkRideRepository	= themeParkRideRepository;
	}
	**/
	
	@GetMapping(value = "/rides", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<ThemeParkRide> getRides(){
		System.out.println("GET /ride");
		return themeParkRideRepository.findAll();
	}
	
	@GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide getRide(@PathVariable long id) {
		System.out.println(String.format("GET /ride/%s", id));
		return themeParkRideRepository.findById(id).orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride ID %s", id))
				);
	}
	
	@PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ThemeParkRide createRide(@Valid @RequestBody ThemeParkRide themeParkRide) {
		System.out.println(String.format("POST /ride %s", themeParkRide.toString()));
		return themeParkRideRepository.save(themeParkRide);
	}

}
