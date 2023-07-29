package com.msc.usermicroserv.dao.entity;

import lombok.Data;

/**
 * @program: user-microserv
 * @description: This part is the entity of table 'device bind'
 * @author: yfliu
 * @create: 2023-07-27 16:29
 **/
@Data
public class DeviceBindEntity {
    private Integer id;

    private String mac;

    private String patient_uuid;

}
