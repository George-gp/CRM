package com.briup.web.controller.system;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Sys_role;
import com.briup.bean.Sys_user;
import com.briup.service.UserService;

/**
 * @author: GodGG
 * @date: 2019 2:48:40 PM
 * @version: 1.0
 * @description:
 */
@Controller
@RequestMapping("/system")
public class SystemController {

	@Autowired
	private UserService userService;

	@RequestMapping("/System_juese")
	public String System_juese(HttpSession session) {

		try {
			List<Sys_role> roles = userService.findAllRole();
			session.setAttribute("roles", roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/System_juese";

	}

	@RequestMapping("/System_yonghu")
	public String System_yonghu(HttpSession session) {

		try {
			List<Sys_user> users = userService.findAllMgr();
			session.setAttribute("users", users);
//			List<Sys_role> roles = userService.findAllRole();
//			roles.remove(0);
//			session.setAttribute("roles", roles);
//			System.err.println(roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/System_yonghu";

	}

	@RequestMapping("/userAdd")
	public String userAdd(Sys_user user) {

		try {
			userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";

	}

	@RequestMapping("/userUpdate")
	public String userUpdate(Sys_user user) {

		try {
			userService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";

	}

	@RequestMapping("/userDelete")
	public String userDelete(int usr_id) {

		try {
			userService.deleteUser(usr_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/system/System_yonghu";

	}

	@RequestMapping("/roleAdd")
	public String roleAdd(Sys_role role) {

		try {
			userService.addRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";

	}

	@RequestMapping("/roleUpdate")
	public String roleUpdate(Sys_role role) {

		try {
			userService.updateRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/roleDelete")
	public String roleDelete(int role_id) {
		
		try {
			userService.deleteRole(role_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/system/System_juese";
		
	}
}
