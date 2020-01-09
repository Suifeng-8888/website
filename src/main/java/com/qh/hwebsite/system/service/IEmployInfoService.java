package com.qh.hwebsite.system.service;

import com.qh.hwebsite.common.entity.Result;
import com.qh.hwebsite.system.entity.EmployInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门招聘信息表 服务类
 * </p>
 *
 * @author jianch
 * @since 2019-12-28
 */
public interface IEmployInfoService extends IService<EmployInfo> {

    //分页查询
    Result findEmployPage(EmployInfo e)throws Exception;
}
