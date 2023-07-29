package com.msc.usermicroserv.service;

import com.msc.usermicroserv.utils.RespVO;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-29 18:28
 **/
public interface UserDeviceService {

    RespVO bindDevice(String uuid, String mac);
}
