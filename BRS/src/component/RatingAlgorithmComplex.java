package com.brs.component;

import org.springframework.stereotype.Component;

@Component
public class RatingAlgorithmComplex implements RatingAlgorithmType{
	
	@Override
	public String getType()
	{
		return "complex";
	}
	@Override
    public int calculateBuyerRating(int total,int success,int returns,int cancels)
    {
		int rating=0;
		double success_percent=success*total/100;
		double returns_percent=returns*total/100;
		double cancels_percent=cancels*total/100;
		if(success_percent>=20 && success_percent<=40)
			rating+=1;
		else if(success_percent>40 && success_percent<60)
			rating+=1.5;
		else
			rating+=1.8;
		if(returns_percent>=20 && returns_percent<=40)
			rating-=1.5;
		else if(returns_percent>40 && returns_percent<60)
			rating-=1.8;
		else
			rating-=2.5;
		if(cancels_percent>=20 && cancels_percent<=40)
			rating-=1;
		else if(cancels_percent>40 && cancels_percent<60)
			rating-=1.5;
		else
			rating-=1.8;
		return rating;
    }
}