package demo.controller;

import demo.protocol.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.annotation.CloudConfig;
import org.noear.solon.cloud.model.Event;

/**
 * 这是Solon的控制器（基于Solon Bean 容器运行）；可以跳过
 *
 * @author noear 2020/12/28 created
 */
@Slf4j
@Controller
public class TestController {
    @CloudConfig("water_cache_header")
    String water_cache_header;

    //这是本地的
    @Inject
    HelloService helloService;

    //这是远程的
    @NamiClient
    HelloService helloService2;

    @Mapping("/test")
    public String home(String msg) throws Exception {
        helloService.hello();
        helloService2.hello();

        log.warn("Hello world!");

        if (Utils.isNotEmpty(msg)) {
            CloudClient.event().publish(new Event("test.hello", "test2-" + msg));
            return "OK: *" + CloudClient.trace().getTraceId() + "-" + water_cache_header;
        } else {
            return "NO: " + helloService2.hello();
        }
    }
}
