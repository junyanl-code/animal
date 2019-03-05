package neau.cekong.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import neau.cekong.pojo.TopBushu;
import neau.cekong.pojo.TopWendu;
import neau.cekong.pojo.TopZishi;
import neau.cekong.service.GetTopBushuByDidService;
import neau.cekong.service.GetTopWenduByDidService;
import neau.cekong.service.GetTopZishiByDidService;

@Controller
public class CheckDataController {
	@Resource
	private GetTopBushuByDidService getTopBushuByDidServiceImpl;
	@Resource
	private GetTopZishiByDidService getTopZishiByDidServiceImpl;
	@Resource
	private GetTopWenduByDidService getTopWenduByDidServiceImpl;

	@RequestMapping("bushu")
	@ResponseBody
	public TopBushu defaultWay(Long product_id, int limit) {
		Logger.getLogger(this.getClass()).info("前几条 bushu 查询");
		return getTopBushuByDidServiceImpl.getTopBushuByDid(limit, product_id);
	}

	@RequestMapping("zishi")
	@ResponseBody
	public TopZishi zishi(Long product_id, int limit) {
		Logger.getLogger(this.getClass()).info("前几条 zishi 查询");
		return getTopZishiByDidServiceImpl.getTopZishiByDid(limit, product_id);
	}
	
	@RequestMapping("wendu")
	@ResponseBody
	public TopWendu wendu(Long product_id, int limit) {
		Logger.getLogger(this.getClass()).info("前几条 wendu 查询");
		return getTopWenduByDidServiceImpl.getTopWenduByDidService(limit, product_id);
	}

}
