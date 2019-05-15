package mybatis.read.config;

import mybatis.read.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

/**
 * @author gaoxx gaoxx@fxiaoke.com
 * @ClassName: AppConfig
 * @Description: AppConfig
 * @datetime 2019/4/25 19:37
 * @Version 1.0
 */
@Configuration
@ComponentScan({"org.mybatis", "mybatis.read"})
public class AppConfig {

    @Bean
    public UserMapper userMapper() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate((SqlSessionFactory) sqlSessionFactory());
        return sqlSessionTemplate.getMapper(UserMapper.class);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return (SqlSessionFactoryBean) factoryBean.getObject();
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


}
