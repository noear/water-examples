package demo.controller;

import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;
import org.noear.water.utils.Datetime;

/**
 * 消息订阅（可以自己发出去，再自己订阅回来；起来拆解性能消耗的作用）
 *
 * */
@CloudEvent("test.hello")
public class TestMessageHandler implements CloudEventHandler {

    @Override
    public boolean handler(Event event) throws Throwable {
        Datetime dt = Datetime.Now().addSecond(10);

        CloudClient.event()
                .publish(new Event("test.hello", event.content()).scheduled(dt.getFulltime()));

        return true;
    }
}
