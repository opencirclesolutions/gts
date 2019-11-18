package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.AttributeModel;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.component.DetailsEditGrid;
import com.ocs.dynamo.ui.composite.form.ModelBasedEditForm;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.composite.type.AttributeGroupMode;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.domain.type.Reputation;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.ORGANIZATION_VIEW, layout = GtsUI.class)
@RouteAlias(value = "", layout = GtsUI.class)
public class OrganizationView extends BaseView {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PersonService personService;

    private static final long serialVersionUID = 3310122000037867336L;

    @Override
    public void doInit() {

        VerticalLayout main = initLayout();

        EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
        FormOptions fo = new FormOptions().setShowRemoveButton(true).setOpenInViewMode(true).setShowIterationButtons(true)
                .setAttributeGroupMode(AttributeGroupMode.PANEL).setPreserveSelectedTab(true);
        SimpleSearchLayout<Integer, Organization> layout = new SimpleSearchLayout<Integer, Organization>(organizationService, em,
                QueryType.ID_BASED, fo, null) {

            private static final long serialVersionUID = 2765294573620524937L;

            @Override
            protected void postProcessDetailButtonBar(FlexLayout buttonBar, boolean viewMode) {
                Button hideLabel = new Button("Show notification");
                hideLabel.addClickListener(event -> {
                    showErrorNotification("This is an error");
                    showTrayNotification("This is a tray notification");
                });
                buttonBar.add(hideLabel);
            }

            @Override
            protected void postProcessButtonBar(FlexLayout buttonBar) {
                Button navigateButton = new Button("To detail view");
                registerComponent(navigateButton);
                buttonBar.add(navigateButton);
                navigateButton.addClickListener(event -> {
                    getUiHelper().selectAndNavigate(getSelectedItem(), Views.ORGANIZATION_DETAIL_VIEW);
                });

                for (int i = 0; i < 10; i++) {
                    Button button = new Button("" + i);
                    buttonBar.add(button);
                }
            }

            @Override
            protected Component constructCustomField(EntityModel<Organization> entityModel, AttributeModel attributeModel, boolean viewMode,
                    boolean searchMode) {
                if ("members".equals(attributeModel.getName()) && !searchMode) {
                    FormOptions detailFO = new FormOptions();
                    // create the table - notice how we pass the "viewMode" parameter
                    DetailsEditGrid<Integer, Person> dt = new DetailsEditGrid<Integer, Person>(
                            getEntityModelFactory().getModel(Person.class), attributeModel, viewMode,
                            detailFO.setDetailsGridSearchMode(true));
                    dt.setService(personService);
                    dt.setLinkEntityConsumer(person -> {
                        getSelectedItem().addMember(person);
                    });
                    return dt;
                }
                return null;
            }

            @Override
            protected void postProcessEditFields(ModelBasedEditForm<Integer, Organization> editForm) {
                HasValue<?, Reputation> reputation = editForm.getFieldAsHasValue("reputation");
                HasValue<?, Integer> yearlyMortality = editForm.getFieldAsHasValue("yearlyMortalityRate");
                reputation.addValueChangeListener(event -> yearlyMortality.clear());
            }

//            @Override
//            protected String[] getParentGroupHeaders() {
//                return new String[] { "organization.left", "organization.right" };
//            }
//
//            @Override
//            protected String getParentGroup(String childGroup) {
//                if ("organization.first".equals(childGroup)) {
//                    return "organization.left";
//                }
//                return "organization.right";
//            }

        };
        layout.setGridHeight("600px");
        main.add(layout);

        if (getUiHelper().getSelectedEntity() != null) {
            Organization org = (Organization) getUiHelper().getSelectedEntity();
            layout.edit(organizationService.fetchById(org.getId()));
            getUiHelper().setSelectedEntity(null);
        }

    }

}
