package cn.itcast.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.itcast.core.dao.UserDao;
import cn.itcast.core.mapper.UserMapper;
import cn.itcast.core.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void save(User model) {
		userMapper.insert(model);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
