package neau.cekong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import neau.cekong.pojo.TableProduct;

public interface TableProductMapper { 
    @Select("select id, user_id userId, product_id productId, working, product_name productName from table_product where user_id = #{0}")
    List<TableProduct> selectAllByUserId(Long user_id);

    @Insert("INSERT INTO `animalbracelet`.`table_product` (`product_id`, `user_id`, `working`, `product_name`) VALUES (#{productId}, #{userId}, #{working}, #{productName})")
    int insert(TableProduct tableProduct);
}