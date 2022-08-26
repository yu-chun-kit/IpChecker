package com.example.storeIp.configuration;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.storeIp.repository", bootstrapMode = BootstrapMode.DEFERRED)
@EnableTransactionManagement
@Profile({ "local", "dev", "prod" })
public class DatabaseConfig {
	@Bean
	public LocalSessionFactoryBean entityFactoryBean(final DataSource dataSource) {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.example.storeIp.model");

		return sessionFactory;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory,
			final DataSource dataSource) {
		final HibernateTransactionManager transactionManager = new HibernateTransactionManager();

		transactionManager.setSessionFactory(sessionFactory);
		transactionManager.setDataSource(dataSource);

		return transactionManager;
	}
}
