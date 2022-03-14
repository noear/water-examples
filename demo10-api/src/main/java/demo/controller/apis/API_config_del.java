package demo.controller.apis;

import demo.controller.ApiBase;
import demo.dso.mapper.WaterMapper;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author noear 2021/1/13 created
 */
@Component(tag = "api")
public class API_config_del extends ApiBase {

    @Inject
    WaterMapper waterMapper;

    @Mapping("config/del")
    public void exec() throws SQLException {
         waterMapper.delConfig("water","water");
    }
}
