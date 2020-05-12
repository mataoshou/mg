package com.mg.website.common.generate.feign;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CreateFeignConstantTest {

    @Test
    void classInit() {
        CreateFeignConstant action = new CreateFeignConstant("matao", new String[]{
                "get","list"
        });
        try {
            action.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}