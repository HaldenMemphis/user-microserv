package com.msc.usermicroserv.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-29 20:23
 **/
@Mapper
public interface DeviceBindMapper {

    int bindDevice(String uuid, String mac);

}
