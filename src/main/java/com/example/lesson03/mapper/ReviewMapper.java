package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	// input: X
	// output: Review(단건)
	public Review selectReviewById(int id);
	
	// input: Review(단건)
	// output: void(X) or int(성공한 행의 개수) 
	public int insertReview(Review review);
}






