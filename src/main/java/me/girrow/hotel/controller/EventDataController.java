package me.girrow.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import me.girrow.hotel.mapper.EventMapper;
import me.girrow.hotel.vo.EventVO;

@RestController
@CrossOrigin
public class EventDataController {
	
	@Autowired
	EventMapper em;
	
	@PostMapping("/getEventList")
	public List<EventVO> getEventList(){
		List<EventVO> a = em.getAllEventList();
		System.out.println("EVENTVO = "+a);
		return a;
	}
}
