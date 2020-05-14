package com.mg.website.uauth.common.generate.feign;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class CreateFeignFallBackTest {

    @Test
    void classInit() {
        CreateFeignFallBack action = new CreateFeignFallBack("matao", new String[]{
                "get","list"
        });
        try {
            action.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}