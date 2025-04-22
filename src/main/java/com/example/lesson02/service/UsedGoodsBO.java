package com.example.lesson02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {
	
	@Autowired // Dependency Injection(DI): 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; // spring bean을 가져온다.

	// input: X  컨트롤러로부터 받아옴
	// output: (Mapper에서 받아온 걸)List<UsedGoods> 컨트롤러에게 준다.
	public List<UsedGoods> getUsedGoodsList() {
//		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
//		return usedGoodsList;
		return usedGoodsMapper.selectUsedGoodsList();
	}
}
