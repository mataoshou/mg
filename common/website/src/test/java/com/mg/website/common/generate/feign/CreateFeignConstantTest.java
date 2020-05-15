package com.mg.website.common.generate.feign;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class CreateFeignConstantTest {

    @Test
    void classInit() {
        CreateFeignConstant action = new CreateFeignConstant("matao", new String[]{
                "get","list"
        },"matao");
        try {
            action.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}