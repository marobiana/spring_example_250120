package com.example.lesson03.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired // DI
	private ReviewMapper reviewMapper;

	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}

	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}

	// addReviewAsField(4, "콤비네이션R", "bada", 5.0, "역시 맛있어")
	// input: 5개 파라미터
	// output: int 성공 행 개수
	public int addReviewAsField(int storeId2, String menu2, String userName2, Double point2, String review2) {

		return reviewMapper.insertReviewAsField(storeId2, menu2, userName2, point2, review2);
	}

	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}

	// input: id
	// output: void
	public void deleteReviewById(int id) {
		int rowCount = reviewMapper.deleteReviewById(id);
	}
}
