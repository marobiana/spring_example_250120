package com.example.lesson04.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA add
	public StudentEntity addStudent(String name,
			String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now())  // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// jpa update
	// input: id, dreamJob
	// output: StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터를 조회해온다.
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// 기존 데이터가 있다면 값을 update한다.
		if (student != null) {
			// 업데이트 할 값으로 엔티티를 바꾸어 놓는다.
			student = student.toBuilder()
				.dreamJob(dreamJob)
				.build();
			
			student = studentRepository.save(student); // 업데이트 후 새로운 내용으로 다시 셀렉트한 결과 저장
		}
		
		return student;
	}
	
	// Mybatis add
	// input: Student
	// output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input: id
	// output: Student(or null)
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}



