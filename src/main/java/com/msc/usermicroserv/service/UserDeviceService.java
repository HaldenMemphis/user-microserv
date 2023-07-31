package com.msc.usermicroserv.service;

import com.alibaba.fastjson2.JSONObject;
import com.msc.usermicroserv.api.request.BindDeviceRequest;
import com.msc.usermicroserv.utils.RespVO;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-29 18:28
 **/
public interface UserDeviceService {

    RespVO bindDevice(BindDeviceRequest request);

    JSONObject getDeviceByPatientUUID(String uuid);

    RespVO unbindDevice(String uuid, String mac);


    JSONObject getUnbindDevices();
}
