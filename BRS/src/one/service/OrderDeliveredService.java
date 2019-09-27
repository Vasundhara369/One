package com.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.userinfo.repository.OrderDeliveredDao;

@Service
public class OrderDeliveredService {
	@Autowired
	OrderDeliveredDao odao;
	public String updateStatus(String id) {
        String  result= odao.updateStatus(id);      
        return result;
    }
}
