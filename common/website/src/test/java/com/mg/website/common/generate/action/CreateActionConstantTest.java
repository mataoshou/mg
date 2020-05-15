package com.mg.website.common.generate.action;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class CreateActionConstantTest {

    @Test
    void classInit() {

        CreateActionConstant action = new CreateActionConstant("matao", new String[]{
                "get","list"
        });
        try {
            action.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CreateActionConstant action1 = new CreateActionConstant("matao", new String[]{
                "get1","list1"
        });
        try {
            action1.startEdit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}