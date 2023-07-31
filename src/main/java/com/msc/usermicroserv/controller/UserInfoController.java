package com.msc.usermicroserv.controller;

import com.alibaba.fastjson2.JSONObject;
import com.msc.usermicroserv.api.request.PatientInfoRequest;
import com.msc.usermicroserv.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: user-microserv
 * @description: This part used for modify User's Information
 * @author: yfliu
 * @create: 2023-07-27 16:21
 **/
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/getAllPatients")
    public JSONObject getAllPatients() {
        return userInfoService.getAllPatients();
    }

    @RequestMapping(value = "/getPatientInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject getPatientInfo(@RequestBody PatientInfoRequest request, HttpServletRequest httpRequest) {
        return userInfoService.getPatientInfoByUUID(request.getUuid());
    }

    @GetMapping("/queryPatients")
    public JSONObject queryPatients(@RequestParam("q") String query) {
        return userInfoService.queryPatients(query);
    }
}
