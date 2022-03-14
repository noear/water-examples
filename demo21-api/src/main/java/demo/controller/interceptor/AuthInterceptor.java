package demo.controller.interceptor;

import demo.controller.ApiCodes;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Handler;

/**
 * @author noear 2021/1/14 created
 */
public class AuthInterceptor implements Handler {
    @Override
    public void handle(Context c) throws Throwable {
        if(c.param("jwt") == null){
            throw ApiCodes.CODE_14;
        }
    }
}
