package com.tweetapp.response;

import java.io.Serializable;
import java.util.List;

import com.tweetapp.dto.TweetsDto;

import lombok.Data;

@Data
public class TweetResponse implements Serializable {
	private static final long serialVersionUID = -3452495145437447139L;
	private List<TweetsDto> tweetsDto;
	private String statusMessage;

}
