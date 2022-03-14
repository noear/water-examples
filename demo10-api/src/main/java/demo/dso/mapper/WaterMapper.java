package demo.dso.mapper;

import java.math.*;
import java.sql.SQLException;
import java.time.*;
import java.util.*;

import org.noear.weed.BaseMapper;
import org.noear.weed.DataItem;
import org.noear.weed.DataList;
import org.noear.weed.annotation.Db;
import org.noear.weed.xml.Namespace;
import demo.model.*;

@Db("db_water")
@Namespace("demo.dso.mapper.WaterMapper")
public interface WaterMapper{
    ConfigModel getConfig(String tag, String key) throws SQLException;

    void delConfig(String tag, String key) throws SQLException;
}
