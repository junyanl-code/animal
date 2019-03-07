package neau.cekong.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import neau.cekong.pojo.TableProduct;
import neau.cekong.service.GetAllProductByUidService;

@Controller
@RequestMapping("product")
public class CheckProductOrUserController {
	@Resource
	GetAllProductByUidService getAllProductByUidService;

	@RequestMapping("getbyuid/{user_id}")
	@ResponseBody
	public List<TableProduct> productCheckAll(@PathVariable Long user_id) {

		return getAllProductByUidService.get(user_id);
	}
}
