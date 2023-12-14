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

	@Autowired   //�n�ϥ� @Repository�B@Entity..���Q�U�ު��F��ɭn���o��
	private UserDao userDao;    // ctrl + shift + O import�ֱ���
	
	@Override
	public UserLoginRes login(String account, String pwd) {
		//�ˬd����J�O�_���ť�isBlank�|��n�A��null����h��.isBlank�A�]���Onull�ҥH����.�A�o��̦n��StringUtils.hasText
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new UserLoginRes(RtnCode.PARAM_ERROR);
		}
//		�o���޿����M�O�諸�A���O�p�G��boolean���ܸ�ƶq�t�F60���A�ҥH����n���g�k
//		User res = userDao.findByAccountAndPwd(account, pwd);
//		if(res == null) {
//			return; //����
//		}
//		return; //���\
		
		//�t�O�b��W�����g�k�O�^�Ǥ@�Ӫ���A�o�Ӽg�k�u�|�^�Ǥ@��bit
		boolean res = userDao.existsByAccountAndPwd(account, pwd);
		if(!res) {
			return new UserLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new UserLoginRes(RtnCode.SUCCESSFUL);

		
		
		// TODO Auto-generated method stub
		
	}


	
	

}
