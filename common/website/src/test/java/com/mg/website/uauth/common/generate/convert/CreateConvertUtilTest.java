package com.mg.website.uauth.common.generate.convert;



import org.junit.jupiter.api.Test;

import java.io.IOException;

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