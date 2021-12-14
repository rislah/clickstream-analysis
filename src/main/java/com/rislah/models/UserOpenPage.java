package com.rislah.models;

import com.google.gson.annotations.SerializedName;

public class UserOpenPage {
    @SerializedName("user_id")
    private String userId;
    private String page;
    private String previousPage;
    private String referrer;

    public String getUserId() {
        return userId;
    }

    public String getPage() {
        return page;
    }

    public String getPreviousPage() {
        return previousPage;
    }

    @Override
    public String toString() {
        return "UserOpenPage{" +
                "userId='" + userId + '\'' +
                ", page='" + page + '\'' +
                ", previousPage='" + previousPage + '\'' +
                ", referrer='" + referrer + '\'' +
                '}';
    }

    public String getReferrer() {
        return referrer;
    }
}
