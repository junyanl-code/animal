package neau.cekong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import neau.cekong.pojo.TableWendu;

public interface TableWenduMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TableWendu record);

    int insertSelective(TableWendu record);

    TableWendu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TableWendu record);

    int updateByPrimaryKey(TableWendu record);
    
//    @Select("SELECT * FROM Table_Wendu WHERE product_id = #{1} ORDER BY Id DESC LIMIT #{0}")
    @Select(" SELECT  TOP(#{0}) * FROM Table_Wendu WHERE product_id = #{1} ORDER BY Id DESC")
    List<TableWendu> getTopData(int num, Long id);
}