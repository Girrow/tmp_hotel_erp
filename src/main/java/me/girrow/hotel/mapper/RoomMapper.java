package me.girrow.hotel.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.hotel.vo.ReservationDTO;
import me.girrow.hotel.vo.ReservationNewDTO;
import me.girrow.hotel.vo.RoomVO;

@Mapper
public interface RoomMapper {
	
	public List<RoomVO> getRoomsInfo();
	
	public List<String> getRoomsImgList(String numb);
	
	public List<HashMap<String,Object>> getAvailableRoom(ReservationDTO rd);
	
	public int updateNewReservation(ReservationNewDTO rdn);
	
	public List<HashMap<String,Object>> getUserRes(String userNo);
}
