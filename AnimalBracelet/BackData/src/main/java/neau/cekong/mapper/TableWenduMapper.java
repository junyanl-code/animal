package neau.cekong.mapper;

import neau.cekong.pojo.TableWendu;

public interface TableWenduMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TableWendu record);

    int insertSelective(TableWendu record);

    TableWendu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TableWendu record);

    int updateByPrimaryKey(TableWendu record);
}