package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.configuration.YamlPropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("hu.a_k.akademia.webfejlesztes.springboot.repository")
@PropertySource(value = "classpath:application.yaml", factory = YamlPropertySourceFactory.class)
@EnableTransactionManagement
public class ApplicationConfiguration {

    @Bean(name = "dataSource")
    public DataSource getDataSource(@Value("${factory.database.url}") final String url,
                                    @Value("${factory.database.password}") final String password,
                                    @Value("${factory.database.driver}") final String driver,
                                    @Value("${factory.database.username}") final String username) {
        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setDriverClassName(driver);
        return driverManagerDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dataSourceInitializer")
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("/db/initial.sql")));
        return dataSourceInitializer;
    }


    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(final DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean("simpleJdbcInsertCar")
    public SimpleJdbcInsert simpleJdbcInsertCar(final DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource)
                .withSchemaName("factory")
                .withTableName("car")
                .usingGeneratedKeyColumns("registration_id");
    }


}

