package cn.itcast.core.dao;

import java.util.List;

import cn.itcast.core.pojo.User;

public interface UserDao {

	List<User> findAll();

}
