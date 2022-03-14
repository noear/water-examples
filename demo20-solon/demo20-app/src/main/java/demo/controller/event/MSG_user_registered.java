package demo.controller.event;

import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;

/**
 * @author noear 2021/3/12 created
 */
@CloudEvent("user.registered")
public class MSG_user_registered implements CloudEventHandler {
    @Override
    public boolean handler(Event event) throws Throwable {
        System.out.println("有用户注册了");
        return true;
    }
}
