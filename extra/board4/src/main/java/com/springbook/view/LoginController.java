package com.springbook.view;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동...");
		
		//vo.setId("test");
		//vo.setPassword("test1234");
			
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVO vo,/*UserDAO userDAO,*/HttpSession session) {
		if(vo.getId()==null||vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디 입력 해");
		}
		
		//UserVO user = userDAO.getUser(vo);
		UserVO user = userService.getUser(vo);
		if(user!=null) {
			session.setAttribute("userName",user.getName());
			System.out.println("userName:"+user.getName());
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
	}
}