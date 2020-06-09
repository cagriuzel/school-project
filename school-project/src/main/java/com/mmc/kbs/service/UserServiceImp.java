package com.mmc.kbs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmc.kbs.request.UserDTO;
import com.mmc.kbs.service.exception.RoleNotFoundException;
import com.mmc.kbs.service.model.Role;
import com.mmc.kbs.service.model.User;
import com.mmc.kbs.service.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private RoleService roleService;

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> findByRoleName(String roleName) throws RoleNotFoundException {
		Role role = roleService.findByName(roleName).orElseThrow(() -> new RoleNotFoundException(roleName + " not found"));
		return userRepository.findByRoles(role);
	}

	@Override
	public User createMember(UserDTO userDTO) {
		User user = new User();
		user.setFullname(userDTO.getFullname());
		user.setEmail(userDTO.getEmail());
		user.setHomephone(userDTO.getHomephone());
		user.setCellphone(userDTO.getCellphone());
		user.setProvienceCode(userDTO.getProvinceCode());
		user.setDistrictCode(userDTO.getDistrictCode());
		user.setSchoolType(userDTO.getSchoolType());
		user.setSchoolCode(userDTO.getSchoolCode());
		user.setSchoolName(userDTO.getSchoolName());
		user.setPassword(passwordEncoder.encode(userDTO.getSchoolCode()));
		user.setActive(true);
		user.addRole(roleService.getDemoRole());
		user.setUsername(userDTO.getSchoolCode());
		LocalDate now = LocalDate.now();
		user.setCreateDate(now);
		user.setExpireDate(now.plusDays(45));
		return userRepository.save(user);
	}

}
