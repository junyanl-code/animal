package neau.cekong.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import neau.cekong.pojo.TableProduct;
import neau.cekong.pojo.TableUser;
import neau.cekong.service.GetAllProductByUidService;
import neau.cekong.service.RegisterAndLoginService;

@Controller
public class CheckProductOrUserController {
	@Resource
	GetAllProductByUidService getAllProductByUidService;
	@Resource
	RegisterAndLoginService registerAndLoginService;

	

	@RequestMapping("product/getbyuid/{user_id}")
	@ResponseBody
	public List<TableProduct> productCheckAll(@PathVariable Long user_id, HttpServletRequest req) {
		String logsession = req.getParameter("LOGSESSION");
		TableUser tu = (TableUser) req.getServletContext().getAttribute(logsession);
		return getAllProductByUidService.get(tu.getUserId());
	}

	@RequestMapping("regist/{userName}/{password}")
	@ResponseBody
	public Map<String, String> regist(@PathVariable String userName, @PathVariable String password) {

		return registerAndLoginService.regist(userName, password);
	}

	@RequestMapping("login/{userName}/{password}")
	@ResponseBody
	public Map<String, String> login(@PathVariable String userName, @PathVariable String password, HttpSession session,
			HttpServletResponse resp, HttpServletRequest req) {
		ServletContext context = session.getServletContext();
		return registerAndLoginService.login(userName, password, session, context);
	}

	@RequestMapping("login/test/t/{log}")
	@ResponseBody
	public Map<String, String> loginTest(HttpSession session, HttpServletResponse resp, HttpServletRequest req,
			@PathVariable String log) {

		ServletContext context = session.getServletContext();

		TableUser us = (TableUser) context.getAttribute(log);
		String userName = us.getUserName();
		String password = us.getPassword();
		return registerAndLoginService.login(userName, password, session, context);
	}
}
