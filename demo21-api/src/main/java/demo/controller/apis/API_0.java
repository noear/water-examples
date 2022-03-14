package demo.controller.apis;

import demo.controller.ApiCodes;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;

/**
 * 默认接口，在没有区配的接口时；会执行这个接口的代码
 *
 * @author noear 2021/1/13 created
 */
@Component(tag = "api")
public class API_0 {
    /**
     * Mapping 没有值时，为网关的默认接口
     * */
    @Mapping
    public void exec() {
        throw ApiCodes.CODE_11;
    }
}
