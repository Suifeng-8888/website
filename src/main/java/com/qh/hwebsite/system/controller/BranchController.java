package com.qh.hwebsite.system.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qh.hwebsite.common.base.BaseQuery;
import com.qh.hwebsite.common.base.Response;
import com.qh.hwebsite.common.entity.Result;
import com.qh.hwebsite.common.untils.StringUtil;
import com.qh.hwebsite.system.entity.Branch;
import com.qh.hwebsite.system.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import com.qh.hwebsite.common.controller.BaseController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author jianch
 * @since 2019-12-28
 */
@Controller
@RequestMapping("/branch")
public class BranchController extends BaseController {

    //菜单
    @Autowired
    private IBranchService branchService;


    private String branch_list = "/branch/list";
    private String branch_edit = "/branch/edit";
    private String branch_look = "/branch/look";
    private String branch_add = "/branch/add";

    /**
     * 跳转list页面
     * @return
     */
    @RequestMapping(value="/toPage")
    public ModelAndView toPage(){
        ModelAndView mv =this.getModelAndView();
        mv.setViewName(branch_list);
        return mv;
    }

    /**
     * 后台分页查询
     * @param e
     * @return json
     * */
    @RequestMapping(value = "/list",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public Response list(Branch e) throws Exception{

        Response response = branchService.findBranchPage(e);
        return response;
    }

    /**
     * 请求查询所有
     * @param
     * @return json
     * */
    @RequestMapping(value = "/allList",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String showlist() throws Exception{
        List<Branch> list = branchService.list();
        return JSON.toJSONString(list);
    }


    /**
     * 查询页面
     * @param
     * @return json
     * */
    @RequestMapping("/find")
    @ResponseBody
    public ModelAndView find(BaseQuery<Branch> query) throws Exception {
        ModelAndView mv = this.getModelAndView();
        Branch branch = branchService.getOne(query.toWrapper());
        mv.addObject("branch",branch);
        mv.setViewName(branch_look);
        return mv;
    }


    /**
     * 新增 or 保存页面
     * @param e
     */
    @RequestMapping(value="/toEdit")
    public ModelAndView toEdit(Branch e) throws Exception{
        ModelAndView mv = this.getModelAndView();
        Branch branch = new Branch();
        if(e.getId()!=null){
            branch = branchService.getById(e.getId());
            mv.addObject("branch",branch);
            mv.setViewName(branch_edit);
        }else {
            mv.setViewName(branch_add);
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
    public String add(Branch e) throws Exception {
        JSONObject obj = getMsg();//返回信息
        if(e.getId()!=null){
            setMsg(obj,"error","ID已存在!");
        }else{
            e.setCode(StringUtil.getCode());
            branchService.save(e);
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
    public String update(Branch e) throws Exception {
        JSONObject obj = getMsg();//返回信息
        if(e.getId()!=null){ //说明对象存在,直接修改
            branchService.updateById(e);
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
    public String delete(Branch e) throws Exception {
        JSONObject obj = getMsg();//返回信息

        if(e.getId()!=null){
            Branch branch = branchService.getById(e.getId());
            if(branch!=null){
                branchService.removeById(e.getId());
            }else{
                setMsg(obj,"error","对象不存在");
            }
        }
        return obj.toString();
    }
}
