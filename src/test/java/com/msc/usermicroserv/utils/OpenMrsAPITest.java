package com.msc.usermicroserv.utils;

import static org.junit.jupiter.api.Assertions.*;

import com.alibaba.fastjson2.JSONObject;
import com.msc.usermicroserv.utils.OpenMrsAPI;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class OpenMrsAPITest {

    @Autowired
    private OpenMrsAPI openMrsAPI;

    @Test
    public void testRetrieveSessionToken() {
        assertNotNull(openMrsAPI.getSessionID());
    }

    @Test
    public void testGetPerson() {
        JSONObject result = openMrsAPI.queryPatients("");
        assertNotNull(result);
    }


}