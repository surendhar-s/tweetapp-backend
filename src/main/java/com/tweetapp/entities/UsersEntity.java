package com.tweetapp.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class UsersEntity {

	@Id
	private ObjectId objectId;
	private String loginId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private long contactNumber;
	private Boolean loggedIn;
	private List<String> roles;
}
