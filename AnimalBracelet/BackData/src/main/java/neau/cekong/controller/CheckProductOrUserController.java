package neau.cekong.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import neau.cekong.pojo.TableProduct;
import neau.cekong.service.GetAllProductByUidService;
import neau.cekong.service.RegisterAndLoginService;

@Controller
@RequestMapping("product")
public class CheckProductOrUserController {
	@Resource
	GetAllProductByUidService getAllProductByUidService;
	@Resource
	RegisterAndLoginService registerAndLoginService;

	@RequestMapping("getbyuid/{user_id}")
	@ResponseBody
	public List<TableProduct> productCheckAll(@PathVariable Long user_id) {

		return getAllProductByUidService.get(user_id);
	}
	
	@RequestMapping("regist/{userName}/{password}")
	@ResponseBody
	public Map<String, String> regist(@PathVariable String userName,@PathVariable  String password) {

		return registerAndLoginService.login(userName, password);
	}
}
