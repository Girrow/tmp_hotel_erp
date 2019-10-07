package me.girrow.hotel.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class HUtil {
	
	public static HashMap<String,Object> puts(int status,HashMap<String,Object> comment){
		HashMap<String,Object> resultMap= comment;
		resultMap.put("status", status);
		return resultMap;
	}
	
	public static HashMap<String,Object> put(int status,String comment){
		HashMap<String,Object> resultMap= new HashMap<String,Object>();
		resultMap.put("status", status);
		resultMap.put("comment", comment);
		return resultMap;
	}
	
	public static HashMap<String, Object> checkValidation(HashMap<String, Object> returnMap, BindingResult bindResult) {
		if (bindResult.hasErrors()) {
			List<ObjectError> errors = bindResult.getAllErrors();
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : errors) {
				System.out.printf("error :%s : %s", error.getCode(), error.getDefaultMessage());
				System.out.println("");
				errorList.add(error.getDefaultMessage());
			}
			returnMap.put("status", 400);
			returnMap.put("comment", errorList);
			return returnMap;
		} else {
			returnMap.put("status", 200);
			return returnMap;
		}
	}
}
