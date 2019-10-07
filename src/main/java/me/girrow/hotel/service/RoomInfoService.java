package me.girrow.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.girrow.hotel.mapper.RoomInfoMapper;
import me.girrow.hotel.vo.RoomListInfoVO;

@Service
public class RoomInfoService {
	
	@Autowired
	RoomInfoMapper rm;
	public List<RoomListInfoVO> getAllRoomInfo(){
		
		return rm.getAllRoomInfo();
	}
}
