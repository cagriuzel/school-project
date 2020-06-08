package com.mmc.kbs.service.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 7281266171083002553L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FULLNAME", length = 100, unique = true)
	private String fullname;
	@Column(name = "USERNAME", length = 100, unique = true)
	private String username;
	@Column(name = "EMAIL", length = 100, unique = true)
	private String email;
	@Column(name = "HOMEPHONE")
	private String homephone;
	@Column(name = "CELLPHONE")
	private String cellphone;
	@Column(name = "PROVIENCECODE")
	private String provienceCode;
	@Column(name = "DISTRICTCODE")
	private String districtCode;
	@Column(name = "SCHOOLTYPE")
	private String schoolType;
	@Column(name = "SCHOOLCODE")
	private String schoolCode;
	@Column(name = "SCHOOLNAME")
	private String schoolName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ACTIVE")
	private boolean active;

	// @formatter:off
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ROLE", 
			   joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
			   inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	// @formatter:on
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getProvienceCode() {
		return provienceCode;
	}

	public void setProvienceCode(String provienceCode) {
		this.provienceCode = provienceCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Role> addRole(Role role) {
		if (roles == null) {
			roles = new HashSet<>();
		}
		roles.add(role);
		return roles;
	}

}
