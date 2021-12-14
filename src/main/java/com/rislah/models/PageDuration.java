package com.rislah.models;

import com.google.gson.annotations.SerializedName;

public class PageDuration {
    private String page;
    @SerializedName("duration_seconds")
    private Long durationSeconds;

    public PageDuration(String page, Long durationSeconds) {
        this.page = page;
        this.durationSeconds = durationSeconds;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String toString() {
        return "PageDuration{" +
                "page='" + page + '\'' +
                ", durationSeconds=" + durationSeconds +
                '}';
    }
}
