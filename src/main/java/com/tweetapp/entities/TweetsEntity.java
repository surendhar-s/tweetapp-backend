package com.tweetapp.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tweetapp.dto.Reply;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "tweets")

@Data
public class TweetsEntity {
	@Id
	@JsonProperty("_id")
	private ObjectId _id;
	@JsonProperty("tweet")
	private String tweet;
	@JsonProperty("userTweetId")
	private String userTweetId;
	@JsonProperty("tweetId")
	private Long tweetId;
	@JsonProperty("like")
	private Long like;
	@JsonProperty("reply")
	private List<Reply> reply;
	@JsonProperty("dateOfPost")
	private Date dateOfPost;

}
