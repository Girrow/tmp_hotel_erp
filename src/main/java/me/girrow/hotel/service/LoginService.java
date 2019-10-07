package me.girrow.hotel.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.girrow.hotel.mapper.UserMapper;
import me.girrow.hotel.util.HUtil;
import me.girrow.hotel.vo.UserDTO;

@Service
public class LoginService {
	
	@Autowired
	UserMapper um;
	
	/* 사용자 생성
	 * */
	public HashMap<String,Object> addUser(UserDTO ut,HttpSession session){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		int checkId = -1;
		checkId = um.checkAllUser(ut);
		if(checkId == 1) return HUtil.put(203, ut.getUsername()+"란 아이디가 이미 존재합니다!");
		int result = um.insertNewUser(ut);
		returnMap = (result == 1) ?
				 HUtil.put(200, ut.getUsername()+"으로 회원가입 되셨습니다!")
				:HUtil.put(203, ut.getUsername()+"으로 회원가입이 실패했습니다!");
		return returnMap;
	}
	
	public HashMap<String,Object> checkUserIsRight(UserDTO ut,HttpSession session){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		int checkUserIdIsRight=-1;
		checkUserIdIsRight =um.checkUserInfo(ut);
		returnMap = (checkUserIdIsRight == 1) ?
				 HUtil.put(200, ut.getUsername()+" 로그인!")
				:HUtil.put(202 , "로그인 정보값이 올바르지 않습니다.");
		/*
		 * 수정할 부분
		 * */
		if(checkUserIdIsRight == 1) session.setAttribute("username", ut.getUsername());
		if(checkUserIdIsRight == 1) returnMap.put("datas", um.getUserInfo(ut.getUsername()));
		return returnMap;
	}
	
	public HashMap<String,Object> getUserSession(HttpSession session){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("datas", um.getUserInfo(session.getAttribute("username").toString()));
		return returnMap;
	}
	
	
}
