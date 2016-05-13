package com.iblog.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iblog.entity.User;
import com.iblog.plugin.MapContainer;
import com.iblog.service.UserService;
import com.iblog.utils.IdGenerator;

@Controller
@RequestMapping("/backend/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		model.addAttribute("page", userService.list(page, 15));
		return "backend/user/list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String insert(User user, String repass, Model model) {
		// MapContainer form = UserFormValidator.

		user.setId(IdGenerator.uuid19());
		user.setCreateTime(new Date());
		user.setLastUpdate(user.getCreateTime());

		userService.insert(user);
		return "redirect:/backend/users";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String update(User user, String repass, Model model) {
		user.setLastUpdate(new Date());
		userService.update(user);
		return "redirect:/backend/users";
	}

	@ResponseBody
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public Object remove(@PathVariable String userId) {
		userService.deleteById(userId);
		return new MapContainer("success", true);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(String userId, Model model) {
		if (!StringUtils.isBlank(userId))
			model.addAttribute("user", userService.loadById(userId));
		return "backend/user/edit";
	}
}
