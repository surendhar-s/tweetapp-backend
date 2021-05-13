package com.tweetapp.dto;

import java.util.List;

import lombok.Data;

@Data
public class TweetsDto {
	private String tweet;
	private String userTweetId;
	private Long tweetId;
	private Long like;
	private List<Reply> reply;
	private String dateOfPost;
	private String timeOfPost;
}
