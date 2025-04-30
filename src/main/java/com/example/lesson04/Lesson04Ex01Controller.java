package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.domain.User;
import com.example.lesson04.service.UserBO;

@RequestMapping("/lesson04/ex01")
@Controller  // html 화면이므로 RestController X, ResponseBody X
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;

	// 회원가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // html 파일 경로
	}
	
	// 회원가입 처리
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser";
	}
	
	// 최근에 가입한 한명의 유저 정보 화면
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) {
		// db select
		User user = userBO.getLatestUser();
		
		// model에 데이터 담아두기 => view가 model에서 꺼내 사용
		model.addAttribute("result", user);
		model.addAttribute("title", "방금 가입한 유저 정보");
		
		// 화면
		return "lesson04/latestUser";
	}
}




