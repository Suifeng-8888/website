package com.qh.hwebsite.system.service;

import com.qh.hwebsite.common.base.Response;
import com.qh.hwebsite.common.entity.Result;
import com.qh.hwebsite.system.entity.Branch;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author jianch
 * @since 2019-12-28
 */
public interface IBranchService extends IService<Branch> {

    //分页查询
    Response findBranchPage(Branch e)throws Exception;
}
