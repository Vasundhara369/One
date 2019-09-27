package com.spring.rest.component;

public class BuyerId {
	String buyer_id;
	Order o[];
	public void setBuyerId(String b)
	{
		this.buyer_id=b;
	}
	public String getBuyerId()
	{
		return buyer_id;
	}
	public void setOrders(Order or[])
	{
		o=or;
	}
	public Order[] getOrders()
	{
		return o;
	}
}
