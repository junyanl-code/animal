package neau.cekong.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String save(TableWendu record,@PathVariable Long proId,@PathVariable Double wendu){	
		record.setProductId(proId);
		record.setWendu(wendu);
		record.setTime(new Date());
		System.out.println("Controller" + proId + " " + wendu);
		insertNewDataByDidService.insertInto(record);	
		return "OK";
	}
	
	@RequestMapping("wendu")
	@ResponseBody
	public String save(TableWendu record){
		record.setTime(new Date());
		insertNewDataByDidService.insertInto(record);	
		return "OK";
	}
	
	@RequestMapping("zishi")
	@ResponseBody
	public String save(TableZishi record){
		record.setTime(new Date());
		insertNewDataByDidService.insertInto(record);	
		return "OK";
	}
	
	@RequestMapping("bushu")
	@ResponseBody
	public String save(TableBushu record){	
		record.setTime(new Date());
		insertNewDataByDidService.insertInto(record);	
		return "OK";
	}
}
