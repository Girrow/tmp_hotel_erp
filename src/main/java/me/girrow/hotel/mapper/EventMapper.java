package me.girrow.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.hotel.vo.EventVO;

@Mapper
public interface EventMapper {
	public List<EventVO> getAllEventList();
}
