package com.briup.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Sys_role;
import com.briup.bean.Sys_user;
import com.briup.service.UserService;

/**
 * @author: GodGG
 * @date: 2019 4:37:24 PM
 * @version: 1.0
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("login")
	public String name(String name,String password,HttpSession session) {
		
		try {
			Sys_user user = userService.findlogin(name, password);
//			System.out.println(user);
//			System.out.println(role);
			if (user==null) {
				return "sign";
			}else if (user.getUsr_flag()==0) {
				return "sign";
			}else if (!password.equals(user.getUsr_password())) {
				return "sign";
			}
			Sys_role role = userService.findOneRole(user.getUsr_role_id());  //获取职能对象 进行判断
			if (role.getRole_flag()==0) {
				return "sign";
			}
			session.setAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/index";

	}
	

	
}
