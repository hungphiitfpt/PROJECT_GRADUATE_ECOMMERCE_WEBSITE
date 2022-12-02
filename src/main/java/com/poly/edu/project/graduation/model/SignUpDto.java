package com.poly.edu.project.graduation.model;

import lombok.Data;

@Data
public class SignUpDto {

	private String user_name;
	private String encryted_password;
	private String email;
	private String last_name;
	private String first_name;

}
