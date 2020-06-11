package com.mmc.kbs.service;

import java.util.List;
import java.util.Optional;

import com.mmc.kbs.request.UserDTO;
import com.mmc.kbs.request.UserUpdateDTO;
import com.mmc.kbs.service.exception.RoleNotFoundException;
import com.mmc.kbs.service.exception.UserNotFoundException;
import com.mmc.kbs.service.model.User;

public interface UserService {

	Optional<User> findByUsername(String username);

	Optional<User> findById(Long userId);

	User createMember(UserDTO userDTO);

	User updateUser(UserUpdateDTO userUpdateDTO) throws UserNotFoundException;

	List<User> findByRoleName(String roleName) throws RoleNotFoundException;
}
