package com.example.lesson04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {
	
	@Autowired
	private UserMapper userMapper;

	// input: 4개 파라미터
	// output: int or void
	public void addUser(String name, 
			String yyyymmdd, String email, String introduce) {
		
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	// input: X
	// output: User(단건 or null)
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
	
	// input: email
	// output: boolean    true:중복
	public boolean isDuplicateByEmail(String email) {
		return userMapper.isDuplicateByEmail(email);
	}
}




