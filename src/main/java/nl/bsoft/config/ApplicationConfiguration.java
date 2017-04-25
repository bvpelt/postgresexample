package nl.bsoft.config;

/**
 * Created by bvpelt on 4/19/17.
 */
public class ApplicationConfiguration {
// See http://docs.spring.io/spring-data/jpa/docs/1.3.4.RELEASE/reference/html/jpa.repositories.html
// http://stackoverflow.com/questions/28821521/configure-datasource-programmatically-in-spring-boot

    /*

    Not currently in use

    @ConfigurationProperties(prefix = "datasource.postgres")
    @Bean
    @Primary
    public DataSource dataSource() {

        return DataSourceBuilder
                .create()
                .username("bvpelt")
                .password("brtvnplt")
                .url("jdbc:postgresql://localhost/fun")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("nl.bsoft.repository");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
    */
}
