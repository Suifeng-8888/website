package com.qh.hwebsite.common.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;


public class BaseController {

    /**
     * 得到ModelAndView  jsp使用
     * @return
     */
    public ModelAndView getModelAndView(){
        return new ModelAndView();
    }


    /**
     * 处理返回的消息信息
     * @param state
     * @param msg
     * @return
     */
    public JSONObject setMsg(JSONObject obj,String state,String msg){
        obj.put("state",state);
        obj.put("message",msg);
        return obj;
    }

    public JSONObject getMsg(){
        JSONObject obj=new JSONObject();
        obj.put("state","ok");
        obj.put("message","操作成功");
        return obj;
    }
}
