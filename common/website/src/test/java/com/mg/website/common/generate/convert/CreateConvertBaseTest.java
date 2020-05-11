package com.mg.website.common.generate.convert;

import com.mg.website.common.pojo.ApiResultItem;
import com.mg.common.pojo.SimpleItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CreateConvertBaseTest {


    @Test
    void testCreate() {
        CreateConvertBase base = new CreateConvertBase("matao",
                SimpleItem.class);
        try {
            base.startCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}