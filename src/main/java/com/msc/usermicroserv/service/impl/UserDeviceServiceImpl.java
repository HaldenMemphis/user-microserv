package com.msc.usermicroserv.service.impl;

import com.msc.usermicroserv.dao.mapper.DeviceBindMapper;
import com.msc.usermicroserv.service.UserDeviceService;
import com.msc.usermicroserv.utils.RespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public RespVO bindDevice(String uuid, String mac) {
        if (!isValidMacAddress(mac) || !isValidUuid(uuid)) {
            return new RespVO(500, "Invalid mac or uuid", null);
        }
        try {
            if (deviceBindMapper.bindDevice(uuid, mac) == 1) {
                return RespVO.createSuccessResponse();
            } else {
                return new RespVO(500, "Bind failed", null);
            }
        } catch (Exception e) {
            return new RespVO(500, "error", e.getMessage());
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
        // 创建 Pattern 对象
        Pattern pattern = Pattern.compile(UUID_REGEX);

        // 创建 Matcher 对象
        Matcher matcher = pattern.matcher(input);

        // 检查是否匹配
        return matcher.matches();
    }
}
