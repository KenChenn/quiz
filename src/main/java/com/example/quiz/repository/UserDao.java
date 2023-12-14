package com.example.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{  //�Ĥ@�ӰѼ�User�O��entity�̪����Ӫ�A�ĤG�ӰѼ�String�O��pk����ƫ��A
	
	public User findByAccountAndPwd(String account,String pwd);

	public boolean existsByAccountAndPwd(String account,String pwd);
}
