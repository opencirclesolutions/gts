package com.ocs.gts.ui;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.dynamo.service.BaseService;
import com.ocs.dynamo.ui.composite.dialog.EntityPopupDialog;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.TabularEditLayout;
import com.ocs.dynamo.ui.view.LazyBaseView;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

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
		TabularEditLayout<Integer, Person> ssl = new TabularEditLayout<Integer, Person>(personService, model,
				new FormOptions().setShowSearchAnyButton(true).setOpenInViewMode(true).setEditAllowed(true), null) {

			private static final long serialVersionUID = 6383158350570359504L;

			@Override
			protected void postProcessLayout(Layout main) {
				super.postProcessLayout(main);
				// setSearchValue("firstName", "vin");
			}

			@Override
			protected void postProcessButtonBar(Layout buttonBar) {
				Button popup = new Button("Popup");
				popup.addClickListener(event -> {
					EntityPopupDialog<Integer, Person> pop = new EntityPopupDialog<>(personService, getSelectedItem(),
							model, new FormOptions());
					pop.build();
					UI.getCurrent().addWindow(pop);
				});
				registerButton(popup);
				buttonBar.addComponent(popup);
			}
		};

		// ssl.addFieldEntityModel("organization", "ModifiedOrganization");
		//ssl.setMaxResults(10);
		ssl.setDividerProperty("organization");
		ssl.setSortEnabled(false);
		ssl.getGridWrapper().getLayout().setHeight(200, Unit.PIXELS);

		//ssl.getGridWrapper().setHeight(100, Unit.PIXELS);
		main.addComponent(ssl);

		return main;
	}
}
