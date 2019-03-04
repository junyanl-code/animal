package neau.cekong.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neau.cekong.mapper.TableZishiMapper;
import neau.cekong.pojo.TableZishi;
import neau.cekong.pojo.TopZishi;
import neau.cekong.service.GetTopZishiByDidService;

@Service
public class GetTopZishiByDidServiceImpl implements GetTopZishiByDidService {

	@Resource
	TableZishiMapper tableZishiMapper;
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");//HH:mm
	
	@Override
	public TopZishi getTopZishiByDid(int num, Long id) {
		List<TableZishi> temp =  tableZishiMapper.getTopData(num, id);
		TopZishi result = new TopZishi();
		for (TableZishi t : temp) {
			result.getCe().add(t.getCe());
			result.getTang().add(t.getTang());
			result.getZhan().add(t.getZhan());
			result.getTime().add(simpleDateFormat.format(t.getTime()));
		}
		
		return result;
	}

}
