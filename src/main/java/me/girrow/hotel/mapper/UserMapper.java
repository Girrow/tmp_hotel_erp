package me.girrow.hotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import me.girrow.hotel.vo.UserDTO;
import me.girrow.hotel.vo.UserVO;

@Mapper
public interface UserMapper {

	public int checkAllUser(UserDTO ut);
	public int insertNewUser(UserDTO ut);
	public int checkUserInfo(UserDTO ut);
	public UserVO getUserInfo(String username);
}
