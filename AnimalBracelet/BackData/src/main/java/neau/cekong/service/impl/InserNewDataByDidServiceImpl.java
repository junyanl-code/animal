package neau.cekong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neau.cekong.mapper.TableBushuMapper;
import neau.cekong.mapper.TableWenduMapper;
import neau.cekong.mapper.TableZishiMapper;
import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TableWendu;
import neau.cekong.pojo.TableZishi;
import neau.cekong.service.InsertNewDataByDidService;

@Service
public class InserNewDataByDidServiceImpl implements InsertNewDataByDidService {
	@Resource
	TableBushuMapper tableBushuMapper;
	@Resource
	TableWenduMapper tableWenduMapper;
	@Resource
	TableZishiMapper tableZishiMapper;

	@Override
	public Object insertInto(TableBushu record) {
		return tableBushuMapper.insertSelective(record);
	}

	@Override
	public Object insertInto(TableWendu record) {
		return tableWenduMapper.insertSelective(record);
	}

	@Override
	public Object insertInto(TableZishi record) {
		return tableZishiMapper.insertSelective(record);
	}

}
