package neau.cekong.service;

import java.util.List;

import neau.cekong.pojo.TableProduct;

public interface GetAllProductByUidService {
	List<TableProduct> get(Long user_id);
}
