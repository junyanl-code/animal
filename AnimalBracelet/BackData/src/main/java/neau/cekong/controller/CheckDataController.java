package neau.cekong.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import neau.cekong.pojo.TopBushu;
import neau.cekong.service.GetTopBushuByDidService;

@Controller
public class CheckDataController {
	@Resource
	private GetTopBushuByDidService getTopBushuByDidServiceImpl;
	
	@RequestMapping("bushu")
	@ResponseBody
	public  TopBushu defaultWay(Long product_id, int limit) {
		Logger.getLogger(this.getClass()).info("前几条 bushu 查询");
		return getTopBushuByDidServiceImpl.getTopBushuByDid(limit, product_id);
	}
}
