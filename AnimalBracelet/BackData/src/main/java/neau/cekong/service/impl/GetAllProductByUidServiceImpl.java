package neau.cekong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neau.cekong.mapper.TableProductMapper;
import neau.cekong.pojo.TableProduct;
import neau.cekong.service.GetAllProductByUidService;

@Service
public class GetAllProductByUidServiceImpl implements GetAllProductByUidService {
	@Resource
	TableProductMapper tableProductMapper;
	
	@Override
	public List<TableProduct> get(Long user_id) {
		
		return tableProductMapper.selectAllByUserId(user_id);
	}

}
