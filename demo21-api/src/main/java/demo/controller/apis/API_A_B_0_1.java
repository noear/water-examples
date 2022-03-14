package demo.controller.apis;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Mapping;
import org.noear.water.WaterClient;

import java.util.Map;

/**
 * @author noear 2021/1/13 created
 */
@Component(tag = "api")
public class API_A_B_0_1 {
    @Mapping("A.B.0.1")
    public Map exec() {
        return WaterClient.Config.getByTagKey("water/water").getProp().toMap();
    }
}
