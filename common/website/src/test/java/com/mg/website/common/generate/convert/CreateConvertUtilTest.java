package com.mg.website.common.generate.convert;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CreateConvertUtilTest {

    @Test
    void classInit() {
        CreateConvertUtil util = new CreateConvertUtil("matao");
        try {
            util.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}