package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체를 출력할 때 필드값이 보인다.
@AllArgsConstructor // 모든 파라미터 있는 생성자
@NoArgsConstructor // 파라미터 없는 생성자
@Builder(toBuilder = true) // setter의 대용, toBuilder=true 필드값 수정 허용
@Getter
@Entity // 이 객체가 엔티티다. 
@Table(name = "new_student")
public class StudentEntity{
	@Id // pk 식별자 등록
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert 시 방금 들어간 id를 가져옴
	private int id;
	
	private String name;
	
	private String phoneNumber;
	
	private String email;
	
	private String dreamJob;
	
	@CreationTimestamp // 필드에 시간값 넣지 않아도 현재 시간으로 자동으로 넣어줌
	private LocalDateTime createdAt;
	
	@UpdateTimestamp 
	private LocalDateTime updatedAt;
}





