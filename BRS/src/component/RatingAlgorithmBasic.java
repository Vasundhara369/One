package com.brs.component;

import org.springframework.stereotype.Component;

@Component
public class RatingAlgorithmBasic implements RatingAlgorithmType{
	
	@Override
	public String getType()
	{
		return "basic";
	}
	@Override
    public int calculateBuyerRating(int total,int success,int returns,int cancels)
    {
		int rating=0;
		if(success>=4)
			rating+=success/4;
		else if(returns>=2)
			rating-=returns/2;
		else if(cancels>=4)
			rating-=cancels/4;
		return rating;
    }
}
