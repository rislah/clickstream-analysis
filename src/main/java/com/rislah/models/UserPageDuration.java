package com.rislah.models;

import com.google.gson.annotations.SerializedName;

public class UserPageDuration {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("duration_seconds")
    private Long durationSeconds;

    public UserPageDuration(String userId, Long durationSeconds) {
        this.userId = userId;
        this.durationSeconds = durationSeconds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
}
