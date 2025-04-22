package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 메소드 위에 붙은 path보다 먼저 읽혀진다.
@Controller // Spring bean으로 등록
public class Lesson01Ex01Controller {

	// http://localhost:8080/lesson01/ex01/1
	// String => HTML
	@RequestMapping("/1")
	@ResponseBody // 리턴하는 값이 Response body에 담겨서 간다. => HTML
	public String ex01_1() {
		return "<h2>문자열을 Response body에 보내는 예제</h2>";
	}
	
	// http://localhost:8080/lesson01/ex01/2
	// Map => JSON String
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() {
		Map<String, Object> fruits = new HashMap<>();
		fruits.put("라즈베리", 35);
		fruits.put("포도", 21);
		fruits.put("배", 6);
		
		// Map이 JSON으로 변환됨
		// spring boot starter 안에 있는 jackson 라이브러리가 포함되어 있기 때문
		return fruits;
	}
}







