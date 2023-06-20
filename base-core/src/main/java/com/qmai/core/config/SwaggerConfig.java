package com.qmai.core.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 */
@EnableSwagger2
@EnableKnife4j
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     *
     * 显示swagger-ui.html文档展示页，还必须注入swagger资源：
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Value("${spring.profile.active}")
    private String profile;

    @Bean
    public Docket manager() {

        // 扫描指定接口所在路径
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qmai.manager.controller"))
                .paths(PathSelectors.any())
                .build().groupName("managerApi");
    }

    // swagger 信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Manager 后台服务API接口文档")
                .description("企迈数据管理中台系统")
                .version("4.0")
                .build();
    }


    @Bean
    public Docket openapi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qmai.openapi.controller"))
                .build().groupName("openapi")
                .apiInfo(apiInfo(profile));
    }

    private ApiInfo apiInfo(String profile) {
        return new ApiInfoBuilder()
                .title("开放平台接口文档-" + profile)
                .description("智迈数据管理中台系统")
                .version("3.0")
                .contact(new Contact("QMAI", "https://git.zmcms.cn/OpenPlatform/openapi-center", ""))
                .build();
    }
}
