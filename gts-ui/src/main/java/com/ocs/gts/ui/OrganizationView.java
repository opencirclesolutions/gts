package com.ocs.gts.ui;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.EqualsPredicate;
import com.ocs.dynamo.filter.LikePredicate;
import com.ocs.dynamo.ui.composite.dialog.EntityPopupDialog;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedDetailLayout;
import com.ocs.dynamo.ui.composite.layout.SimpleEditLayout;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.composite.type.AttributeGroupMode;
import com.ocs.dynamo.ui.composite.type.ExportMode;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.provider.SortOrder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.ORGANIZATION_VIEW, layout = GtsUI.class)
@RouteAlias(value = "", layout = GtsUI.class)
@PageTitle("Organizations")
public class OrganizationView extends BaseView {

    public OrganizationView() {
        super(true);
    }

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PersonService personService;

    private static final long serialVersionUID = 3310122000037867336L;

    private SimpleSearchLayout<Integer, Organization> layout;

    @Override
    protected void doInit(VerticalLayout main) {

        EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
        FormOptions fo = new FormOptions().setPlaceButtonBarAtTop(true).setShowIterationButtons(true).setOpenInViewMode(true)
                .setAttributeGroupMode(AttributeGroupMode.TABSHEET).setConfirmSave(true).setExportMode(ExportMode.FULL)
                .setComplexDetailsMode(true).setPreserveSelectedTab(true);
        layout = new SimpleSearchLayout<Integer, Organization>(organizationService, em, QueryType.ID_BASED, fo,
                new SortOrder<String>("name", SortDirection.ASCENDING)) {

            private static final long serialVersionUID = 4639919925672194104L;

            protected void postProcessButtonBar(FlexLayout buttonBar) {
                Button popupButton = new Button("Popup");
                popupButton.addClickListener(event -> {
                    EntityPopupDialog<Integer, Organization> popupDialog = new EntityPopupDialog<Integer, Organization>(organizationService,
                            getSelectedItem(), getEntityModelFactory().getModel(Organization.class), new HashMap<>(), new FormOptions());
                    popupDialog.buildAndOpen();
                });
                buttonBar.add(popupButton);
                registerComponent(popupButton);
            }

            @Override
            protected String[] getDetailModeTabCaptions() {
                return new String[] { "Organization", "Members" };
            }

            @Override
            protected Component constructComplexDetailModeTab(int index, FormOptions fo, boolean newEntity) {
                if (index == 0) {
                    SimpleEditLayout<Integer, Organization> simpleLayout = new SimpleEditLayout<Integer, Organization>(new Organization(),
                            organizationService, getModelFactory().getModel(Organization.class),
                            new FormOptions().setHideCancelButton(true)) {

                        private static final long serialVersionUID = 119480415996212935L;

                        protected void afterEditDone(boolean cancel, boolean newEntity, Organization entity) {
                            if (!cancel && newEntity) {
                                entity = organizationService.fetchById(entity.getId());
                                setSelectedItem(entity);
                                detailsMode(entity);
                            }
                        }
                    };
                    return simpleLayout;
                } else if (index == 1) {
                    ServiceBasedDetailLayout<Integer, Person, Integer, Organization> detailLayout = new ServiceBasedDetailLayout<Integer, Person, Integer, Organization>(
                            personService, layout.getSelectedItem(), organizationService,
                            getModelFactory().getModel("PersonDetail", Person.class), QueryType.ID_BASED, new FormOptions(), null) {

                        private static final long serialVersionUID = -8126281855985088849L;

                        protected Person createEntity() {
                            Person person = super.createEntity();
                            layout.getSelectedItem().addMember(person);
                            return person;
                        }
                    };
                    detailLayout.setParentFilterSupplier(org -> new EqualsPredicate<>("organization", org));
                    return detailLayout;
                }
                return null;
            }

            @Override
            protected void afterTabSelected(int tabIndex) {
                showErrorNotification("Selected tab " + tabIndex);
            }

//            @Override
//            protected Component constructCustomField(EntityModel<Organization> entityModel, AttributeModel attributeModel, boolean viewMode,
//                    boolean searchMode) {
//                if ("organizationId".equals(attributeModel.getName())) {
//                    ServiceBasedDetailsEditGrid<Integer, Person, Integer, Organization> grid = new ServiceBasedDetailsEditGrid<>(
//                            personService, getModelFactory().getModel("PersonGrid", Person.class), attributeModel, viewMode,
//                            new FormOptions().setDetailsGridSearchMode(false).setShowRemoveButton(false));
//                    grid.setGridHeight("500px");
//                    grid.setFilterSupplier(org -> new EqualsPredicate<>("organization.id", org.getId()));
//                    grid.setCreateEntitySupplier(() -> {
//                        Person person = new Person();
//                        person.setOrganization(getSelectedItem());
//                        return person;
//                    });
//                    grid.setRemoveEntityConsumer(person -> {
//                        person.setOrganization(null);
//                        personService.save(person);
//                    });
//
//                    return grid;
//                }
//                return null;
//            }

        };
        layout.addFieldFilter("countryOfOrigin", new LikePredicate<String>("name", "%au%", false));
        layout.addFieldEntityModel("countryOfOrigin", "SearchCountry");
        layout.addSortOrder(new SortOrder<String>("address", SortDirection.ASCENDING));
        layout.setExportJoins(new FetchJoinInformation("members"), new FetchJoinInformation("countryOfOrigin"));

        main.add(layout);

        if (getUiHelper().getSelectedEntity() instanceof Organization) {
            Organization org = (Organization) getUiHelper().getSelectedEntity();
            org = organizationService.fetchById(org.getId());
            layout.edit(org);
        }
    }

    @Override
    protected boolean isEditing() {
        return layout.isEditing();
    }

}
