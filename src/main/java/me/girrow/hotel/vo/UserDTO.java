package me.girrow.hotel.vo;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class UserDTO {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String dates;
}
