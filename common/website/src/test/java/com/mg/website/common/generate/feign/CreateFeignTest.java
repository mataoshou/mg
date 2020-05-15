package com.mg.website.common.generate.feign;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class CreateFeignTest {

    @Test
    void classInit() {

        CreateFeign action = new CreateFeign("matao", new String[]{
                "get","list"
        });
        try {
            action.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}