package neau.cekong.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	
	@Select("select * from table_user")
	List<User> selectAll();
}
