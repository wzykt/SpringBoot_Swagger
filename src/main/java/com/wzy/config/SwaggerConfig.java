package com.wzy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.annotation.Validated;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Properties;

@Configuration
@EnableSwagger2 //开启Swagger
public class SwaggerConfig {


    //分组
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("a");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("b");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("c");
    }

    @Bean
    public Docket docket(Environment environment) {

        Profiles profiles = Profiles.of("pro");
        //通过environment.acceptsProfiles(profiles)判断是否处在自己设顶的环境中
        boolean isSwagger = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(isSwagger)//关闭swagger，不能访问swagger-ui.html
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //basePackage扫描指定的包
                //withMethodAnnotation() 扫描类上的注解，参数是一个注解的反射对象
                .apis(RequestHandlerSelectors.basePackage("com.wzy.controller"))

                //过滤指定路径
                //.paths(PathSelectors.ant("/wzy/*"))
                .build();
    }

    //为swagger-ui.html设置自定义样式
    public ApiInfo apiInfo() {
        return new ApiInfo("Swagger wzy",
                "Swagger test",
                "1.0",
                "urn:tos",
                new Contact("wzy","www.baidu.com","1540697727@qq.com"),
                "Apache 2.1",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
