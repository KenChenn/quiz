package com.example.quiz.service.ifs;

import com.example.quiz.vo.UserLoginRes;

public interface UserService {
	
	public UserLoginRes login(String account,String pwd); //介面只定義，實作在其他地方做

}
