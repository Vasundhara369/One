package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.component.Reference_master;
import com.spring.rest.component.RequestParameters;
import com.spring.rest.repository.Reference_masterDao;
 
@Service
public class Reference_masterServ {
 
    @Autowired
    private Reference_masterDao cdao;
 
   

	public List<Reference_master> updateBuyerRatingInDatabase(RequestParameters rp) {
		// TODO Auto-generated method stub
		return cdao.updateBuyerRatingInDatabase(rp);
	}
}