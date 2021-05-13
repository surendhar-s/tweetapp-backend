package com.tweetapp.request;

import com.tweetapp.dto.TweetsDto;

import lombok.Data;

@Data
public class TweetRequest {
	private TweetsDto tweet;
}
