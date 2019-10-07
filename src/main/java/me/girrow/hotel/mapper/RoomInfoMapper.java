package me.girrow.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.hotel.vo.RoomListInfoVO;

@Mapper
public interface RoomInfoMapper {
	public List<RoomListInfoVO> getAllRoomInfo();
}
