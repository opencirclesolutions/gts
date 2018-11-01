package com.ocs.gts.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gwt.thirdparty.guava.common.collect.Sets;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.domain.model.EntityModelFactory;
import com.ocs.dynamo.filter.FilterConverter;
import com.ocs.dynamo.filter.InPredicate;
import com.ocs.dynamo.filter.LikePredicate;
import com.ocs.dynamo.filter.OrPredicate;
import com.ocs.dynamo.filter.PropertyPredicate;
import com.ocs.dynamo.filter.SimpleStringPredicate;
import com.ocs.dynamo.ui.Searchable;
import com.ocs.dynamo.ui.component.EntityComboBox;
import com.ocs.dynamo.ui.component.EntityComboBox.SelectMode;
import com.ocs.dynamo.ui.component.EntityListSelect;
import com.ocs.dynamo.ui.component.FancyListSelect;
import com.ocs.dynamo.ui.component.QuickAddEntityComboBox;
import com.ocs.dynamo.ui.component.QuickAddListSelect;
import com.ocs.dynamo.ui.component.TokenFieldSelect;
import com.ocs.dynamo.ui.composite.dialog.SimpleModalDialog;
import com.ocs.dynamo.ui.composite.form.ModelBasedSearchForm;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.container.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.data.provider.SortOrder;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.SerializablePredicate;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@UIScope
@SpringView(name = Views.ORGANIZATION_VIEW)
public class OrganizationView extends BaseView {

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private PersonService personService;

	@Autowired
	private EntityModelFactory factory;

	private static final long serialVersionUID = 3310122000037867336L;

	private Layout searchResultsLayout;

	private class MySearchable implements Searchable<Person> {

		@Override
		public void search(SerializablePredicate<Person> filter) {

			EntityModel<Person> model = factory.getModel(Person.class);
			FilterConverter<Person> converter = new FilterConverter<Person>(model);

			List<Person> persons = personService.fetch(converter.convert(filter));

			searchResultsLayout.removeAllComponents();
			TextArea area = new TextArea();
			area.setSizeFull();
			searchResultsLayout.addComponent(area);

			String value = persons.stream().map(p -> p.getFullName()).collect(Collectors.joining("\n"));
			area.setValue(value);
		}

	}

	@Override
	public void enter(ViewChangeEvent event) {
		Layout main = initLayout();

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
				QueryType.PAGING, new FormOptions(), null);
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

	}
}
