package cn.itcast.core.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.pojo.User;
import cn.itcast.core.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toAdd")
	public String add(){
		return "insert";
	}
	
	@RequestMapping("/insert")
	public String insert(String name,String birthday) throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		User user = new User();
		user.setName(name);
		Date date = dateFormat.parse(birthday);
		user.setBirthday(date);
		System.out.println(user.getBirthday());
		userService.save(user);
		return "redict:list.action";
	}
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<User> user = userService.findAll();
		model.addAttribute("userList", user);
		return "list";
	}
}
