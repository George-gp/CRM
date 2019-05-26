package com.briup.web.controller.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Cst_activity;
import com.briup.bean.Cst_customer;
import com.briup.bean.Cst_linkman;
import com.briup.service.CustomerService;

/**
 * @author: GodGG
 * @date: 2019 3:05:57 PM
 * @version: 1.0
 * @description:
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customer;

	@RequestMapping("/Info_find")
	public String Info_find(HttpSession session) {
		try {
			List<Cst_customer> customers = customer.findallCustomer();
			session.setAttribute("customers", customers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/Info_find";
	}

	@RequestMapping("/Info_add")
	public String Info_add(Cst_customer c) {

		try {
			customer.saveCustomer(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/index";

	}

	@RequestMapping("/changeCust")
	public String changeCust(Cst_customer c) {
		try {
			customer.updateCustomer(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/index";

	}

	@RequestMapping("/deletecust")
	public String deletecust(int cust_id) {

		try {
			customer.deleteCustomerById(cust_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/customer/Info_find";

	}

	@RequestMapping("/findLinkman")
	public String findLinkman(int cust_id, HttpSession session) {

		try {
			List<Cst_linkman> linkmans = customer.findAllLinkman(cust_id);
			session.setAttribute("linkmans", linkmans);
			session.setAttribute("cust_id", cust_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "pages/Info_pencil";
	}

	@RequestMapping("/findAllActivity")
	public String findAllActivity(int cust_id, HttpSession session) {

		try {
			List<Cst_activity> activities = customer.findAllAcv(cust_id);
			session.setAttribute("activities", activities);
			session.setAttribute("cust_id", cust_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "pages/Info_book";
	}

	@RequestMapping("/addLinkman")
	public String addLinkman(Cst_linkman linkman) {

		try {
			customer.saveLinkMan(linkman);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/index";

	}

	@RequestMapping("/updateLinkman")
	public String updateLinkman(Cst_linkman linkman) {

		try {
			customer.updateLinkman(linkman);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/index";

	}

	@RequestMapping("/deleteLinkMan")
	public String deleteLinkMan(int lkm_id, HttpSession session) {

		try {
			customer.deleteLinkMan(lkm_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer cust_id = (Integer) session.getAttribute("cust_id");
		return "forward:/customer/findLinkman?cust_id=" + cust_id;

	}

	@RequestMapping("/addActivities")
	public String addActivities(Cst_activity activity) {

		try {
			Cst_customer cus = customer.findCstbyId(activity.getAtv_cust_id());
			activity.setAtv_cust_name(cus.getCust_name());
			customer.saveCst_activity(activity);
			System.err.println(cus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/index";

	}

	@RequestMapping("/updateActivity")
	public String updateActivity(Cst_activity activity) {

		try {
			customer.updateAtv(activity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";

	}

	@RequestMapping("/deleteOneActivity")
	public String deleteOneActivity(int atv_id, HttpSession session) {

		Integer cust_id = (Integer) session.getAttribute("cust_id");
		try {
			customer.deleteAtv(atv_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/customer/findAllActivity?cust_id=" + cust_id;

	}
}
