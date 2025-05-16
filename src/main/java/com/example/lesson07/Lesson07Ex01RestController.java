package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.service.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;

	// C: create
	@GetMapping("/create")
	public StudentEntity create() {
		// jpa는 인서트 성공한 행 객체를 다시 받아올 수 있다.
		StudentEntity student = studentBO.addStudent(
				"김꾸꾸", "010-0000-9999", "aaa@peir.com", "QA");
		return student;
	}
	
	// U: Update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 6번인 dreamJob 변경 => 마케터
		return studentBO.updateStudentDreamJobById(6, "마케터");
	}
}




