package com.qh.hwebsite.common.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Result {
    //Layui分页参数
    private int code = 0; //
    private String msg = ""; //
    private int count; // 总数
    private List data = new ArrayList(); // 分页集合列表
}
