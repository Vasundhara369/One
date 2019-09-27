package com.brs.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingAlgorithmFactory {
	
	@Autowired
    private List<RatingAlgorithmType> ratingAlgorithmTypes;

    private static final Map<String,RatingAlgorithmType> ratingAlgorithmTypeCache = new HashMap<>();

    @PostConstruct
    public void initRatingAlgorithmTypeCache() {
        for(RatingAlgorithmType ratingAlgorithmType:ratingAlgorithmTypes) {
        	ratingAlgorithmTypeCache.put(ratingAlgorithmType.getType(),ratingAlgorithmType);
        }
    }

    public static RatingAlgorithmType getService(String type) {
    	RatingAlgorithmType ratingAlgorithmType=ratingAlgorithmTypeCache.get(type);
        if(ratingAlgorithmType==null) throw new RuntimeException("Unknown service type: " + type);
        return ratingAlgorithmType;
    }
    
    public int calculateRating(String type,int total,int success,int returns,int cancels)
    {
    	RatingAlgorithmType ratingAlgorithmType=getService(type);
    	int rating=ratingAlgorithmType.calculateBuyerRating(total,success,returns,cancels);
    	return rating;
    }
}