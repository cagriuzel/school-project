package com.mmc.kbs.service;

import java.util.Optional;

import com.mmc.kbs.request.UserDTO;
import com.mmc.kbs.service.model.User;

public interface UserService {

	Optional<User> findByUsername(String username);

	User createMember(UserDTO userDTO);
}
