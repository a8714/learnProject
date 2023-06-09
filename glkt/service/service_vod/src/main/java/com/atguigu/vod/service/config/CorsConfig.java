package com.atguigu.vod.service.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * @author roo
 * @date 2023/3/15
 */
@Configuration // 一定不要忽略此注解
public class CorsConfig  {
//    @Bean
//    public CorsFilter corsFilter() {
//        //1. 添加 CORS配置信息
//        CorsConfiguration config = new CorsConfiguration();
//        //放行哪些原始域
//        config.addAllowedOrigin("*");
//        //是否发送 Cookie
//        config.setAllowCredentials(true);
//        //放行哪些请求方式
//        config.addAllowedMethod("*");
//        //放行哪些原始请求头部信息
//        config.addAllowedHeader("*");
//        //暴露哪些头部信息
//        config.addExposedHeader("*");
//        //2. 添加映射路径
//        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        corsConfigurationSource.registerCorsConfiguration("/**",config);
//        //3. 返回新的CorsFilter
//        return new CorsFilter(corsConfigurationSource);
//}

}

