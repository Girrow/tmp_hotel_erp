package me.girrow.hotel.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.girrow.hotel.service.SmalltalkService;
import me.girrow.hotel.util.HUtil;
import me.girrow.hotel.util.Pagination;
import me.girrow.hotel.vo.SmalltalkDTO;
import me.girrow.hotel.vo.SmalltalkVO;

@CrossOrigin
@RestController
public class BoardDataController {

	@Autowired
	SmalltalkService ss;
	
	@PostMapping("/getSmalltalkList")
	public @ResponseBody HashMap<String, Object> getSmalltalkList(String page) {
		System.out.println("PAGE =="+page);
		Pagination paging = new Pagination(page);
		HashMap<String, Object> resultMap = ss.getBoardList(paging);
		resultMap.put("totalPage", ss.getBoardListSize()/10 +1);
//		System.out.println(resultMap.toString());
//		System.out.println(resultMap.size());
		return resultMap;
	}
	
	@PostMapping("/board/detail")
	public SmalltalkVO selectOneData(String key){
		System.out.println(key);
		return ss.getMenu(key);
	}
	
	@PostMapping("/board/{key}")
	public HashMap<String,Object> boardCUD(SmalltalkDTO sd, @PathVariable String key, HttpSession session, HttpServletRequest req){
//										   RedirectAttributes ra
		System.out.println("/board/"+key+" 들어옴");
		System.out.println(sd.toString());
		if(sd.getTitle() == null) {
			return HUtil.put(400, "title값 안들어옴");
		}		
		HashMap<String, Object> resultMap = ss.doThat(session, key, sd);
//		req.setAttribute("rsData", ss.doThat(session, key, sd));
//		ra.addFlashAttribute("rsData",bsi.doThat(session,key,pv));
		return resultMap;
	}
	
}
