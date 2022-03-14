package testapi.controller;

import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TestController {
    static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Mapping("/")
    public String home(String msg) throws Exception {

        logger.info("有人刷了一下");

        if (Utils.isNotEmpty(msg)) {
            CloudClient.event().publish(new Event("test.hello", msg));
            return "OK: *" + CloudClient.trace().getTraceId();
        } else {
            return "NO";
        }
    }
}
