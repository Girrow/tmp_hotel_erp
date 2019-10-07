package me.girrow.hotel.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.girrow.hotel.mapper.RoomMapper;
import me.girrow.hotel.util.HUtil;
import me.girrow.hotel.vo.ReservationNewDTO;

@Service
public class ReservationNewService {
	
	@Autowired
	RoomMapper rm;
	
	/* 사용자 생성
	 * */
	public HashMap<String,Object> insertNewAddr(ReservationNewDTO rdn){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		int count = -1;
		System.out.println("1234");
		count = rm.updateNewReservation(rdn);
		System.out.println("4321");
		if(count == -1) {
			returnMap =HUtil.put(202, "예약이 실패했습니다!");
		}else {
			returnMap =HUtil.put(200, "예약이 완료되었습니다!");
		}
		return returnMap;
	}
	
	public List<HashMap<String,Object>> getUsersRes(String userNo){
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		return rm.getUserRes(userNo);
	}
	
}
