package cc.cottom.proxy.config;

import cc.cottom.proxy.bean.DynamicDataSource;
import cc.cottom.proxy.constant.DBType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("mysql.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("mysql.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dynamicDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                        @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        log.info("------------- inject datasource -----");
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBType.MASTER, masterDataSource);
        targetDataSources.put(DBType.SLAVE, slaveDataSource);
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }
}
