package me.girrow.hotel.controller.admin;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.girrow.hotel.service.RoomInfoService;
import me.girrow.hotel.vo.RoomListInfoVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@CrossOrigin
public class RoomInfoController {
	
	@Autowired
	RoomInfoService ris;
	
	@PostMapping("/getAllRoomInfo")
	public List<RoomListInfoVO> getAllRoomInfo(){
		List<RoomListInfoVO> a = ris.getAllRoomInfo();
		return a;
	}
	
	@PostMapping("/keej")
	public Object testExample(HttpServletRequest req){
		
//		System.out.println("DATA="+data);
		String a = req.getParameter("data");
		JSONObject jobj = JSONObject.fromObject(a);
		
		System.out.println("here : "+jobj.toString());
		System.out.println("here : "+jobj.get("data").toString());
		return null;
	}
}
