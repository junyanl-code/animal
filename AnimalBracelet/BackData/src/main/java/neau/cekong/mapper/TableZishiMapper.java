package neau.cekong.mapper;

import neau.cekong.pojo.TableZishi;

public interface TableZishiMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TableZishi record);

    int insertSelective(TableZishi record);

    TableZishi selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TableZishi record);

    int updateByPrimaryKey(TableZishi record);
}