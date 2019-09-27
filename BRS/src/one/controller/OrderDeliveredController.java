package com.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.component.SellerDetails;
import com.userinfo.service.OrderDeliveredService;

@RestController
public class OrderDeliveredController {
	
	@Autowired
	OrderDeliveredService oservice;
	
	@RequestMapping(value="/updateOrderStatusToDelivered/{id}", method=RequestMethod.GET, headers="Accept=application/json")
    public String updateStatus(@PathVariable(name="id") String id) {
        String  result= oservice.updateStatus(id);      
        return result;
    }
}
