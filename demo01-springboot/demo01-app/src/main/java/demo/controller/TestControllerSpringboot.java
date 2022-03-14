package demo.controller;

import demo.protocol.HelloService;
import org.noear.nami.annotation.NamiClient;
import org.noear.solon.Utils;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.annotation.CloudConfig;
import org.noear.solon.cloud.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 这是Solon的控制器（基于Solon Bean 容器运行）；可以跳过
 *
 * @author noear 2020/12/28 created
 */
@RestController
public class TestControllerSpringboot {
    static Logger log = LoggerFactory.getLogger(TestControllerSpringboot.class);

    @CloudConfig("water_cache_header")
    String water_cache_header;

    //这是本地的
    @Resource
    HelloService helloService;

    //这是远程的
    @NamiClient
    HelloService helloService2;

    @RequestMapping("/test")
    public String home(String msg) throws Exception {
        helloService.hello();
        helloService2.hello();

        log.info("测试：（");
        log.warn("测试测试");


        if (Utils.isNotEmpty(msg)) {
            CloudClient.event().publish(new Event("test.hello", "test2-" + msg));
            return "OK: *" + CloudClient.trace().getTraceId() + "-" + water_cache_header;
        } else {
            return "NO: " + helloService2.hello();
        }
    }
}
