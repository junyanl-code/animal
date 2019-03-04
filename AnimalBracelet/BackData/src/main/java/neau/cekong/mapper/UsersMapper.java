package neau.cekong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import neau.cekong.pojo.User;

public interface UsersMapper {
	@Select("select * from user")
	List<User> selAll();
}
