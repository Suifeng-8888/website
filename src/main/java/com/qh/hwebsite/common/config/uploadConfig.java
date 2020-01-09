package com.qh.hwebsite.common.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Component
public class uploadConfig {

    /**
     * 设置上传文件大小
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件上传最大10M
        factory.setMaxFileSize(DataSize.ofBytes(1024*1024*10));
        /// 设置总上传数据总大小100M
        factory.setMaxRequestSize(DataSize.ofBytes(1024*1024*100));
        return factory.createMultipartConfig();
    }
}
