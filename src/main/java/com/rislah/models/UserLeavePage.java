package com.rislah.models;

import com.google.gson.annotations.SerializedName;

public class UserLeavePage {
    @SerializedName("user_id")
    private String userId;
    private String page;
    @SerializedName("duration_sec")
    private Integer durationSeconds;

    public String getUserId() {
        return userId;
    }

    public String getPage() {
        return page;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public String toString() {
        return "UserLeavePage{" +
                "userId='" + userId + '\'' +
                ", page='" + page + '\'' +
                ", durationSeconds=" + durationSeconds +
                '}';
    }
}
