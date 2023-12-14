package com.example.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{  //材把计User琌entity柑材把计String琌pk戈篈
	
	public User findByAccountAndPwd(String account,String pwd);

	public boolean existsByAccountAndPwd(String account,String pwd);
}
