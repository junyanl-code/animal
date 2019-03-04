package neau.cekong.service;

import java.util.List;

import javax.annotation.Resource;

import neau.cekong.mapper.TableBushuMapper;
import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TopBushu;

public class GetTopBushuByDidServiceImpl implements GetTopBushuByDidService {
	@Resource
	TableBushuMapper tableBushuMapper;

	@Override
	public TopBushu getTopBushuByDid(int num, Long id) {
		List<TableBushu> temp = tableBushuMapper.getTopData(num, id);
		TopBushu result = new TopBushu();
		for (TableBushu t : temp) {
			result.getCategories().add(t.getTime());
			result.getData().add(t.getBushu());
		}
		return result;
	}

}
