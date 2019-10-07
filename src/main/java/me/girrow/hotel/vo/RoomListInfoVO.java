package me.girrow.hotel.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RoomListInfoVO {
	private int no;
	private String roomType;
	private int dPrice;
	private String price;
	private String status;
	
	@Override
	public String toString() {
		return "RoomListInfoVO [no=" + no + ", roomType=" + roomType + ", dPrice=" + dPrice + ", price=" + price + ", status=" + status + "]";
	}
	
}
