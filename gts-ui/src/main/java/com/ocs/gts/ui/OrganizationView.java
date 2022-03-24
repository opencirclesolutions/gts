package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.service.OrganizationService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
		FormOptions fo = new FormOptions().setShowRemoveButton(true);
		SimpleSearchLayout<Integer, Organization> layout = new SimpleSearchLayout<>(organizationService, em,
				QueryType.ID_BASED, fo, null);
		main.add(layout);
	}

}
