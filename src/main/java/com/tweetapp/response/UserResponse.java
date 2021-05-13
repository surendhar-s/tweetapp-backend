package com.tweetapp.response;

import java.io.Serializable;
import java.util.List;

import com.tweetapp.dto.UsersDto;

import lombok.Data;

@Data
public class UserResponse implements Serializable {
	private static final long serialVersionUID = 5432683200958075030L;
	private List<UsersDto> usersDto;
	private String statusMessage;
}
