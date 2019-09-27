package com.brs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brs.service.UpdateFeaturesService;

@RestController
public class UpdateFeaturesController {
	@Autowired
	UpdateFeaturesService frs;
	
	@RequestMapping(value="/updateRatingFeatures/{id}", method=RequestMethod.GET, headers="Accept=application/json")
    public List<Integer> getFeatures(@PathVariable(name="id") String id) {
        return frs.getFeatures(id);
    }
}