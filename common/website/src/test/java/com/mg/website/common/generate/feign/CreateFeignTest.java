package com.mg.website.common.generate.feign;

import com.mg.website.common.generate.action.CreateActionConstant;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CreateFeignTest {

    @Test
    void classInit() {

        CreateFeign action = new CreateFeign("matao", new String[]{
                "get","list"
        },"matao");
        try {
            action.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}