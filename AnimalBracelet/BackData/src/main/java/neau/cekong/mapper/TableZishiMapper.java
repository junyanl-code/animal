package neau.cekong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TableZishi;

public interface TableZishiMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TableZishi record);

    int insertSelective(TableZishi record);

    TableZishi selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TableZishi record);

    int updateByPrimaryKey(TableZishi record);
    
//    @Select("SELECT * FROM Table_Zishi WHERE product_id = #{1} ORDER BY Id DESC LIMIT #{0}")
    @Select(" SELECT  TOP(#{0}) * FROM Table_Bushu WHERE product_id = #{1} ORDER BY Id DESC")
    List<TableZishi> getTopData(int num, Long id);
}