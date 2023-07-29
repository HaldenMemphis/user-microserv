package com.msc.usermicroserv.utils;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @ClassName
 * @Description Return result public class
 * @Author Yifan Liu
 * @Date 2023/06/04 14:21
 * @Version 2.0
 */
@Data
@Slf4j
@NoArgsConstructor
@Getter
@Setter
public class RespVO<T> implements Serializable {

    /**
     * result code
     */
    private Integer code;

    /**
     * Description of results
     */
    private String desc;

    /**
     * outcome
     */
    private T msg;

    /***
     * Changing to private removes the @Deprecated annotation
     **/
    public RespVO(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /***
     * Changing to private removes the @Deprecated annotation
     **/
    public RespVO(Integer code, String desc, T msg) {
        this.code = code;
        this.desc = desc;
        this.msg = msg;
    }



    public static RespVO createResponse(Integer code, String desc) {
        return new RespVO<>(code, desc);
    }

    public static <T> RespVO<T> createResponse(Integer code, String desc, T data) {
        return new RespVO<>(code, desc, data);
    }



}
