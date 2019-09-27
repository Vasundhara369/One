package com.spring.rest.component;

public class RequestParameters {
	int client_id;
	BuyerId b[];
	public void setClientId(int i)
	{
		this.client_id=i;
	}
	public int getClientId()
	{
		return client_id;
	}
	public void setBuyerIds(BuyerId bi[])
	{
		b=bi;
	}
	public BuyerId[] getBuyerIds()
	{
		return b;
	}
}
