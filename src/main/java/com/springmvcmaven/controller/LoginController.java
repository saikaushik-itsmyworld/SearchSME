package com.springmvcmaven.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcmaven.controllerform.SMEPojo;
import com.springmvcmaven.controllerform.SearchSMEForm;
import com.springmvcmaven.daoImpl.SearchDAOImpl;
/**
 * 
 * @author Sai
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	SearchDAOImpl daoImpl;
	
	
	@RequestMapping("/searchHome.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("searchSME") SearchSMEForm form) {
			
		System.out.println("**** login method ****");
		String topSearch = daoImpl.getTopSearchList();
		// 
			topSearch = topSearch.substring(0, topSearch.length()-1);
		ModelAndView mv = new ModelAndView("home", "topSearch", topSearch);
		
		return mv;
	}
		
	@RequestMapping("/EndorseSME.htm")
	public ModelAndView smeEntry(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("smePojo") SMEPojo smePojo) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		ModelAndView mv = new ModelAndView("EndorseSME");
		return mv;
	}
	
	
	@RequestMapping("/insertSME.htm")
	public ModelAndView insertSME(HttpServletRequest request, HttpServletResponse response) {
		SMEPojo smePojo = new SMEPojo();
		smePojo.setFirstName(request.getParameter("firstName"));
		smePojo.setLastName(request.getParameter("lastName"));
		smePojo.setID(request.getParameter("ID"));
		smePojo.setRating(Integer.valueOf(request.getParameter("rating")));
		smePojo.setSkills(request.getParameter("skills"));
		smePojo.setYourname(request.getParameter("yourname"));
		System.out.println("********************"+request.getParameter("firstName"));
		System.out.println("##########################"+smePojo.getFirstName());
		
		int returValue = daoImpl.insertSME(smePojo);
		String msg ;
		if(returValue == 1) {
			msg = "SME endorded";
		} else {
			msg = "There is some issue please contact adminstrator";
		}
		ModelAndView mv = new ModelAndView("EndorseSME", "msg", msg);
		return mv;
	}
	@RequestMapping("/searchSME.htm")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("searchSME") SearchSMEForm form) {
		System.out.println("***search method 1*****");
		String topic = form.getSearchTopic();
		System.out.println("***search method 2*****"+topic);
		daoImpl.insertSMETopic(topic);
									
		ArrayList<SMEPojo> smeList = daoImpl.getSMEList(topic);
		
		ModelAndView mv = new ModelAndView("SearchResults", "smeList", smeList);
		return mv;
	}
}
