package neau.cekong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import neau.cekong.mapper.UsersMapper;
import neau.cekong.pojo.User;
import neau.cekong.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersMapper usersMapper;
	@Override
	public List<User> show() {
		return usersMapper.selAll();
	}

}
