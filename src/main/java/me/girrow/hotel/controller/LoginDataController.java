package me.girrow.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import me.girrow.hotel.service.LoginService;
import me.girrow.hotel.util.HUtil;
import me.girrow.hotel.vo.UserDTO;

@RestController
@CrossOrigin
public class LoginDataController {
	
	@Autowired
	LoginService lsi;
	/**
	 * resultMap의 기본 return 값
	 * status "200 444 445 등을 사용하여 값처리 할것."
	 * comment "사용자에게 띄울 alert 경고 내용이나 처리값을 사용할 곳"
	 * @return
	 */
	@PostMapping("/addUser")
	public Map addUser(@Valid UserDTO ut, BindingResult bindResult, HttpSession session) {
		HashMap<String,Object> resultMap =new HashMap<String,Object>(); 
		resultMap=HUtil.checkValidation(resultMap, bindResult);
		HashMap<String,Object> a ="200".equals(resultMap.get("status").toString()) ? lsi.addUser(ut, session):resultMap;
		return a;
	}
	
	@PostMapping("/checkUser")
	public HashMap<String,Object> checkUserInfo(UserDTO ut, BindingResult bindResult,HttpSession session){
		HashMap<String,Object> resultMap =new HashMap<String,Object>(); 
		resultMap=HUtil.checkValidation(resultMap, bindResult);
		HashMap<String,Object> a ="200".equals(resultMap.get("status").toString()) ? lsi.checkUserIsRight(ut, session):resultMap;
		return a; 
	}
	
	@PostMapping("/getUserSession")
	public HashMap<String,Object> getInfo(HttpSession session){
		HashMap<String,Object> resultMap = null;
		System.out.println("Session 정보");
		resultMap = (session.getAttribute("username") == null)?HUtil.put(202, "값 없지롱"):HUtil.puts(200, lsi.getUserSession(session));
		System.out.println(resultMap);
		return resultMap;
	}
	
}
