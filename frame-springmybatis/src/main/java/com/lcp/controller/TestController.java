package com.lcp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcp.model.Role;
import com.lcp.service.TestService;

@Controller
@RequestMapping(value="/test")
public class TestController {
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/testName.do")
	public void testName(HttpServletRequest req,HttpServletResponse resp,String name){
		System.out.println("TestController testName params:"+name);
		String word=testService.TestName(name);
		System.out.println("TestController testName returns:"+word);
	};
	
	@RequestMapping(value="/roles.do")
	public void roles(HttpServletRequest req,HttpServletResponse resp,String name){
		System.out.println("TestController roles params:"+name);
		List<Role> roleList=testService.getRoles();
		for (Role r:roleList) {
			System.out.println(r.getRoleName());
		}
	};
	
	
	@RequestMapping(value="/insert.do")
	public void insert(HttpServletRequest req,HttpServletResponse resp,String name){
		Role r=new Role();
		r.setRoleName("name1");
		r.setRoleStatus(true);
		r.setRemark("remark1");
		testService.insertRoles(r);
		
	};
}
