package demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Utils;
import org.noear.solon.cloud.CloudConfigHandler;
import org.noear.solon.cloud.annotation.CloudConfig;
import org.noear.solon.cloud.model.Config;

/**
 * 配置订阅（获取配置的时实刷新）
 *
 * @author noear 2021/1/6 created
 */
@Slf4j
@CloudConfig("water")
public class TestConfigHandler implements CloudConfigHandler {
    @Override
    public void handler(Config config) {
        if (Utils.isNotEmpty(config.value())) {
            log.warn(config.value());
        }
    }
}
