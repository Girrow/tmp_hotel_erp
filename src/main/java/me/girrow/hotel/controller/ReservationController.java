package me.girrow.hotel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import me.girrow.hotel.mapper.RoomMapper;
import me.girrow.hotel.service.ReservationNewService;
import me.girrow.hotel.vo.ReservationDTO;
import me.girrow.hotel.vo.ReservationNewDTO;
import me.girrow.hotel.vo.RoomVO;
@RestController
@CrossOrigin
public class ReservationController {
	
	@Autowired
	RoomMapper rm;
	
	@Autowired
	ReservationNewService rsn;
	
	@PostMapping("/getRooms")
	public List<RoomVO> getRooms(){
		
		HashMap<String,Object> ab = new HashMap<String,Object>();
		ab.put("rooms", "123");
		List<HashMap> a = new ArrayList<HashMap>();
		a.add(ab);
		return rm.getRoomsInfo();
	}
	
	@PostMapping("/getRoomsImg")
	public List<String> getRoomsImg(String numb){
		System.out.println("Numb ::"+numb);
		List<String> a = rm.getRoomsImgList(numb);
		System.out.println(a.toString());
		return a;
	}
	
	@PostMapping("/getAvailableRoom")
	public List<HashMap<String,Object>> getAvailableRoom(ReservationDTO rd,HttpServletRequest req){
		System.out.println("RD : "+rd);
		List<HashMap<String,Object>> result = rm.getAvailableRoom(rd);
		System.out.println("RESULT = "+result);
		return result;
	}
	
	@PostMapping("/pushNewReservation")
	public HashMap<String,Object> pushNewReservation(ReservationNewDTO rdn){
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		System.out.println("RDN : "+rdn.toString());
		resultMap = rsn.insertNewAddr(rdn);
		
		return resultMap;
	}
	
	/*유저용 getUserReservation // user Info에서 사용할 값
	 * */
	@PostMapping("/getUserReservation")
	public List<HashMap<String,Object>> getUserReservation(String userNo){
		System.out.println("USER NO :"+userNo);
		List<HashMap<String,Object>> resultMap =rsn.getUsersRes(userNo);
		for(HashMap<String,Object> a : resultMap) {
			System.out.println("Reserve : "+a.get("reservateDate").toString());
			System.out.println("ReserveEnd : "+a.get("reservateEndDate").toString());
		}
		return resultMap;
	}
	
}
