package neau.cekong.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neau.cekong.mapper.TableWenduMapper;
import neau.cekong.pojo.TableWendu;
import neau.cekong.pojo.TopWendu;
import neau.cekong.service.GetTopWenduByDidService;

@Service
public class GetTopWenduByDidServiceImpl implements GetTopWenduByDidService {

	@Resource
	TableWenduMapper tableWenduMapper;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

	@Override
	public TopWendu getTopWenduByDidService(int num, Long id) {
		TopWendu result = new TopWendu();
		List<TableWendu> temp = tableWenduMapper.getTopData(num, id);
		for (TableWendu t : temp) {
			result.getTime().add(simpleDateFormat.format(t.getTime()));
			result.getWendu().add(t.getWendu());
		}

		return result;
	}

}
