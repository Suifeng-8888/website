package com.qh.hwebsite.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qh.hwebsite.common.entity.Result;
import com.qh.hwebsite.system.entity.News;

/**
 * <p>
 * 新闻资讯表 服务类
 * </p>
 *
 * @author jianch
 * @since 2019-11-25
 */
public interface INewsService extends IService<News> {
    Result findNewsPage(News e) throws Exception;
}
