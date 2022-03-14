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
        filter((c,cc)->{
            String json = c.body();
            //
            // 将 body 数据转为 param 数据
            //
            if (Utils.isEmpty(json)) {
                throw ApiCodes.CODE_14;
            } else {
                ONode body = ONode.load(json);

                if(body.isObject()) {
                    body.forEach((k, v) -> {
                        c.paramMap().put(k, v.getString());
                    });
                }

                if (Utils.isEmpty(c.param("method"))) {
                    throw ApiCodes.CODE_14;
                }

                c.pathNew(c.param("method"));
            }

            cc.doFilter(c);
        });

        addBeans(bw -> "api".equals(bw.tag()));
    }


    @Override
    protected boolean allowPathMerging() {
        return false;
    }
}
