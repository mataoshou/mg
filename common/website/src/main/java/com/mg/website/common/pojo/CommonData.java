package com.mg.website.common.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Scope("prototype")
public class CommonData {

    private String id;

    private String parentCode1;

    private String parentCode2;

    private String createName;

    private String createId;

    private String changerId;

    private String parent1Name;

    private String parent2Name;


    private Short status1;

    private Short status2;

    private Short status3;

    private String title ;

    private String ptitle;

    private String thumb;

    private String content;

    private Date createTime;

    private  Date beginTime;

    private Date endTime;

    private  Long begin;

    private Long end;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentCode1() {
        return parentCode1;
    }

    public void setParentCode1(String parentCode1) {
        this.parentCode1 = parentCode1;
    }

    public String getParentCode2() {
        return parentCode2;
    }

    public void setParentCode2(String parentCode2) {
        this.parentCode2 = parentCode2;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getChangerId() {
        return changerId;
    }

    public void setChangerId(String changerId) {
        this.changerId = changerId;
    }

    public String getParent1Name() {
        return parent1Name;
    }

    public void setParent1Name(String parent1Name) {
        this.parent1Name = parent1Name;
    }

    public String getParent2Name() {
        return parent2Name;
    }

    public void setParent2Name(String parent2Name) {
        this.parent2Name = parent2Name;
    }

    public Short getStatus1() {
        return status1;
    }

    public void setStatus1(Short status1) {
        this.status1 = status1;
    }

    public Short getStatus2() {
        return status2;
    }

    public void setStatus2(Short status2) {
        this.status2 = status2;
    }

    public Short getStatus3() {
        return status3;
    }

    public void setStatus3(Short status3) {
        this.status3 = status3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getBegin() {
        return begin;
    }

    public void setBegin(Long begin) {
        this.begin = begin;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
