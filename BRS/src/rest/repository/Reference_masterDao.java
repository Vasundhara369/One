package com.spring.rest.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import org.hibernate.query.*;

import com.spring.rest.component.BuyerId;
import com.spring.rest.component.Order;
import com.spring.rest.component.Reference_master;
import com.spring.rest.component.RequestParameters;
 
@Repository
public class Reference_masterDao {
 
    @Autowired
    private HibernateTemplate template;
 
    public HibernateTemplate getTemplate() {
        return template;
    }
 
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    
    public List<Reference_master> updateBuyerRatingInDatabase(RequestParameters rp)
    {
    	List<Reference_master> l=new ArrayList<>();
    	int client_id=rp.getClientId();
    	System.out.println(client_id);
    	BuyerId bid[]=rp.getBuyerIds();
    	for(BuyerId b:bid)
    	{
    		//String buyer_id=b.getBuyerId();
    		Order ord[]=b.getOrders();
    		int count_del=0,count_return=0,count_cancel=0,rating=0;
    		for(Order o:ord)
    		{
    			String status=o.getOrderStatus();
    			if(status.equals("delivered"))
    				count_del++;
    			else if(status.equals("returned"))
    				count_return++;
    			else if(status.equals("cancelled"))
    				count_cancel++;
    		}
    		if(count_del>=4)
    			rating+=count_del%4;
    		else if(count_return>=2)
    			rating-=count_return%2;
    		else if(count_cancel>=4)
    			rating-=count_cancel%4;
    		Reference_master rme=new Reference_master();
    		rme.setClientId(client_id);
    		rme.setReferenceId(b.getBuyerId());
    		rme.setReferenceType("buyer");
    		rme.setCreatedDate(new Date(2019-03-12));
    		rme.setLastModifiedDate(new Date(2019-03-12));
        	try
        	{
        		Reference_master rm = (Reference_master) getTemplate().get(Reference_master.class, new Integer(b.getBuyerId()));
        		int rating2=rm.getRatingWeight();
        		Session session;
        		try {
        			session=getTemplate().getSessionFactory().getCurrentSession();
        		} catch (HibernateException ex) {
        		    session = getTemplate().getSessionFactory().openSession();
        		}
        		rme.setRatingWeight(rating-rating2);
        		Query q=session.createQuery("update Reference_master set rating_weight =:rating_weight where reference_id=:refernce_id");
        		q.setParameter("rating_weight",rating-rating2);
        		q.setParameter("reference_id",b.getBuyerId());
        		System.out.println(q.executeUpdate());
        		l.add(rme);
        	//	Query q1=session.createQuery("update Reference_master set last_modified_date =:last_modified_date where reference_id=:refernce_id");
        		//q1.setParameter("last_modified_date",new Date(2019-04-12));
        	//	System.out.println(q1.executeUpdate());
        	}	
        	catch(NullPointerException e)
        	{
        		Session session;
        		try {
        			session=getTemplate().getSessionFactory().getCurrentSession();
        			rme.setRatingWeight(5);
        			session.persist(rme);
        			l.add(rme);
        		} catch (HibernateException ex) {
        		    session = getTemplate().getSessionFactory().openSession();
        		    rme.setRatingWeight(5);
        		    session.persist(rme);
        		    l.add(rme);
        		}
        	}	
    	}
    	return l;
    }
}