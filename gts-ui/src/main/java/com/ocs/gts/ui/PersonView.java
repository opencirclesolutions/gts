package com.ocs.gts.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.table.ModelBasedGrid;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Layout;

@UIScope
@SpringView(name = Views.PERSON_VIEW)
public class PersonView extends BaseView {

	private static final long serialVersionUID = 5368745165020200786L;

	@Autowired
	private PersonService personService;
	
	@Autowired
	private OrganizationService organizationService;

	@Override
	public void enter(ViewChangeEvent event) {
		Layout main = initLayout();

		List<Person> persons = personService.fetch(null);
		ListDataProvider<Person> provider = new ListDataProvider<>(persons);

		EntityModel<Person> model = getModelFactory().getModel(Person.class);
		ModelBasedGrid<Integer, Person> table = new ModelBasedGrid<>(provider, model, false);

		main.addComponent(table);
		
		List<Organization> organizations = organizationService.fetch(null);
		ListDataProvider<Organization> orgProvider = new ListDataProvider<>(organizations);

		EntityModel<Organization> oModel = getModelFactory().getModel(Organization.class);
		ModelBasedGrid<Integer, Organization> orgTable = new ModelBasedGrid<>(orgProvider, oModel, false);

		main.addComponent(orgTable);
	}
}
