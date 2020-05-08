package com.mg.website.common.service.convert;

import java.util.ArrayList;
import java.util.List;

public class AttachItem {

    private  int id;

    private  String name;

    private  String type;

    private  String content;

    private short status;

    List<AttachItem> attachItems = new ArrayList<>();

    public void addAttach(AttachItem item)
    {
        this.attachItems.add(item);
    }
}
