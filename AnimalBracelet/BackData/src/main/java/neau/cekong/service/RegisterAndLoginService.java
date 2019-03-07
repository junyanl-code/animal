package neau.cekong.service;

import java.util.Map;

public interface RegisterAndLoginService {
	public Map<String, String> regist(String name, String password);
	public Map<String, String> login(String name, String password);
}
