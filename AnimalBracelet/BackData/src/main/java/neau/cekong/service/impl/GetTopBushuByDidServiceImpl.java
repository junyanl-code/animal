package neau.cekong.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neau.cekong.mapper.TableBushuMapper;
import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TopBushu;
import neau.cekong.service.GetTopBushuByDidService;

@Service
public class GetTopBushuByDidServiceImpl implements GetTopBushuByDidService {
	@Resource
	TableBushuMapper tableBushuMapper;
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public TopBushu getTopBushuByDid(int num, Long id) {
		List<TableBushu> temp = tableBushuMapper.getTopData(num, id);
		TopBushu result = new TopBushu();
		for (TableBushu t : temp) {
			result.getCategories().add(simpleDateFormat.format(t.getTime()));
			result.getData().add(t.getBushu());
		}
		return result;
	}

}
