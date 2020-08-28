package com.springbook.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		
		return "login.jsp";
	}
}