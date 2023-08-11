package com.msc.usermicroserv.api.request;

import lombok.Data;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-08-11 13:49
 **/
@Data
public class UpdateDeviceStatusRequest {

        private String mac;

        private Boolean status;

    public UpdateDeviceStatusRequest(String mac, boolean status) {
        this.mac = mac;
        this.status = status;
    }
}
