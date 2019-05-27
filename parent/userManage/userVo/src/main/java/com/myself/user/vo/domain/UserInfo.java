package com.myself.user.vo.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Table(name = "tb_user")
@Data
public class UserInfo {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(generator = "JDBC")
	private BigInteger id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String sex;
	private String address;
	private String file;
	private Date created;
	private Date updated;
	private String state;
}
