package com.tweetapp.dto;

import lombok.Data;

@Data
public class UsersDto {
	private String loginId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private long contactNumber;
	private Boolean loggedIn;
}
