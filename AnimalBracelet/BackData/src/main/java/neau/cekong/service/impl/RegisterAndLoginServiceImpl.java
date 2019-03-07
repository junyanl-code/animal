package neau.cekong.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neau.cekong.mapper.TableUserMapper;
import neau.cekong.pojo.TableUser;
import neau.cekong.service.RegisterAndLoginService;

@Service
public class RegisterAndLoginServiceImpl implements RegisterAndLoginService {
	@Resource
	TableUserMapper tableUserMapper;

	@Override
	public Map<String, String> regist(String name, String password) {
		TableUser tu = tableUserMapper.selectByName(name);
		Map<String, String> result = new HashMap<String, String>();
		if (tu == null) {
			tu = new TableUser();
			tu.setPassword(password);
			tu.setUserName(name);
			tableUserMapper.insertSelective(tu);
			result.put("msg", "注册成功");
			result.put("stat", "0");
		} else {
			result.put("msg", "用户已存在");
			result.put("stat", "1");
		}

		return result;
	}

	@Override
	public Map<String, String> login(String name, String password) {
		TableUser tu = tableUserMapper.selectByName(name);
		Map<String, String> result = new HashMap<String, String>();
		if (tu == null) {
			result.put("msg", "用户名不存在");
			result.put("stat", "1");
		} else {
			if (tu.getPassword().equals(password)) {
				result.put("msg", "登陆成功");
				result.put("stat", "0");
			}else{
				result.put("msg", "密码错误");
				result.put("stat", "2");
			}
		}
		return result;
	}

}
