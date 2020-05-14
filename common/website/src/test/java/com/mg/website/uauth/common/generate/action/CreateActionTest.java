package com.mg.website.uauth.common.generate.action;

import com.mg.common.pojo.SimpleItem;
import com.mg.website.uauth.common.pojo.ApiResultItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CreateActionTest {

    @Test
    void classInit() {

        CreateAction action = new CreateAction("matao", ApiResultItem.class, SimpleItem.class,new String[]{
                "get1","list1"
        });
        try {
            action.startEdit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}