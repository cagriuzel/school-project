package com.mmc.kbs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmc.kbs.request.UserDTO;
import com.mmc.kbs.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("userDTO", new UserDTO());
		return "login";
	}

	@PostMapping("/signup")
	public String signup(@Valid UserDTO userDTO, BindingResult bindingResult) {
		// TODO Add other controls(unique kolon control)
		if (bindingResult.hasErrors()) {
			return "home";
		}

		userService.createMember(userDTO);
		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}
