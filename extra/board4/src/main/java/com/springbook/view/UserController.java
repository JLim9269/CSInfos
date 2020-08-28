package com.springbook.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public String register() {
		return "register.jsp";
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public String registerPro(UserVO vo) {
		System.out.println(vo);
		vo.setRole("user");
		userService.register(vo);
		return "redirect:login.do";
	}
	
	@RequestMapping(value="/updateInfo.do",method=RequestMethod.GET)
	public String updateInfoForm(UserVO vo,Model model) {
		model.addAttribute("user",userService.getUser(vo));
		return "updateInfo.jsp";
	}
	
	@ModelAttribute("roleMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> roleMap = new HashMap<>();
		roleMap = userService.getRoles();
		return roleMap;
	}
	
	@RequestMapping(value="/updateInfo.do",method=RequestMethod.POST)
	public String updateInfoPro(UserVO vo,Model model) {
		UserVO user = userService.getUser(vo);
		if(user!=null) {
			userService.updateUser(vo);
			return "redirect:logout.do";
		}else {
			model.addAttribute("user",vo);
			return "redirect:login.do";
		}
	}
	
	@RequestMapping(value="/deleteUser.do",method=RequestMethod.GET)
	public String deleteUser(@RequestParam("id") String id) {
		userService.deleteUser(id);
		return "redirect:logout.do";
	}
}