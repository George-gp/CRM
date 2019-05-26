package com.briup.web.controller.sale;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Salchance;
import com.briup.bean.Salplan;
import com.briup.bean.Sys_user;
import com.briup.service.SalchanceService;

/**
 * @author: GodGG
 * @date: 2019 9:43:07 AM
 * @version: 1.0
 * @description:
 */
@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	private SalchanceService salchanceService;
	
	@RequestMapping("/findAllSalchance")
	public String findAllSalchance(HttpSession session) {
		
		try {
			List<Salchance> salchances = salchanceService.findAllSalchance();
			session.setAttribute("chances", salchances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/Sale_sale";
		
	}
	
	@RequestMapping("/findAllSalchanceByUserName")
	public String findAllSalchanceByUserName(HttpSession session) {
		
		Sys_user user = (Sys_user) session.getAttribute("user");
		String usr_name = user.getUsr_name();
		try {
			List<Salchance> salchances = salchanceService.findAllSalchanceByUserName(usr_name);
			session.setAttribute("chances2", salchances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/Sale_kaifa";
		
	}
	
	@RequestMapping("/addChance")
	public String addChance(Salchance salchance) {
		
		try {
			salchance.setChc_status("1");
			salchanceService.saveChanceService(salchance);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.err.println(salchance);
		return "redirect:/index";
		
	}
	
	@RequestMapping("/updateChance")
	public String updateChance(Salchance salchance) {
		
//		System.err.println(salchance);
		try {
			salchanceService.updateChanceService2(salchance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
		
	}
	
	@RequestMapping("/deleteChance")
	public String deleteChance(int chc_id) {
		
		try {
			salchanceService.deleteSalchance(chc_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/sale/findAllSalchance";
		
	}
	
	@RequestMapping("/savePlan")
	public String savePlan(Salplan salplan) {
		
//		System.err.println(salplan);
		salplan.setPla_result("进行");
		int chc_id = salplan.getPla_chc_id();
		try {
			salchanceService.savePlanService(salplan);
			salchanceService.updateSalchanStutasById(chc_id,"2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
		
	}
	
	@RequestMapping("/updatePlan")
	public String updatePlan(Salplan salplan,String chc_addr) {
		
		if ("继续开发".equals(chc_addr)) {
			try {
				salchanceService.updateSalplanService(salplan);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("开发成功".equals(chc_addr)) {
			try {
				salchanceService.updateSalchanStutasById(salplan.getPla_chc_id(), "3");
				salplan.setPla_result("成功");
				salchanceService.updateSalplanService2(salplan);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/index";
		
	}
}
