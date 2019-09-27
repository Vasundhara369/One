package com.brs.component;

public interface RatingAlgorithmType{
	String getType();
    int calculateBuyerRating(int total,int success,int returns,int cancels);
}
