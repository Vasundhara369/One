package com.spring.rest.component;

public class Order {
	String order_status,ID;
	int Order_Num;//ID primary key of Orders table 
	public void setOrderStatus(String b)
	{
		this.order_status=b;
	}
	public String getOrderStatus()
	{
		return order_status;
	}
	public void setOrderId(String b)
	{
		this.ID=b;
	}
	public String getOrderId()
	{
		return ID;
	}
	public int getOrderNum()
	{
		return Order_Num;
	}
	public void setOrderNum(int o)
	{
		this.Order_Num=o;
	}
}
