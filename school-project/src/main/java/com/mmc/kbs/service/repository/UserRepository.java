package com.mmc.kbs.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmc.kbs.service.model.Role;
import com.mmc.kbs.service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	List<User> findByRoles(Role role);

//	findByActiveTrue

}
