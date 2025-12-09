package spring.boot.hibernate;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
// 用于扫描Servlet、Filter和Listener
@ServletComponentScan("spring.boot.hibernate.common")
@EnableJpaRepositories(basePackages = "spring.boot.hibernate.dao")
@EntityScan(basePackages = "spring.boot.hibernate.pojo")
public class Application {

    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("Start Success");
    }

    private static Logger logger = Logger.getLogger(Application.class);

    @Bean
    // 这里定义的 DataSource 将覆盖其他来源的 DataSource
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.addUrlMappings("*.action");
        return registration;
    }

}
