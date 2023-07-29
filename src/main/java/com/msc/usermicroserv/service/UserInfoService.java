package com.msc.usermicroserv.service;

import com.alibaba.fastjson2.JSONObject;
import com.msc.usermicroserv.utils.RespVO;

import java.util.List;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-28 16:39
 **/
public interface UserInfoService {

    public JSONObject getAllPatients();

    public JSONObject getPatientInfoByUUID(String uuid);

    public JSONObject queryPatients(String query);
}
