package com.briup.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.briup.bean.Condition;
import com.briup.bean.Cst_activity;
import com.briup.bean.Cst_customer;
import com.briup.bean.Cst_linkman;
import com.briup.bean.Orders;
import com.briup.bean.Orders_line;
import com.briup.bean.Sys_user;
import com.briup.dao.CustomerDao;
import com.briup.service.CustomerService;
import com.briup.util.PageUtil;

/**
 * @author: GodGG
 * @date: 2019 3:45:16 PM
 * @version: 1.0
 * @description:
 */
@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerDao customer;
	@Override
	public int getAllRows() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Cacheable(value="findallCustomer")
	@Override
	public List<Cst_customer> findallCustomer() throws Exception {
		// TODO Auto-generated method stub
		List<Cst_customer> customers = customer.allCustomer();
		return customers;
	}

	@Override
	public List<Cst_customer> findCustomerPage(int curpage, int row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtil<Cst_customer> findCustomerPageByCon(int curpage, int row, Cst_customer cc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cst_customer findCustomerById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@CacheEvict(value={"findallCustomer"},allEntries=true)
	@Override
	public void updateCustomer(Cst_customer c) throws Exception {
		// TODO Auto-generated method stub
		customer.updateCustomer(c);
	}

//	@CacheEvict(value="findAllLinkman",allEntries=true)
	@Override
	public void saveLinkMan(Cst_linkman lkm) throws Exception {
		// TODO Auto-generated method stub
		customer.addLinkMan(lkm);
	}

//	@CacheEvict(value="findAllLinkman",allEntries=true)
	@Override
	public void deleteLinkMan(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		customer.deleteLinkMan(id);
	}

//	@Cacheable(value="findAllLinkman")
	@Override
	public List<Cst_linkman> findAllLinkman(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		List<Cst_linkman> linkmans = customer.allLinkman(id);
		return linkmans;
	}

	@Override
	public Cst_linkman findLinkmanById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@CacheEvict(value="findAllLinkman",allEntries=true)
	@Override
	public void updateLinkman(Cst_linkman lkm) throws Exception {
		// TODO Auto-generated method stub
		customer.updateLinkman(lkm);
	}

//	@CacheEvict(value={"findallCustomer"},allEntries=true)
	@Override
	public void deleteCustomerById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		customer.delCustomerById(id);
	}

//	@CacheEvict(value="findAllAcv",allEntries=true)
	@Override
	public void saveCst_activity(Cst_activity av) throws Exception {
		// TODO Auto-generated method stub
		customer.addCst_activity(av);
	}

//	@Cacheable(value="findAllAcv")
	@Override
	public List<Cst_activity> findAllAcv(Serializable atv_cust_no) throws Exception {
		// TODO Auto-generated method stub
		List<Cst_activity> activities = customer.queryAllAcv(atv_cust_no);
		return activities;
	}

	@Override
	public Cst_activity findAtvById(Serializable atv_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@CacheEvict(value="findAllAcv",allEntries=true)
	@Override
	public void updateAtv(Cst_activity at) throws Exception {
		// TODO Auto-generated method stub
		customer.updateAtv(at);
	}

//	@CacheEvict(value="findAllAcv",allEntries=true)
	@Override
	public void deleteAtv(Serializable atv_id) throws Exception {
		// TODO Auto-generated method stub
		customer.deleteAtv(atv_id);
	}

	@Override
	public PageUtil<Cst_customer> findCstPage(int curpage, int row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders findOrderById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtil<Cst_customer> findCstPageByCon(int curpage, int row, Condition con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sys_user> findSys_user() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@CacheEvict(value={"findallCustomer"},allEntries=true)
	
	@Override
	public void saveCustomer(Cst_customer cst) throws Exception {
		// TODO Auto-generated method stub
		customer.addCustomer(cst);
	}

	@Override
	public List<Orders> findOrderByCustId(int cust_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders_line> findOrderLinesById(int odr_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public Cst_customer findCstbyId(int cust_id) {
		// TODO Auto-generated method stub
		Cst_customer cst = customer.findCstbyId(cust_id);
		return cst;
	}

	
	
}
