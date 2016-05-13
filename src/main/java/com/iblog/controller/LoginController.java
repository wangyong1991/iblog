package com.iblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iblog.entity.User;
import com.iblog.form.LoginForm;
import com.iblog.service.UserService;
import com.iblog.support.WebContextFactory;

@Controller
@RequestMapping("/backend")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		if(WebContextFactory.get().isLogon()) {
			return "redirect:/backend/index";
		}
		return "backend/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@Valid LoginForm form, BindingResult result, ModelMap map) {
		//如果入参有问题，返回注册页面
		if(result.hasErrors()) {
		    List<FieldError> errorList = result.getFieldErrors();
		    for(FieldError error : errorList) {
		       map.put("msg", error.getDefaultMessage());
		    }
		    return "backend/login";
		}
		
		User user = userService.login(form.getUsername(), form.getPassword());
		if(user == null) {
			map.put("msg", "用户名或密码错误");
			return "backend/login";
		}
		
		// 这里省略注册代码
		return "redirect:backend/index";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model) {
		return "backend/login";
	}
}
