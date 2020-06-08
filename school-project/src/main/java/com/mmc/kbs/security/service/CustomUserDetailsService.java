package com.mmc.kbs.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mmc.kbs.security.model.UserPrincipal;
import com.mmc.kbs.service.UserService;
import com.mmc.kbs.service.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı."));
		return UserPrincipal.create(user);
	}

}
