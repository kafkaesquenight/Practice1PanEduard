package pan.eduard.Practice1;

import jakarta.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import pan.eduard.Practice1.service.ServiceA;
import pan.eduard.Practice1.service.ServiceB;
import pan.eduard.Practice1.service.ServiceC;
import pan.eduard.Practice1.service.ServiceD;
import pan.eduard.Practice1.repository.RepoA;
import pan.eduard.Practice1.repository.RepoB;
import pan.eduard.Practice1.repository.RepoC;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class MyConfiguration {
    @Value("${value.from.application:default}:")
    private String value;
    @Bean    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
    @Bean
    public TransactionManager transactionManager() {
        return (TransactionManager) new DataSourceTransactionManager(getDataSource());
    }
    @Bean("serviceAFromConfiguration")
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA(new RepoA());
        return serviceA;
    }

    @Bean("serviceBFromConfiguration")
    public ServiceB getServiceB(){
        ServiceB serviceB = new ServiceB(new ServiceA(new RepoA()), new RepoB());
        return serviceB;
    }

    @Bean("serviceCFromConfiguration")
    public ServiceC getServiceC(){
        ServiceC serviceC = new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC());
        return serviceC;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD(new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC()));
        return serviceD;
    }

}
