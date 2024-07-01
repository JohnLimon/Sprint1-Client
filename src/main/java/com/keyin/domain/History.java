package com.keyin.domain;

public class History {
    private String calledMethod;
    private String url;
    private String timestamp;

    public History(String calledMethod, String url, String timestamp) {
        this.calledMethod = calledMethod;
        this.url = url;
        this.timestamp = String.valueOf(timestamp);
    }

    public History() {

    }

    public String getCalledMethod() {
        return calledMethod;
    }

    public void setCalledMethod(String calledMethod) {
        this.calledMethod = calledMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = String.valueOf(timestamp);
    }
}
