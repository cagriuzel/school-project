package com.mmc.kbs.service;

import java.util.Optional;

import com.mmc.kbs.service.model.Role;

public interface RoleService {

	Role getDemoRole();

	Optional<Role> findByName(String name);
}
