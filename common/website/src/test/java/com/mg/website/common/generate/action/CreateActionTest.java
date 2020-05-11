package com.mg.website.common.generate.action;

import com.mg.common.pojo.SimpleItem;
import com.mg.website.common.pojo.ApiResultItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CreateActionTest {

    @Test
    void classInit() {

        CreateAction action = new CreateAction("matao", ApiResultItem.class, SimpleItem.class,new String[]{
                "get","list"
        });
        try {
            action.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}