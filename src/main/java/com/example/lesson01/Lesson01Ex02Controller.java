package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안된다. @RestController X
public class Lesson01Ex02Controller {
	
	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// return되는 String은 html의 경로이다.(@ResponseBody가 없을 때)
		
		// /templates/lesson01/ex02.html
		//        lesson01/ex02
		return "lesson01/ex021"; // response html view 경로
	}
}




