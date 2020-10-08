package com.itwang.servicebase;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

/**
 * @Author: whiteanbird
 * @Descripter:
 * @Date: 2020:10:06  15:08
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //接口文档
    @Bean
    public Docket webApiConfig()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webapi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("error.*")))
                .build();
    }

    private ApiInfo webApiInfo()
    {
        return new ApiInfoBuilder()
                .title("api文档")
                .description("接口定义")
                .version("1.0")
                .contact(new Contact("whiteandbird","http://atguigu.com","2714269544@qq.com"))
                .build();
    }
}
