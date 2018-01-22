package cn.itcast.core.service;

import java.util.List;

import org.springframework.ui.Model;

import cn.itcast.core.pojo.User;

public interface UserService {

	void save(User model);

	List<User> findAll();

}
