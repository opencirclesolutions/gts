package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.AttributeModel;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.dynamo.service.BaseService;
import com.ocs.dynamo.service.MessageService;
import com.ocs.dynamo.ui.component.DefaultVerticalLayout;
import com.ocs.dynamo.ui.component.DetailsEditGrid;
import com.ocs.dynamo.ui.composite.layout.EditableGridLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.LazyBaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;

@UIScope
@SpringView(name = Views.ORGANIZATION_VIEW)
public class OrganizationView extends LazyBaseView {

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private PersonService personService;

	@Autowired
	private BaseService<Integer, Country> countryService;

	private static final long serialVersionUID = 3310122000037867336L;

	@Autowired
	private MessageService messageService;

	private SimpleSearchLayout<Integer, Organization> layout;

	@Override
	public Component build() {
		Layout main = new DefaultVerticalLayout();

		EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
		layout = new SimpleSearchLayout<Integer, Organization>(organizationService, em, QueryType.ID_BASED,
				new FormOptions().setOpenInViewMode(true).setShowRemoveButton(true), null) {

			private static final long serialVersionUID = 1718400289156392757L;

//			@Override
//			protected String[] getDetailModeTabCaptions() {
//				return new String[] { "Details", "Members" };
//			}
//
//			@Override
//			protected Component initTab(Organization entity, int index, FormOptions parentFormOptions,
//					boolean newEntity) {
//				if (index == 0) {
//					SimpleEditLayout<Integer, Organization> editLayout = new SimpleEditLayout<Integer, Organization>(
//							entity, organizationService, em, parentFormOptions) {
//
//						private static final long serialVersionUID = 119480415996212935L;
//
//						@Override
//						protected void afterEditDone(boolean cancel, boolean newEntity, Organization entity) {
//							if (cancel) {
//								layout.searchMode();
//							} else if (newEntity) {
//								detailsMode(entity);
//							}
//						}
//					};
//					return editLayout;
//				} else if (index == 1) {
//					// grid for editing members
//					FormOptions df = new FormOptions().setOpenInViewMode(false)
//							.setGridEditMode(GridEditMode.SIMULTANEOUS);
//					EditableGridDetailLayout<Integer, Person, Integer, Organization> layout = new EditableGridDetailLayout<Integer, Person, Integer, Organization>(
//							personService, entity, organizationService,
//							getModelFactory().getModel("PersonGrid", Person.class), df, null) {
//
//						private static final long serialVersionUID = 4438776368553060357L;
//
//						@Override
//						protected Person createEntity() {
//							Person person = super.createEntity();
//							person.setOrganization(getParentEntity());
//							return person;
//						};
//
//					};
//					layout.setParentFilterSupplier(parent -> new EqualsPredicate<>("organization", parent));
//					return layout;
//				}
//				return null;
//			}

//			@Override
//			protected Resource getIconForTab(int index) {
//				return null;
//			}

			@Override
			protected AbstractField<?> constructCustomField(EntityModel<Organization> entityModel,
					AttributeModel attributeModel, boolean viewMode, boolean searchMode) {
				if ("members".equals(attributeModel.getPath()) && !searchMode) {
					DetailsEditGrid<Integer, Person> pTable = new DetailsEditGrid<Integer, Person>(
							getModelFactory().getModel(Person.class), attributeModel, viewMode,
							new FormOptions().setDetailsGridSearchMode(true)) {

						private static final long serialVersionUID = 8191183827952564275L;

						@Override
						protected void removeEntity(Person toRemove) {
							layout.getSelectedItem().removeMember(toRemove);
						}

						@Override
						protected Person createEntity() {
							Person person = new Person();
							layout.getSelectedItem().addMember(person);
							return person;
						}
					};
					pTable.setService(personService);
					return pTable;
				}
				return null;
			}
		};
		layout.setPageLength(10);
		layout.setMaxResults(3);
		layout.setSearchValue("name", "Tr");
		main.addComponent(layout);

		return main;

	}
}
