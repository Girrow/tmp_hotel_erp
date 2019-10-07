package me.girrow.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomVO {
	
	private int no;
	private String roomName;
	private String price;
	private String firstI;
	private String secondI;
	private String firstT;
}
