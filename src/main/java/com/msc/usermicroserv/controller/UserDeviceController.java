package com.msc.usermicroserv.controller;

import com.msc.usermicroserv.api.request.BindDeviceRequest;
import com.msc.usermicroserv.service.UserDeviceService;
import com.msc.usermicroserv.utils.RespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: user-microserv
 * @description: This part used to bind patient and the devices
 * @author: yfliu
 * @create: 2023-07-27 16:21
 **/
@RestController
public class UserDeviceController {
    @Autowired
    private UserDeviceService userDeviceService;

    @PostMapping("/bindDevice")
    public RespVO bindDevice(@RequestBody BindDeviceRequest request) {
        return userDeviceService.bindDevice(request.getUuid(), request.getMac());
    }


}
