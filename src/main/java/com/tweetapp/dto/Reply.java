package com.tweetapp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Reply {
	private String replied;
	private Date dateReplied;
}
