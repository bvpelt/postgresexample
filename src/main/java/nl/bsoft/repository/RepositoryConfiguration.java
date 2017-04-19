package nl.bsoft.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by bvpelt on 4/15/17.
 */


@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"nl.bsoft.repository"})
@EnableJpaRepositories(basePackages = {"nl.bsoft.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
