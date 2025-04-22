package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.service.UsedGoodsBO;

@RestController
public class Lesson02Ex01RestController {
	
	@Autowired // DI: spring bean 가져옴
	private UsedGoodsBO usedGoodsBO;
	
	// http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		return usedGoodsBO.getUsedGoodsList(); // list -> JSON
	}
}
