package com.vip.darker.system.interceptor.config;

import com.vip.darker.system.interceptor.LogInterceptor;
import com.vip.darker.system.interceptor.LoginInterceptor;
import com.vip.darker.system.interceptor.TrashInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Darker
 * @description ：全局拦截器配置
 * @date : 2018/9/12 16:36
 */
@Configuration
public class SpringBootInterceptorConfig implements WebMvcConfigurer {

    /**
     * 功能描述: 拦截器配置
     *
     * @auther: darker
     * @date: 2018/9/12 16:47
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 日志拦截配置
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/home")
                .addPathPatterns("/admin");
        // 登录拦截配置
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin")
                .addPathPatterns("/admin/login");
        // 删除方法拦截
        registry.addInterceptor(new TrashInterceptor())
                .addPathPatterns("/**/**")
                .excludePathPatterns("/admin/**")
                .excludePathPatterns("/index/**")
                .excludePathPatterns("/home/**")
                .excludePathPatterns("/bootstrap/**")
                .excludePathPatterns("/editor/**")
                .excludePathPatterns("/font-awesome/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/music/**")
                .excludePathPatterns("/sweetalert/**")
                .excludePathPatterns("/zeromodal/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**");
    }

    /**
     * 功能描述: 视图控制器配置
     *
     * @auther: darker
     * @date: 2018/10/27 16:08
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error/404").setViewName("/error/404");
        registry.addViewController("/error/500").setViewName("/error/500");
    }
}