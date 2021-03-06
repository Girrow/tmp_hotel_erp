package me.girrow.hotel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	private int userNO;
	private String username;
	private String password;
	private int auth;
	private String date;
}
