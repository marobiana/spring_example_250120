package com.example.lesson03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired // DI
	private ReviewMapper reviewMapper;

	public Review getReviewById() {
		return reviewMapper.selectReviewById();
	}
}
