package neau.cekong.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import neau.cekong.pojo.TableBushu;
import neau.cekong.pojo.TableWendu;
import neau.cekong.pojo.TableZishi;
import neau.cekong.service.InsertNewDataByDidService;

@Controller
@RequestMapping("save")
public class InserDataController {
	@Resource
	private InsertNewDataByDidService insertNewDataByDidService;
	
	@RequestMapping("wendu/{proId}/{wendu}")
	@ResponseBody
	public String save(TableWendu record,Long proId, Double wendu){	
		record.setProductId(proId);
		record.setWendu(wendu);
		insertNewDataByDidService.insertInto(record);	
		return "OK";
	}
	
	@RequestMapping("zishi")
	@ResponseBody
	public String save(TableZishi record){	
		insertNewDataByDidService.insertInto(record);	
		return null;
	}
	
	@RequestMapping("bushu")
	@ResponseBody
	public String save(TableBushu record){	
		insertNewDataByDidService.insertInto(record);	
		return null;
	}
}
