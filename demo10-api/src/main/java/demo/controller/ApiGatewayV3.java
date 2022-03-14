package demo.controller;

import org.noear.snack.ONode;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * 数据包需要预处理，才能获取接口包
 *
 * @author noear 2021/1/13 created
 */
@Mapping("/api/v3/")
@Component
public class ApiGatewayV3 extends GatewayBase {
    @Override
    protected void register() {
        addBeans(bw -> "api".equals(bw.tag()));
    }


    @Override
    protected Handler find(Context c) throws Throwable {
        return findDo(c, c.param("method").toUpperCase());
    }

    @Override
    protected boolean allowPathMerging() {
        return false;
    }
}
