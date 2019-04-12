package neau.cekong.controller;

import neau.cekong.pojo.TableProduct;
import neau.cekong.pojo.TableUser;
import neau.cekong.service.GetAllProductByUidService;
import neau.cekong.service.InsertProductService;
import neau.cekong.service.RegisterAndLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CheckProductOrUserController {
    @Resource
    GetAllProductByUidService getAllProductByUidService;
    @Resource
    RegisterAndLoginService registerAndLoginService;
    @Resource
    InsertProductService insertProductService;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private HttpServletRequest httpServletrequest;


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

    @RequestMapping("login/check")
    @ResponseBody
    public Map<String, String> loginTest(String LOGSESSION) {
        TableUser tu = (TableUser)servletContext.getAttribute(LOGSESSION);
        HashMap<String, String> result = new HashMap<>();

        if(tu!=null){
            result.put("stat", "200");
            result.put("userName", tu.getUserName());
        }else{
            result.put("stat", "500");
        }

        return result;
    }

    @RequestMapping("ins/product/{productId}/{productName}")
    @ResponseBody
    public Map<String, String> insProduct(@PathVariable Long productId, @PathVariable String productName) {

        TableProduct tableProduct = new TableProduct();
        tableProduct.setProductId(productId);
        tableProduct.setProductName(productName);
        try {
            tableProduct.setUserId((Long) servletContext.getAttribute(httpServletrequest.getParameter("LOGSESSION")));
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> map = new HashMap<>();
            map.put("stat", "ERR");
            map.put("msg", "读取当前用户失败");
            return map;
        }

        return insertProductService.ins(tableProduct);
    }
}
