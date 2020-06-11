package com.mmc.kbs.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class UserUpdateDTO {

	private Long id;
	private String email;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate expireDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

}
