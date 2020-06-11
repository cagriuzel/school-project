package com.mmc.kbs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mmc.kbs.request.UserDTO;
import com.mmc.kbs.request.UserUpdateDTO;
import com.mmc.kbs.service.UserService;
import com.mmc.kbs.service.exception.RoleNotFoundException;
import com.mmc.kbs.service.exception.UserNotFoundException;
import com.mmc.kbs.service.model.User;

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

	@GetMapping("/admin")
	public String admin(Model model) {
		try {
			List<User> userList = userService.findByRoleName("ROLE_DEMO");
			model.addAttribute("demoUserList", userList);

		} catch (RoleNotFoundException e) {
		}
		return "admin";
	}

	@GetMapping("/admin/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Long userId) throws UserNotFoundException {
		User user = userService.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		return ResponseEntity.ok(user);
	}

	@PostMapping(value = "/admin", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String updateUser(UserUpdateDTO modifiedUser, Model model) throws UserNotFoundException, RoleNotFoundException {
		User updateUser = userService.updateUser(modifiedUser);
		List<User> userList = userService.findByRoleName("ROLE_DEMO");
		model.addAttribute("demoUserList", userList);
		model.addAttribute("updateUser", updateUser);
		return "admin";
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
