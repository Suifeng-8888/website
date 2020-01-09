package com.qh.hwebsite.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/front")
public class IndexController {

    /**
     * 网站首页
     * @return
     */
    @RequestMapping("/{index}")
    public String getIndex(@PathVariable("index")String index){

        return "front/"+index;
    }

}
