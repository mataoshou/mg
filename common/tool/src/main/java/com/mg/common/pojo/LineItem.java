package com.mg.common.pojo;

public class LineItem {

    private String content;

    private String intervalStr ="  ";

    private int intervalNo =0;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntervalStr() {
        return intervalStr;
    }

    public void setIntervalStr(String intervalStr) {
        this.intervalStr = intervalStr;
    }

    public int getIntervalNo() {
        return intervalNo;
    }

    public void setIntervalNo(int intervalNo) {
        this.intervalNo = intervalNo;
    }
}