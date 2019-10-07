package me.girrow.hotel.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.girrow.hotel.mapper.PostMapper;
import me.girrow.hotel.util.HUtil;
import me.girrow.hotel.util.Pagination;
import me.girrow.hotel.vo.SmalltalkDTO;
import me.girrow.hotel.vo.SmalltalkVO;

@Service
public class SmalltalkService {
	
	@Autowired
	PostMapper pm;
	
	public SmalltalkVO getMenu(String key) {
		return pm.selectOneData(key);
	}
	
	public int getBoardListSize() {
		return pm.getListSize();
	}
	public HashMap<String, Object> getBoardList(Pagination paging) {
		HashMap<String, Object> resultMap = new HashMap<String,Object>();
		List<SmalltalkVO> list = pm.selectAllData(paging);
//		System.out.println(list);
		if (list.size() > 0) {
			resultMap = HUtil.put(200, "데이터 가져오기 성공");
			resultMap.put("results", list);
		} else {
			resultMap = HUtil.put(202, "데이터 가져오기 실패");
		}
		return resultMap;

	}

	public HashMap<String, Object> doThat(HttpSession session, String key, SmalltalkDTO sd) {
//		sd.setWriter(session.getAttribute("username").toString());
		HashMap<String, Object> resultMap = null;
		int result = -1;
		switch (key) {
		case "create":
			result = pm.create(sd);
			break;
		case "update":
			result = pm.update(sd);
			break;
		case "delete":
			result = pm.delete(sd);
			break;
		default:
			System.out.println("오류");
			break;
		}
		
		if(result > 0) {
			resultMap = HUtil.put(200, key+" 성공");
		}else {
			resultMap = HUtil.put(202, key+" 오류");
		}
		return resultMap;
	}
}