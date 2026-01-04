package com.wugui.datax.admin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Hadoop配置类
 * 处理Windows环境下的Hadoop兼容性问题
 *
 * @author datax-web
 */
@Configuration
public class HadoopConfig {

    private static final Logger logger = LoggerFactory.getLogger(HadoopConfig.class);

    @PostConstruct
    public void init() {
        // 修复Windows环境下Hadoop winutils.exe缺失问题
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            // 设置hadoop.home.dir为根目录，避免查找winutils.exe
            System.setProperty("hadoop.home.dir", "/");
            // 可选：禁用native库以避免winutils相关错误
            // System.setProperty("hadoop.native.lib", "false");
            logger.info("Windows environment detected, Hadoop home dir set to: {}", System.getProperty("hadoop.home.dir"));
        }
    }
}
