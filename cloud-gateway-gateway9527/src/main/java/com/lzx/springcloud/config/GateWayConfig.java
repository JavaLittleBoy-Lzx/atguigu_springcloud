package com.lzx.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName GateWayConfig
 * @Description TODO
 * @Author lzx
 * @Date 2023/8/4 14:49:07
 * @Version 1.0
 **/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",r -> r.path("/path").uri("http://new.baidu.com/guonei")).build();
        return routes.build();
    }
}
