package neau.cekong.service;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public interface RegisterAndLoginService {
	public Map<String, String> regist(String name, String password);
	public Map<String, String> login(String name, String password, HttpSession session, ServletContext context);
}
