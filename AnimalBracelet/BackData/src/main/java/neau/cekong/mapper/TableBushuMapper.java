package neau.cekong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import neau.cekong.pojo.TableBushu;

public interface TableBushuMapper {
	int deleteByPrimaryKey(Long id);

	int insert(TableBushu record);

	int insertSelective(TableBushu record);

	TableBushu selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(TableBushu record);

	int updateByPrimaryKey(TableBushu record);

	@Select("SELECT * FROM Table_Bushu WHERE product_id = #{2} ORDER BY Id DESC LIMIT #{1}")
	List<TableBushu> getTopData(int num, Long id);
}