package me.girrow.hotel.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.hotel.util.Pagination;
import me.girrow.hotel.vo.SmalltalkDTO;
import me.girrow.hotel.vo.SmalltalkVO;

@Mapper
public interface PostMapper{
	
	public ArrayList<SmalltalkVO> selectAllData(Pagination paging);
	public int getListSize();
	
	public SmalltalkVO selectOneData(String a);
	public int create(SmalltalkDTO so);
	public int delete(SmalltalkDTO so);
	public int update(SmalltalkDTO so);
	
}
