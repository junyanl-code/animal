package neau.cekong.mapper;

import org.apache.ibatis.annotations.Select;

import neau.cekong.pojo.TableUser;

public interface TableUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(TableUser record);

    int insertSelective(TableUser record);

    TableUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TableUser record);

    int updateByPrimaryKey(TableUser record);
    
    @Select("select user_id userId, user_name userName, password from table_user where user_name = #{0}")
    TableUser selectByName(String name);
}