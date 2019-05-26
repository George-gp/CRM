package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.briup.bean.Sys_role;
import com.briup.bean.Sys_user;
import com.briup.dao.UserDao;
import com.briup.service.UserService;
import com.briup.util.PageUtil;

/**
 * @author: GodGG
 * @date: 2019 4:49:17 PM
 * @version: 1.0
 * @description:
 */
@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public Sys_user findlogin(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		Sys_user user = userDao.login(username, password);
		return user;
	}
	@Override
	public List<Sys_user> findAllMgr() throws Exception {
		// TODO Auto-generated method stub
		List<Sys_user> users = userDao.getAllMgr();
		return users;
	}

	@Override
	public List<Sys_role> findAllRole() throws Exception {
		// TODO Auto-generated method stub
		List<Sys_role> roles = userDao.getAllRole();
		return roles;
	}

	@Override
	public Sys_role findOneRole(int role_id) throws Exception {
		// TODO Auto-generated method stub
		Sys_role role = userDao.getOneRole(role_id);
		return role;
	}

	@Override
	public void updateRole(Sys_role role) throws Exception {
		// TODO Auto-generated method stub
		userDao.updateRole(role);
	}

	@Override
	public PageUtil<Sys_user> findAllUser(int curpage, int row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllRows() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sys_user findOneUser(int usr_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Sys_user user) throws Exception {
		// TODO Auto-generated method stub
		String usr_role_name = null;
		int usr_role_id = user.getUsr_role_id();
		switch (usr_role_id) {
		case 2:
			usr_role_name="高管";
			break;
		case 3:
			usr_role_name="部门主管";
			break;
		case 4:
			usr_role_name="客户经理";
			break;
		}
		user.setUsr_role_name(usr_role_name);
		userDao.updateUser(user);
	}

	@Override
	public void addUser(Sys_user user) throws Exception {
		// TODO Auto-generated method stub
		String usr_role_name = null;
		int usr_role_id = user.getUsr_role_id();
		switch (usr_role_id) {
		case 2:
			usr_role_name="高管";
			break;
		case 3:
			usr_role_name="部门主管";
			break;
		case 4:
			usr_role_name="客户经理";
			break;
		}
		user.setUsr_role_name(usr_role_name);
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(int usr_id) throws Exception {
		// TODO Auto-generated method stub
		userDao.deleteUser(usr_id);
	}

	@Override
	public void addRole(Sys_role role) throws Exception {
		// TODO Auto-generated method stub
		userDao.addRole(role);
	}

	@Override
	public void deleteRole(int role_id) throws Exception {
		// TODO Auto-generated method stub
		userDao.deleteRole(role_id);
	}

	@Override
	public List<String> findAllRoleName() throws Exception {
		// TODO Auto-generated method stub
		List<String> AllRoleName = userDao.findAllRoleName();
		return AllRoleName;
	}

}
