package com.msc.usermicroserv.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.msc.usermicroserv.api.request.BindDeviceRequest;
import com.msc.usermicroserv.dao.entity.DeviceBindEntity;
import com.msc.usermicroserv.dao.entity.DeviceInfoEntity;
import com.msc.usermicroserv.dao.mapper.DeviceBindMapper;
import com.msc.usermicroserv.service.UserDeviceService;
import com.msc.usermicroserv.utils.RespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-29 18:29
 **/
@Service
public class UserDeviceServiceImpl implements UserDeviceService {

    private static final String MAC_ADDRESS_REGEX = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";

    private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";


    @Autowired
    private DeviceBindMapper deviceBindMapper;

    @Override
//    @Transactional
    public RespVO bindDevice(BindDeviceRequest request) {
        if (!isValidMacAddress(request.getMac()) || !isValidUuid(request.getUuid())) {
            return new RespVO(500, "Invalid mac or uuid", null);
        }
        try {
            if (deviceBindMapper.bindDevice(request) == 1) {
                return RespVO.createSuccessResponse();
            } else {
                return new RespVO(500, "Bind failed", null);
            }
        } catch (Exception e) {
            return new RespVO(500, "error", e.getMessage());
        }
    }

    @Override
    public JSONObject getDeviceByPatientUUID(String uuid) {
        JSONObject output = new JSONObject();
        try {
            List<DeviceBindEntity> results = deviceBindMapper.getDeviceByPatientUUID(uuid);
            output.put("total", results.size());
            output.put("records", results);
            return output;
        }catch(Exception e){
            output.put("code:",500);
            output.put("desc:",e.getMessage());
            return output;
        }
    }

    @Override
    public RespVO unbindDevice(String uuid, String mac) {
        if (!isValidMacAddress(mac) || !isValidUuid(uuid)) {
            return new RespVO(500, "Invalid mac or uuid", null);
        }
        try{
            if(deviceBindMapper.unbindDevice(uuid, mac) == 1) {
                return RespVO.createSuccessResponse();
            }else {
                return new RespVO(500, "Unbind failed", null);
            }
        }catch (Exception e) {
            return new RespVO(500, "error", e.getMessage());
        }

    }

    @Override
    public JSONObject getUnbindDevices() {
        JSONObject output = new JSONObject();
        try{
            List<DeviceInfoEntity> results = deviceBindMapper.getUnbindDevices();
            output.put("total", results.size());
            output.put("records", results);
            return output;
        }catch (Exception e) {
            output.put("code:",500);
            output.put("desc:",e.getMessage());
            return output;
        }
    }

    public static boolean isValidMacAddress(String input) {
        // Create Pattern 对象
        Pattern pattern = Pattern.compile(MAC_ADDRESS_REGEX);

        // Create Matcher 对象
        Matcher matcher = pattern.matcher(input);

        // Check
        return matcher.matches();
    }


    public static boolean isValidUuid(String input) {
        Pattern pattern = Pattern.compile(UUID_REGEX);

        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
