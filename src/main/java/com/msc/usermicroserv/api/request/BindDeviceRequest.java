package com.msc.usermicroserv.api.request;

import lombok.Data;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-29 18:16
 **/
@Data
public class BindDeviceRequest {

    private String uuid;

    private String mac;


}
