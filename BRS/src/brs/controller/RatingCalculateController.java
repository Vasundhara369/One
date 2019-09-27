package com.brs.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brs.component.Buyer;
import com.brs.component.BuyerDetails;
import com.brs.component.Orders;
import com.brs.component.ReferenceMaster;
import com.brs.component.RequestParameter;
import com.brs.service.RatingCalculateService;

@RestController
public class RatingCalculateController {
	public static final String getBuyerIdURI="http://localhost:8080/UserInfo/getBuyerIds";
	public String getBuyerDetailsURI="";
	String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Autowired
	RatingCalculateService cservice;

	private Set<String> getBuyerIds()
	{
		RestTemplate rt=new RestTemplate();
		List<String> buyer_ids=rt.getForObject(getBuyerIdURI,List.class);
		Set<String> h=new HashSet<>();
		h.addAll(buyer_ids);
		return h;
	}
	
	private List<BuyerDetails> getBuyerDetails(String buyer_id)
	{
		RestTemplate rt=new RestTemplate();
		getBuyerDetailsURI="http://localhost:8080/UserInfo/getBuyerDetails/"+buyer_id;
		System.out.println(getBuyerDetailsURI);
		List<LinkedHashMap> b=rt.getForObject(getBuyerDetailsURI,List.class);
		List<BuyerDetails> buyer_details=new ArrayList<>();
		for(LinkedHashMap l:b)
		{
			BuyerDetails bd=new BuyerDetails();
			bd.setBuyer_id((String)l.get("buyer_id"));
			bd.setOrder_num((int)l.get("order_num"));
			bd.setCust_order_status((String)l.get("cust_order_status"));
			bd.setOrder_id((String)l.get("order_id"));
			buyer_details.add(bd);
			System.out.println(bd);
		}
			//System.out.println(h.toString());
		return buyer_details;
	}
	
	 //@RequestMapping(value="/updateBuyerRatingInDatabase", method=RequestMethod.GET, headers="Accept=application/json")
	    public void updateBuyerRatingInDatabase() {
		    System.out.println("check");
		    RequestParameter rp=new RequestParameter();
	    	Set<String> buyer_ids=getBuyerIds();
	    	List<Buyer> lb=new ArrayList<>();
	    	for(String buyer_id:buyer_ids)
	    	{
	    		Buyer b=new Buyer();
	    		b.setBuyer_id(buyer_id);
	    		System.out.println("3  "+buyer_id);
	    		List<BuyerDetails> buyer_details=getBuyerDetails(buyer_id);
	    		List<Orders> od=new ArrayList<>();
	    		//System.out.println(buyer_details.toString());
	    		for(BuyerDetails bd:buyer_details)
	    		{
	    			Orders o=new Orders();
	    			o.setOrder_id(bd.getOrder_id());
	    			o.setCust_order_status(bd.getCust_order_status());
	    			o.setOrder_num(bd.getOrder_num());
	    			od.add(o);
	    			System.out.println("1  "+buyer_id+ "   " +o);
	    		}
	    		b.setOrders(od);
	    		lb.add(b);
	    	}
	    	rp.setBuyer(lb);
	    	cservice.updateBuyerRatingInDatabase(type,rp);
	 }
}