package com.mmc.kbs.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDTO {

	@NotNull(message = "Adınızı giriniz")
	private String fullname;
	@NotNull(message = "Email adresini giriniz")
	@Email(message = "Doğru bir email adresi giriniz")
	private String email;
	@NotNull(message = "Sabit telefonu giriniz")
	private String homephone;
	@NotNull(message = "Cep telefonu giriniz")
	private String cellphone;
	@NotNull(message = "İl seçiniz")
	private String provinceCode;
	@NotNull(message = "İlçe seçiniz")
	private String districtCode;
	@NotNull(message = "Okul türünü seçiniz")
	private String schoolType;
	@NotNull(message = "Okul kodunu giriniz")
	private String schoolCode;
	@NotNull(message = "Okul adını giriniz")
	private String schoolName;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
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

}
