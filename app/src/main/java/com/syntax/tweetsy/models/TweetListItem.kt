package com.syntax.tweetsy.models

import com.google.gson.annotations.SerializedName

class TweetListItem(
    val category:String,
    @SerializedName("tweet") val text: String
)