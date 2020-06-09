package com.mmc.kbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmc.kbs.service.model.Role;
import com.mmc.kbs.service.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role getDemoRole() {
		Optional<Role> demoRole = roleRepository.findByName("ROLE_DEMO");
		if (demoRole.isPresent())
			return demoRole.get();

		Role role = new Role();
		role.setName("ROLE_DEMO");
		role.setDescription("Demo üyeler");
		return roleRepository.save(role);
	}

	public Optional<Role> findByName(String name) {
		return roleRepository.findByName("ROLE_DEMO");
	}
}
