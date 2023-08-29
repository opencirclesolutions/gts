package com.ocs.gts.ui;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.type.Reputation;
import com.ocs.gts.service.OrganizationService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.validator.AbstractValidator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.ORGANIZATION_VIEW, layout = GtsUI.class)
@RouteAlias(value = "", layout = GtsUI.class)
@PageTitle("Organizations")
public class OrganizationView extends BaseView {

    @Autowired
    private OrganizationService organizationService;

    private static final long serialVersionUID = 3310122000037867336L;

    @Override
    protected void doInit(VerticalLayout main) {
        EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
        FormOptions fo = new FormOptions().setShowRemoveButton(true).setEnableAdvancedSearchMode(true);
        SimpleSearchLayout<Integer, Organization> layout = new SimpleSearchLayout<>(organizationService, em,
                                                                                    QueryType.ID_BASED, fo, null, 
                                                                                    new FetchJoinInformation("countryOfOrigin"), 
                                                                                    new FetchJoinInformation("mainActivity"));
//        layout.addCustomField("address", context -> {
//            ComboBox<String> cb = new ComboBox<>(
//                    context.getAttributeModel().getDisplayName(VaadinUtils.getLocale())
//            );
//            ListDataProvider<String> dataProvider = new ListDataProvider<>(
//                    List.of("1234 Palomita Boulevard", "5678 Horseshoe Road")
//            );
//            cb.setItems(dataProvider);
//            cb.setRequiredIndicatorVisible(true);
//            return cb;
//        });
        layout.setCreateEntity(() -> {
            Organization org = new Organization();
            org.setName("Cozy Nostra");
            return org;
        });
//        layout.setPostProcessEditFields(editForm -> {
//            ComboBox<Reputation> reputation = editForm.getField("reputation", ComboBox.class);
//            TextArea yearlyMortality = editForm.getField("yearlyMortalityRate", TextArea.class);
//            reputation.addValueChangeListener(event -> yearlyMortality.clear());
//        });

        layout.setPostProcessMainButtonBar(buttonBar -> {
            Button navigateButton = new Button("Navigate");
            navigateButton.addClickListener(event -> {
                getUiHelper().setSelectedEntity(layout.getSelectedItem());
                getUiHelper().navigate(Views.ORGANIZATION_DETAIL_VIEW);
            });
            buttonBar.add(navigateButton);
            layout.registerComponent(navigateButton);
        });
        
        
        layout.addCustomValidator("address", provider -> new AbstractValidator<String>("Oops") {

			@Override
			public ValidationResult apply(String value, ValueContext context) {
				Organization org = provider.getSelectedItem();
				System.out.println("Evaluating, name= " + org.getName() +  " address=" + value);
				if (org.getName() != null && org.getName().length() > 5) {
					if (value == null || value.length() < 10) {
						return ValidationResult.error("Oops");
					}
				}
				return ValidationResult.ok();
			}
		});
        
        layout.addCustomRequiredValidator("yearlyMortalityRate", provider -> new AbstractValidator<String>("Oops") {

			@Override
			public ValidationResult apply(String value, ValueContext context) {
				Organization org = provider.getSelectedItem();
				System.out.println("Evaluating, name= " + org.getName() +  " mortality=" + value);
				if (org.getName() != null && org.getName().startsWith("A") && StringUtils.isEmpty(value)) {
					return ValidationResult.error("Mortality rate must be filled");
				}
				return ValidationResult.ok();
			}
		});
        
        
        main.add(layout);

        if (getUiHelper().getSelectedEntity() != null) {
            Organization org = (Organization) getUiHelper().getSelectedEntity();
            layout.edit(organizationService.fetchById(org.getId()));
            getUiHelper().setSelectedEntity(null);
        }

    }

}
