package com.qh.hwebsite.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qh.hwebsite.common.entity.Result;
import com.qh.hwebsite.common.untils.Const;
import com.qh.hwebsite.system.entity.News;
import com.qh.hwebsite.system.mapper.NewsMapper;
import com.qh.hwebsite.system.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 新闻资讯表 服务实现类
 * </p>
 *
 * @author jianch
 * @since 2019-11-25
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    @Override
    public Result findNewsPage(News e) throws Exception {
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
        QueryWrapper<News> queryWrapper = Wrappers.query(e);

        IPage<News> pageData = this.baseMapper.selectPage(new Page<News>(cur, num), queryWrapper);
        Result result=new Result();
        result.setCount((int)pageData.getTotal());
        result.setData(pageData.getRecords());
        return result;
    }
}
