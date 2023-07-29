package com.msc.usermicroserv.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.msc.usermicroserv.service.UserInfoService;
import com.msc.usermicroserv.utils.OpenMrsAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-28 16:39
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private OpenMrsAPI openMrsAPI;

    @Override
    public JSONObject getAllPatients() {
        JSONObject output = new JSONObject();
        JSONObject json = openMrsAPI.queryPatients("");
        if (!json.isEmpty()) {
            JSONArray results = json.getJSONArray("results");
            output.put("total", results.size());
            output.put("records", results);
            return output;
        }
         return null;
    }

    @Override
    public JSONObject getPatientInfoByUUID(String uuid) {
        return openMrsAPI.getPatientInfoByUUID(uuid);
    }

    @Override
    public JSONObject queryPatients(String query) {
        JSONObject output = new JSONObject();
        JSONObject json = openMrsAPI.queryPatients(query);
        if (!json.isEmpty()) {
            JSONArray results = json.getJSONArray("results");
            output.put("total", results.size());
            output.put("records", results);
            return output;
        }
        return null;
    }
}
