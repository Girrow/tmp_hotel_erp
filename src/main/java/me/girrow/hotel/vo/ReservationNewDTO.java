package me.girrow.hotel.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReservationNewDTO {
	private String no;
	private String dates;
	private String dates2;
	private String roomType;
	private String numb;
	private String user;
	@Override
	public String toString() {
		return "ReservationNewDTO [no=" + no + ", dates=" + dates + ", dates2=" + dates2 + ", roomType=" + roomType
				+ ", numb=" + numb + ", user=" + user + "]";
	}
	
}
