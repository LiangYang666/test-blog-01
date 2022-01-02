package com.liang.common.utils;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResult {
    private Integer status; //业务相应状态
    private String msg;     //响应消息
    private Object data;    //响应数据
}
