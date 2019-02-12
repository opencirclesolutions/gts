package com.ocs.gts.ui;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.dao.impl.DefaultDaoImpl;
import com.ocs.dynamo.domain.model.EntityModelFactory;
import com.ocs.dynamo.domain.model.FieldFactory;
import com.ocs.dynamo.domain.model.impl.EntityModelFactoryImpl;
import com.ocs.dynamo.domain.model.impl.FieldFactoryImpl;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.dynamo.functional.domain.QCountry;
import com.ocs.dynamo.functional.domain.QRegion;
import com.ocs.dynamo.functional.domain.Region;
import com.ocs.dynamo.service.BaseService;
import com.ocs.dynamo.service.MessageService;
import com.ocs.dynamo.service.UserDetailsService;
import com.ocs.dynamo.service.impl.DefaultServiceImpl;
import com.ocs.dynamo.service.impl.DefaultUserDetailsServiceImpl;
import com.ocs.dynamo.service.impl.MessageServiceImpl;
import com.ocs.dynamo.ui.auth.PermissionChecker;
import com.ocs.dynamo.ui.auth.ViewAccessControl;
import com.ocs.dynamo.ui.auth.impl.DefaultPermissionCheckerImpl;
import com.ocs.dynamo.ui.menu.MenuService;

/**
 * Spring Java configuration
 * 
 * @author Bas Rutten
 *
 */
@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan(basePackages = { "com.ocs.gts", "com.ocs.dynamo.functional", "com.ocs.dynamo.aop",
		"com.ocs.dynamo.ui.composite", "com.ocs.dynamo.dao.impl" })
@EnableTransactionManagement
public class ApplicationConfig {

	@Value("${gts.datasource.name}")
	private String dataSourceName;

	@Bean
	public DataSource dataSource() throws NamingException {
		return (DataSource) new JndiTemplate().lookup("java:jboss/datasources/gtsDS");
	}

	@Bean
	public HibernateJpaVendorAdapter vendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setGenerateDdl(false);
		adapter.setShowSql(false);
		return adapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager(DataSource dataSource, JpaVendorAdapter adapter) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("gts");
		emf.setPackagesToScan("com.ocs.gts.domain", "com.ocs.dynamo.functional.domain");
		emf.setJpaVendorAdapter(adapter);
		emf.setDataSource(dataSource);
		return emf;
	}

	@Bean
	public EntityModelFactory entityModelFactory() {
		return new EntityModelFactoryImpl();
	}

	@Bean
	public FieldFactory fieldFactory() {
		return new FieldFactoryImpl();
	}

	@Bean
	public MenuService menuService() {
		return new MenuService();
	}

	@Bean
	public MessageService messageService() {
		return new MessageServiceImpl();
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/META-INF/entitymodel", "classpath:/menu", "classpath:/ui.messages",
				"classpath:/ocscommon", "classpath:/ValidationMessages", "classpath:/blcommon");
		source.setDefaultEncoding("UTF-8");
		source.setFallbackToSystemLocale(false);
		return source;
	}

	@Bean
	public PermissionChecker permissionChecker() {
		return new DefaultPermissionCheckerImpl("com.ocs.gts");
	}

	@Bean
	public PropertyPlaceholderConfigurer placeHolderConfigurer() {
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
		configurer.setLocation(new ClassPathResource("application.properties"));
		configurer.setIgnoreResourceNotFound(false);
		return configurer;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new DefaultUserDetailsServiceImpl();
	}

	@Bean
	public ValidatorFactory validatorFactory() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Bean
	public ViewAccessControl viewAccessControl() {
		return new ViewAccessControl();
	}

	@Bean
	public BaseDao<Integer, Region> regionDao() {
		return new DefaultDaoImpl<>(QRegion.region, Region.class);
	}

	@Bean
	public BaseService<Integer, Region> regionService(BaseDao<Integer, Region> regionDao) {
		DefaultServiceImpl<Integer, Region> regionService = new DefaultServiceImpl<>(regionDao, "code");
		return regionService;
	}

	@Bean
	public BaseDao<Integer, Country> countryDao() {
		return new DefaultDaoImpl<>(QCountry.country, Country.class, "parent");
	}

	@Bean
	public BaseService<Integer, Country> countryService(BaseDao<Integer, Country> dao) {
		DefaultServiceImpl<Integer, Country> countryService = new DefaultServiceImpl<>(dao, "code");
		return countryService;
	}

}
