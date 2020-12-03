package cc.cottom.proxy.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
@MapperScan(basePackages="cc.cottom.proxy.mapper")
public class MyBatisConfig {
    @Resource(name = "dynamicDataSource")
    private DataSource dynamicDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dynamicDataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:cc/cottom/proxy/mapper/*Mapper.xml"));
        sqlSessionFactory.setTypeAliasesPackage("ccc.cottom.proxy.entities");

        sqlSessionFactory.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis-config.xml"));

        return sqlSessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}
