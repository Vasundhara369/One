package com.userinfo.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.userinfo.component.Accounts;
import com.userinfo.component.Orders;

@Repository
public class OrderDeliveredDao {
	@Autowired
    private HibernateTemplate template;
 
    public HibernateTemplate getTemplate() {
        return template;
    }
 
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    public String updateStatus(String id)
    {
    	Session session = getTemplate().getSessionFactory().openSession();
	    Transaction tx=null;
	    List<Orders> orders;
	    try {
	        tx = session.beginTransaction();
	        Criteria crit = session.createCriteria(Orders.class);
		   	crit.add(Restrictions.eq("id",id));
	        orders=crit.list();
	        Orders order=orders.get(0);
	        System.out.println(order);
	        order.setOrder_status("delivered");
	        session.update(order);
	        tx.commit();
	        return "update successful";
	    }
	    catch (Exception ex) {
	        if (tx!=null) tx.rollback();
	        throw ex;
	    }
	    finally {
	        session.close();
	    }
    }
}