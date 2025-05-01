package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.domain.Student;
import com.example.lesson04.service.StudentBO;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;

	// 가입 화면
	// http://localhost/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	
	// 실제 가입(insert) => 방금 가입된 학생 정보 화면(select)
	// http://localhost/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(
			@ModelAttribute Student student, // form태그 name속성 값 = 필드와 일치 매핑
			Model model) {
		
		// db insert
		studentBO.addStudent(student); // id가 mybatis에 의해 자동으로 student에 채워짐
		
		// db select - 방금 가입된 학생
		int id = student.getId();
		Student newStudent = studentBO.getStudentById(id);
		
		// model에 담는다
		model.addAttribute("student", newStudent);
		
		// 화면 이동
		return "lesson04/afterAddStudent";
	}
}




