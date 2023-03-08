package com.hyungseo.root.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyungseo.root.dao.TestDao;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value= "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value= "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		TestDao dao = sqlSession.getMapper(TestDao.class);
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		dao.join(mid, mpw, mname, memail);
		
		model.addAttribute("dto", dao.dto(mid));
		
		return "joinOk";
	}
}
