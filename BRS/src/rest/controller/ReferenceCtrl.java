package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.component.Reference_master;
import com.spring.rest.component.RequestParameters;
import com.spring.rest.service.Reference_masterServ;
 
@RestController
public class ReferenceCtrl {
 
    @Autowired
    private Reference_masterServ cservice;
 
    @RequestMapping(value="/updateBuyerRatingInDatabase", method=RequestMethod.POST, headers="Accept=application/json")
    public List<Reference_master> getBuyerRatingInDatabase(@RequestBody RequestParameters rp) {
    	
        System.out.println("ctrl  "+rp.getClientId());
    	List<Reference_master> list = cservice.updateBuyerRatingInDatabase(rp);      
        return list;
    }
}