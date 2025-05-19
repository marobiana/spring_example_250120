package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// 순수 JPA vs Spring Data JPA
	// public StudentEntity save(StudentEntity student);
	// public Optional<StudentEntity> findById(int id);
	// public void delete(StudentEntity student);
	// public List<StudentEntity> findAll();
	
	// ex02/select => JPQL
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name1111);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContaining(String email1111);
	public List<StudentEntity> findByNameStartingWith(String keyword);
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	// ex02 JPQL(엔티티 조회) - query문이 아님
	@Query(value = "select s from StudentEntity s where s.dreamJob = :dreamJob")
	public List<StudentEntity> selectByDreamJob(@Param("dreamJob") String dreamJob);
	
	// ex02 Mysql SQL Query  - native query
	@Query(value = "select * from `new_student` "
			+ "where `dreamJob` = :dreamJob"
			, nativeQuery = true)
	public List<StudentEntity> selectByDreamJobAsQuery(@Param("dreamJob") String dreamJob);
}




