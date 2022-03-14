package demo;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.cache.CacheService;
import org.noear.weed.cache.LocalCache;
import org.noear.weed.solon.plugin.CacheWrap;

import javax.sql.DataSource;

/**
 * @author noear 2021/1/13 created
 */
@Configuration
public class Config {
    /**
     * Water 数据源
     * ${water.water} 配置是由从配置服务加载的配置
     */
    @Bean("db_water")
    public DataSource waterDb(@Inject("${water.water}") HikariDataSource ds) {
        return ds;
    }

    /**
     * 泛缓存
     *
     * CacheWrap 对：Solon:CacheService 和 Weed3:ICacheServiceEx 做了双重适配
     */
    @Bean(value = "cache", typed = true)
    public CacheService cache() {
        //对Weed3:ICacheServiceEx 做包装，以兼容Weed3 与 Solon的双重需求
        return CacheWrap.wrap(new LocalCache().nameSet("cache"));
    }
}
