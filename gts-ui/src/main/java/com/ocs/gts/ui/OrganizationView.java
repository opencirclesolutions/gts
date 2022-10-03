package com.ocs.gts.ui;

import com.google.common.collect.Lists;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.FlexibleSearchLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.utils.VaadinUtils;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.type.Reputation;
import com.ocs.gts.service.OrganizationService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

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
        FormOptions fo = new FormOptions().setShowRemoveButton(true);
        SimpleSearchLayout<Integer, Organization> layout = new SimpleSearchLayout<>(organizationService, em,
                QueryType.ID_BASED, fo, null);
        layout.addCustomField("address", context -> {
            ComboBox<String> cb = new ComboBox<>(
                    context.getAttributeModel().getDisplayName(VaadinUtils.getLocale())
            );
            ListDataProvider<String> dataProvider = new ListDataProvider<>(
                    Lists.newArrayList("1234 Palomita Boulevard", "5678 Horseshoe Road")
            );
            cb.setDataProvider(dataProvider);
            cb.setRequiredIndicatorVisible(true);
            return cb;
        });
        layout.setCreateEntity(() -> {
            Organization org = new Organization();
            org.setName("Cozy Nostra");
            return org;
        });
        layout.setPostProcessEditFields(editForm -> {
            ComboBox<Reputation> reputation = editForm.getField("reputation", ComboBox.class);
            TextArea yearlyMortality = editForm.getField("yearlyMortalityRate", TextArea.class);
            reputation.addValueChangeListener(event -> yearlyMortality.clear());
        });

        layout.setPostProcessMainButtonBar(buttonBar -> {
            Button navigateButton = new Button("Navigate");
            navigateButton.addClickListener(event -> {
                getUiHelper().setSelectedEntity(layout.getSelectedItem());
                getUiHelper().navigate(Views.ORGANIZATION_DETAIL_VIEW);
            });
            buttonBar.add(navigateButton);
            layout.registerComponent(navigateButton);
        });
        main.add(layout);

        if (getUiHelper().getSelectedEntity() != null) {
            Organization org = (Organization) getUiHelper().getSelectedEntity();
            layout.edit(organizationService.fetchById(org.getId()));
            getUiHelper().setSelectedEntity(null);
        }

    }

}
