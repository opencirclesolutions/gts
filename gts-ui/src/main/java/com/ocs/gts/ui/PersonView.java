package com.ocs.gts.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.LikePredicate;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.dynamo.service.BaseService;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.container.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.dynamo.ui.view.LazyBaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.SerializablePredicate;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;
import com.vaadin.v7.ui.VerticalLayout;

@UIScope
@SpringView(name = Views.PERSON_VIEW)
public class PersonView extends LazyBaseView {

	private static final long serialVersionUID = 5368745165020200786L;

	@Autowired
	private PersonService personService;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private BaseService<Integer, Country> countryService;

	@Override
	protected Component build() {
		Layout main = new com.vaadin.ui.VerticalLayout();

		EntityModel<Person> model = getModelFactory().getModel(Person.class);
		SimpleSearchLayout<Integer, Person> ssl = new SimpleSearchLayout<Integer, Person>(personService, model,
				QueryType.ID_BASED, new FormOptions().setShowSearchAnyButton(true).setEditAllowed(true), null) {

			private static final long serialVersionUID = 6383158350570359504L;

			@Override
			protected void postProcessLayout(Layout main) {
				super.postProcessLayout(main);
				// setSearchValue("firstName", "vin");
			}

		};

		// List<SerializablePredicate<Person>> defaultFilters = new ArrayList<>();
		// defaultFilters.add(new com.ocs.dynamo.filter.LikePredicate<>("firstName",
		// "%vin%", false));
		// ssl.setDefaultFilters(defaultFilters);

		Map<String, SerializablePredicate<?>> fieldFilters = new HashMap<>();
		//fieldFilters.put("organization", new LikePredicate<Organization>("name", "%am%", false));
		ssl.setFieldFilters(fieldFilters);

		main.addComponent(ssl);

//		List<Person> persons = personService.fetch(null);
//		ListDataProvider<Person> provider = new ListDataProvider<>(persons);
//		ModelBasedGrid<Integer, Person> table = new ModelBasedGrid<>(provider, model, false);
//		main.addComponent(table);

		// List<Organization> organizations = organizationService.fetch(null);
		// ListDataProvider<Organization> orgProvider = new
		// ListDataProvider<>(organizations);
		EntityModel<Organization> oModel = getModelFactory().getModel(Organization.class);

//		PagingDataProvider<Integer, Organization> pagingProvider = new PagingDataProvider<>(organizationService,
//				oModel);
//		ModelBasedGrid<Integer, Organization> orgTable = new ModelBasedGrid<>(pagingProvider, oModel, false);
//		orgTable.setCurrencySymbol("$");
//
//		main.addComponent(orgTable);
//
//		EntityModel<Country> cModel = getModelFactory().getModel(Country.class);
//		IdBasedDataProvider<Integer, Country> countryProvider = new IdBasedDataProvider<>(countryService, cModel);
//		ModelBasedGrid<Integer, Country> cTable = new ModelBasedGrid<>(countryProvider, cModel, false);
//		main.addComponent(cTable);
//
//		Button refresh = new Button("Refresh");
//		refresh.addClickListener(evt -> {
//			cTable.clearSortOrder();
//		});
//		main.addComponent(refresh);

		return main;
	}
}
