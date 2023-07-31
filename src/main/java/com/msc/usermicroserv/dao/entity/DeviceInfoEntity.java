package com.msc.usermicroserv.dao.entity;

import lombok.Data;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-30 21:25
 **/
@Data
public class DeviceInfoEntity {

    private Integer deviceId;

    private String mac;

    private String deviceType;

    private String displayName;

}
