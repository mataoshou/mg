package com.mg.empty.demo.mg20200610;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MgDemoTest {

    MgDemo demo = new MgDemo("mg");

    @Test
    void getMessage() {
        assertEquals("mg12",demo.getMessage());
    }
}