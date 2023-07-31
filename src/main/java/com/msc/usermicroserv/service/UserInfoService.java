package com.msc.usermicroserv.service;

import com.alibaba.fastjson2.JSONObject;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-28 16:39
 **/
public interface UserInfoService {

    JSONObject getAllPatients();

    JSONObject getPatientInfoByUUID(String uuid);

    JSONObject queryPatients(String query);
}
