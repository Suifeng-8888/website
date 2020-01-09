package com.qh.hwebsite.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qh.hwebsite.common.base.BaseQuery;
import com.qh.hwebsite.common.entity.Result;
import com.qh.hwebsite.system.entity.EmployInfo;
import com.qh.hwebsite.system.entity.query.EmployQquey;
import com.qh.hwebsite.system.service.IEmployInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import com.qh.hwebsite.common.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * <p>
 * 部门招聘信息表 前端控制器
 * </p>
 *
 * @author jianch
 * @since 2019-12-28
 */
@Controller
@RequestMapping("/employInfo")
public class EmployInfoController extends BaseController {

    //菜单
    @Autowired
    private IEmployInfoService employInfoService;


    private String employ_list = "/employ/list";
    private String employ_edit = "/employ/edit";
    private String employ_look = "/employ/look";
    private String employ_add = "/employ/add";

    /**
     * 跳转list页面
     * @return
     */
    @RequestMapping(value="/toPage")
    public ModelAndView toPage(){
        ModelAndView mv =this.getModelAndView();
        mv.setViewName(employ_list);
        return mv;
    }

    /**
     * 后台分页查询
     * @param e
     * @return json
     * */
    @RequestMapping(value = "/list",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String list(EmployInfo e) throws Exception{
        Result result = employInfoService.findEmployPage(e);
        return JSON.toJSONString(result);
    }

    /**
     * 前端查询招聘部门
     * @param
     * @return json
     * */
    @RequestMapping(value = "/allList",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showlist(EmployQquey query) throws Exception{
        List<EmployInfo> list = employInfoService.list(query.toWrapper());
        return JSON.toJSONString(list);
    }

    /**
     * 前端查询部门招聘详情
     */
    @RequestMapping(value = "/detail",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showEmployInfo(EmployInfo e) throws Exception{
        QueryWrapper<EmployInfo> queryWrapper = Wrappers.query(e);
        List<EmployInfo> list = employInfoService.list(queryWrapper);
        return JSON.toJSONString(list);
    }

    /**
     * 查询页面
     * @param
     * @return json
     * */
    @RequestMapping("/find")
    @ResponseBody
    public ModelAndView find(BaseQuery<EmployInfo> query) throws Exception {
        ModelAndView mv = this.getModelAndView();
        EmployInfo employ = employInfoService.getOne(query.toWrapper());
        mv.addObject("employ",employ);
        mv.setViewName(employ_look);
        return mv;
    }


    /**
     * 新增 or 保存页面
     * @param e
     */
    @RequestMapping(value="/toEdit")
    public ModelAndView toEdit(EmployInfo e) throws Exception{
        ModelAndView mv = this.getModelAndView();
        EmployInfo employ = new EmployInfo();
        if(e.getId()!=null){
            employ = employInfoService.getById(e.getId());
            mv.addObject("employ",employ);
            mv.setViewName(employ_edit);
        }else {
            mv.setViewName(employ_add);
        }
        return mv;
    }

    /**
     * 保存新增
     * @param e
     * @return json
     * */
    @RequestMapping(value="/add")
    @ResponseBody
    public String add(EmployInfo e) throws Exception {
        JSONObject obj = getMsg();//返回信息
        if(e.getId()!=null){
            setMsg(obj,"error","ID已存在!");
        }else{
            String name=e.getPname();
            int num = name.indexOf("|");
            String pname = name.substring(0,num);
            String pid = name.substring(num+1);
            e.setPname(pname);
            e.setPid(Long.parseLong(pid));
            employInfoService.save(e);
        }
        return obj.toString();
    }

    /**
     * 修改
     * @param e
     * @return json
     * */
    @RequestMapping(value="/update")
    @ResponseBody
    public String update(EmployInfo e) throws Exception {
        JSONObject obj = getMsg();//返回信息
        if(e.getId()!=null){ //说明对象存在,直接修改
            employInfoService.updateById(e);
        }else{
            setMsg(obj,"error","菜单不存在!");
        }
        return obj.toString();
    }

    /**
     * 删除
     * @param e
     * @return json
     * */
    @RequestMapping(value="/delete")
    @ResponseBody
    public String delete(EmployInfo e) throws Exception {
        JSONObject obj = getMsg();//返回信息

        if(e.getId()!=null){
            EmployInfo employ = employInfoService.getById(e.getId());
            if(employ!=null){
                employInfoService.removeById(e.getId());
            }else{
                setMsg(obj,"error","对象不存在");
            }
        }
        return obj.toString();
    }
}
