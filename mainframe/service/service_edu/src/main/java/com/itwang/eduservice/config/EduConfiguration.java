package com.itwang.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: whiteanbird
 * @Descripter:
 * @Date: 2020:10:06  13:16
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.itwang.eduservice.mapper"})
public class EduConfiguration {

    //删除插件配置
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    //配置分页插件
    @Bean
    public PaginationInterceptor interceptor()
    {
        return new PaginationInterceptor();
    }

}
