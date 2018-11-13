package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.service.MessageService;
import com.ocs.dynamo.ui.component.DefaultVerticalLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.container.QueryType;
import com.ocs.dynamo.ui.view.LazyBaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;

@UIScope
@SpringView(name = Views.ORGANIZATION_VIEW)
public class OrganizationView extends LazyBaseView {

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private PersonService personService;

	private static final long serialVersionUID = 3310122000037867336L;

	private Layout searchResultsLayout;

	@Autowired
	private MessageService messageService;

	@Override
	public Component build() {
		Layout main = new DefaultVerticalLayout();

//		EntityModel<Person> personModel = getModelFactory().getModel(Person.class);
//		Searchable<Person> mySearchable = new MySearchable();
//
//		ModelBasedSearchForm<Integer, Person> personForm = new ModelBasedSearchForm<Integer, Person>(mySearchable,
//				personModel, new FormOptions());
//		main.addComponent(personForm);
//
//		searchResultsLayout = new VerticalLayout();
//		main.addComponent(searchResultsLayout);

		EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
		SimpleSearchLayout<Integer, Organization> layout = new SimpleSearchLayout<>(organizationService, em,
				QueryType.ID_BASED, new FormOptions().setOpenInViewMode(true).setEditAllowed(true), null);
		main.addComponent(layout);

		return main;

	}
}
