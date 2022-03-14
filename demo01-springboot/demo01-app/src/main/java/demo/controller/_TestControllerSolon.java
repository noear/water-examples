package demo.controller;

import org.noear.nami.annotation.NamiClient;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;
import org.noear.water.WaterClient;
import demo.protocol.HelloService;

/**
 * 这是Solon的控制器（基于Solon Bean 容器运行）；可以跳过
 * */
@Controller
public class _TestControllerSolon {
    //这是本地的
    @Inject
    HelloService helloService;

    //这是远程的
    @NamiClient
    HelloService helloService2;

    @Mapping("/test2")
    public String home(String msg) throws Exception {
        helloService.hello();
        helloService2.hello();

        if (Utils.isNotEmpty(msg)) {
            CloudClient.event().publish(new Event("test.hello", "test-"+msg));
            return "OK: *" + WaterClient.waterTraceId();
        }else{
            return "NO" + helloService2.hello();
        }
    }
}
