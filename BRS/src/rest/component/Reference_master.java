package com.spring.rest.component;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.springframework.stereotype.Component;
 
@Entity
@Table(name="Reference_master")
@Component
public class Reference_master {
 
    @Id
    @Column(name="client_id")
    private int client_id;
 
    @Column(name="reference_id")
    private String reference_id;
 
    @Column(name="rating_weight")
    private int rating_weight;
    
    @Column(name="reference_type")
    private String reference_type;
    
    @Column(name="created_date")
    private Date created_date;
 
    @Column(name="last_modified_date")
    private Date last_modified_date;
    
    public Reference_master() { }
 
    public Reference_master(int c,String r,int rw,String type,Date cd,Date lmd) {   
        this.client_id=c;
        this.reference_id=r;
        this.rating_weight=rw;
        this.reference_type=type;
        this.created_date=cd;
        this.last_modified_date=lmd;
    }
 
    public int getClientId() {
        return client_id;
    }
    public void setClientId(int bid) {
        this.client_id = bid;
    }
    
    public String getReferenceId() {
        return reference_id;
    }
    public void setReferenceId(String bid) {
        this.reference_id = bid;
    }
    
    public int getRatingWeight() {
        return rating_weight;
    }
    public void setRatingWeight(int bid) {
        this.rating_weight = bid;
    }
    public String getReferenceType() {
        return reference_type;
    }
    public void setReferenceType(String bid) {
        this.reference_type = bid;
    }
    public Date getCreatedDate()
    {
    	return created_date;
    }
    public void setCreatedDate(Date d)
    {
    	this.created_date=d;
    }
    public Date getLastModifiedDate()
    {
    	return last_modified_date;
    }
    public void setLastModifiedDate(Date d)
    {
    	this.last_modified_date=d;
    }
    @Override
    public String toString() {
        return "Reference_master [clientId=" + client_id + ", referenceId=" + reference_id + ", ratingWeight=" + rating_weight + ", referenceType=" + reference_type +  ", lastModifiedDate=" + last_modified_date +", craetedDate=" + created_date + "]";
    }
}