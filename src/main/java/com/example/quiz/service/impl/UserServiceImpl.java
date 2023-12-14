package com.example.quiz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.quiz.constants.RtnCode;
import com.example.quiz.entity.User;
import com.example.quiz.repository.UserDao;
import com.example.quiz.service.ifs.UserService;
import com.example.quiz.vo.UserLoginRes;

@Service
public class UserServiceImpl implements UserService{

	@Autowired   //要使用 @Repository、@Entity..等被託管的東西時要打這個
	private UserDao userDao;    // ctrl + shift + O import快捷鍵
	
	@Override
	public UserLoginRes login(String account, String pwd) {
		//檢查為輸入是否為空用isBlank會更好，但null不能去用.isBlank，因為是null所以不能.，這邊最好用StringUtils.hasText
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UserLoginRes(RtnCode.PARAM_ERROR);
		}
//		這個邏輯雖然是對的，但是如果用boolean的話資料量差了60倍，所以有更好的寫法
//		User res = userDao.findByAccountAndPwd(account, pwd);
//		if(res == null) {
//			return; //失敗
//		}
//		return; //成功
		
		//差別在於上面的寫法是回傳一個物件，這個寫法只會回傳一個bit
		boolean res = userDao.existsByAccountAndPwd(account, pwd);
		if(!res) {
			return new UserLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new UserLoginRes(RtnCode.SUCCESSFUL);

		
		
		// TODO Auto-generated method stub
		
	}


	
	

}
