package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	// input: X
	// output: Review(단건)
	public Review selectReviewById(int id);
	
	// input: Review(단건)
	// output: void(X) or int(성공한 행의 개수) 
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// 하나의 map으로 구성 @Param
			@Param("storeId") int storeId, 
			@Param("menu") String menu,
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	// input: id, review
	// output: 성공한 행 개수(int) or void
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
}






