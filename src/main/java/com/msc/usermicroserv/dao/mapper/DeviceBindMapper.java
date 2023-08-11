package com.msc.usermicroserv.dao.mapper;

import com.msc.usermicroserv.api.request.BindDeviceRequest;
import com.msc.usermicroserv.api.request.UpdateDeviceStatusRequest;
import com.msc.usermicroserv.dao.entity.DeviceBindEntity;
import com.msc.usermicroserv.dao.entity.DeviceInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-29 20:23
 **/
@Mapper
public interface DeviceBindMapper {

    int bindDevice(BindDeviceRequest request);

    List<DeviceBindEntity> getDeviceByPatientUUID(String uuid);

    int unbindDevice(String uuid, String mac);

//    List<DeviceInfoEntity> queryDeviceInfo(String mac);

    int updateDeviceBindStatus(UpdateDeviceStatusRequest request);

    List<DeviceInfoEntity> getUnbindDevices();
}
