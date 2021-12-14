package com.rislah.models;

import com.google.gson.annotations.SerializedName;

public class UserClickPromotion {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("promotion_id")
    private String promotionId;

    public String getUserId() {
        return userId;
    }

    public String getPromotionId() {
        return promotionId;
    }
}
