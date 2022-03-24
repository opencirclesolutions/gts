package com.ocs.gts.ui;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.ocs.dynamo.configuration.ApplicationConfigurationSupport;
import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.dao.impl.DefaultDaoImpl;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.dynamo.functional.domain.QCountry;
import com.ocs.dynamo.functional.domain.QRegion;
import com.ocs.dynamo.functional.domain.Region;
import com.ocs.dynamo.service.BaseService;
import com.ocs.dynamo.service.impl.DefaultServiceImpl;
import com.ocs.dynamo.ui.UIHelper;
import com.ocs.gts.domain.MainActivity;
import com.ocs.gts.domain.QMainActivity;
import com.vaadin.flow.spring.annotation.UIScope;

/**
 * Spring Boot Java configuration
 * 
 * @author Bas Rutten
 *
 */
@ComponentScan(basePackages = { "com.ocs.gts", "com.ocs.dynamo", " com.ocs.dynamo.envers.domain" })
@EntityScan(basePackages = { "com.ocs.gts.domain", "com.ocs.dynamo.functional.domain", "com.ocs.dynamo.envers.domain" })
public class ApplicationConfig extends ApplicationConfigurationSupport {

	@Override
	protected String[] getBaseNames() {
		return new String[] { "classpath:/META-INF/entitymodel", "classpath:/menu", "classpath:/ui.messages",
				"classpath:/ocscommon", "classpath:/ValidationMessages" };
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

	@Bean
	public BaseDao<Integer, MainActivity> mainActivityDao() {
		return new DefaultDaoImpl<>(QMainActivity.mainActivity, MainActivity.class);
	}

	@Bean
	public BaseService<Integer, MainActivity> mainActivityService(BaseDao<Integer, MainActivity> dao) {
		return new DefaultServiceImpl<>(dao, "name");
	}

	@Bean
	@UIScope
	public UIHelper uiHelper() {
		return new UIHelper();
	}
}
