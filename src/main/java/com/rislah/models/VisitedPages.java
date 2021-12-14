package com.rislah.models;

public class VisitedPages {
    private String page;
    private long count;

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }


    public VisitedPages(String page, long count) {
        this.page = page;
        this.count = count;
    }

    @Override
    public String toString() {
        return "VisitedPages{" +
                "page='" + page + '\'' +
                ", count=" + count +
                '}';
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
