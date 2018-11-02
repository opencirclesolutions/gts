package com.ocs.gts.ui;

import java.util.Locale;

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

		System.out.println(messageService.getMessage("bob.ross", new Locale("nl")));

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
				QueryType.PAGING, new FormOptions().setEditAllowed(true), null);
		main.addComponent(layout);

//		FormOptions fo = new FormOptions();
//		SimpleSearchLayout<Integer, Organization> layout = new SimpleSearchLayout<>(organizationService, em,
//		        QueryType.ID_BASED, fo, null);
//		main.addComponent(layout);

		// PropertyPredicate<Organization> filter = new
		// EqualsPredicate<Organization>("name", "Coda Nostra");
//		PropertyPredicate<Organization> like = new SimpleStringPredicate<>("name", "Gar", false, false);
//		OrPredicate<Organization> or = new OrPredicate<>(new LikePredicate<Organization>("name", "%ca%", false),
//				new LikePredicate<>("name", "%co%", false));
//
//		EntityComboBox<Integer, Organization> combo = new EntityComboBox<>(em, null, organizationService, like,
//				new SortOrder<>("name", SortDirection.ASCENDING));
//		main.addComponent(combo);
//		// combo.setAdditionalFilter(new LikePredicate<>("name", "%cod%", false));
//
//		final InPredicate<Organization> organizationInPredicate = new InPredicate<>("name",
//				Arrays.asList("CamelCase Camorra", "Los Pollos Hermanos"));
//
//		EntityComboBox<Integer, Organization> combo2 = new EntityComboBox<>(em, null, organizationService,
//				organizationInPredicate, new SortOrder<>("name", SortDirection.ASCENDING));
//		main.addComponent(combo2);
//
//		EntityComboBox<Integer, Organization> fixed = new EntityComboBox<>(em, null, organizationService.findAll());
//		main.addComponent(fixed);
//
//		// filtered list select
//		EntityListSelect<Integer, Organization> listSelect = new EntityListSelect<>(em, null, organizationService, like,
//				new SortOrder<>("name", SortDirection.ASCENDING));
//		main.addComponent(listSelect);
//
//		PropertyPredicate<Person> likePerson = new LikePredicate<>("firstName", "%a%", false);
//
//		QuickAddEntityComboBox<Integer, Person> personQuickAdd = new QuickAddEntityComboBox<>(personModel, null,
//				personService, SelectMode.FILTERED, null, false, null);
//		main.addComponent(personQuickAdd);
//
//		Person person1 = personService.findById(1);
//		personQuickAdd.setValue(person1);
//		Person person2 = personService.findById(2);
//
//		Button button = new Button("Test");
//		button.addClickListener(evt -> {
//			Person person = personQuickAdd.getValue();
//			if (person != null) {
//				Notification.show(person.getFullName(), Notification.Type.ERROR_MESSAGE);
//			}
//		});
//		main.addComponent(button);
//
//		QuickAddListSelect<Integer, Person> personListSelect = new QuickAddListSelect<Integer, Person>(personModel,
//				null, personService, null, true, 5);
//		main.addComponent(personListSelect);
//		personListSelect.setValue(Sets.newHashSet(person1, person2));
//
//		TokenFieldSelect<Integer, Person> tokenField = new TokenFieldSelect<>(personModel, null, personService, null,
//				true);
//		main.addComponent(tokenField);
//		tokenField.setValue(Sets.newHashSet(person1, person2));
//
//		FancyListSelect<Integer, Organization> organizationFancyListSelect = new FancyListSelect<>(organizationService,
//				em, null, null, true);
//		main.addComponent(organizationFancyListSelect);
//
//		Button dialogButton = new Button("Popup please!");
//		final SimpleModalDialog dialog = new SimpleModalDialog(true) {
//
//			@Override
//			protected void doBuild(final Layout parent) {
//				final VerticalLayout layout = new VerticalLayout();
//				layout.addComponent(new Label("Guten Tag!"));
//				parent.addComponent(layout);
//			}
//
//			@Override
//			protected String getTitle() {
//				return "popup";
//			}
//
//		};
//
//		dialog.build();
//		dialog.setPosition(100, 100);
//		dialogButton.addClickListener(e -> getUI().addWindow(dialog));
//		main.addComponent(dialogButton);

		return main;

	}
}
