package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.service.UserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	@GetMapping("/sign-up-view")
	public String signUpView() {
		return "lesson06/signUp";
	}
	
	// AJAX 요청 - 중복 확인
	@ResponseBody
	@GetMapping("/is-duplicate-email")
	public Map<String, Object> isDuplicateEmail(
			@RequestParam("email") String email) {
		
		// db select
		boolean isDuplicate = userBO.isDuplicateByEmail(email);
		
		// 응답값 => Map => JSON String
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicate", isDuplicate);
		return result;
	}
}





