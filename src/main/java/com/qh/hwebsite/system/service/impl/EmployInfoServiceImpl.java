package com.qh.hwebsite.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.hwebsite.common.entity.Result;
import com.qh.hwebsite.common.untils.Const;
import com.qh.hwebsite.system.entity.EmployInfo;
import com.qh.hwebsite.system.mapper.EmployInfoMapper;
import com.qh.hwebsite.system.service.IEmployInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门招聘信息表 服务实现类
 * </p>
 *
 * @author jianch
 * @since 2019-12-28
 */
@Service
public class EmployInfoServiceImpl extends ServiceImpl<EmployInfoMapper, EmployInfo> implements IEmployInfoService {

    @Override
    public Result findEmployPage(EmployInfo e) throws Exception {
        String curPage=e.getPage();//获取当前页
        String numPage=e.getLimit();//获取每页显示数量
        if(!StringUtils.isNotBlank(curPage)){
            curPage= Const.curPage;
        }
        if(!StringUtils.isNotBlank(numPage)){
            numPage=Const.numPage;
        }
        int cur=Integer.parseInt(curPage);
        int num=Integer.parseInt(numPage);
        QueryWrapper<EmployInfo> queryWrapper = Wrappers.query(e);
        IPage<EmployInfo> pageData = this.baseMapper.selectPage(new Page<>(cur, num), queryWrapper);
        Result result=new Result();
        result.setCount((int)pageData.getTotal());
        result.setData(pageData.getRecords());
        return result;
    }
}
