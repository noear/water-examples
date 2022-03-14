package demo.controller;

import demo.controller.interceptor.AuthInterceptor;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;

/**
 * 网关，添加签权处理
 *
 * @author noear 2021/1/13 created
 */
@Mapping("/api/v2/**")
@Component
public class ApiGatewayV2 extends GatewayBase {
    @Override
    protected void register() {
        before(AuthInterceptor.class);

        addBeans(bw -> "api".equals(bw.tag()));
    }
}
