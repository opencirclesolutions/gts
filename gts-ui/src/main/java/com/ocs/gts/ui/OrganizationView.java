package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.envers.domain.RevisionKey;
import com.ocs.dynamo.envers.ui.ViewRevisionDialog;
import com.ocs.dynamo.ui.composite.layout.FlexibleSearchLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.composite.type.AttributeGroupMode;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.aud.VersionedOrganization;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.VersionedOrganizationService;
import com.vaadin.flow.component.button.Button;
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

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private VersionedOrganizationService versionService;

	private static final long serialVersionUID = 3310122000037867336L;

	@Override
	protected void doInit(VerticalLayout main) {
		EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
		FormOptions fo = new FormOptions().setShowRemoveButton(true);
		FlexibleSearchLayout<Integer, Organization> layout = new FlexibleSearchLayout<>(organizationService, em,
				QueryType.ID_BASED, fo, null);

		layout.addSortOrder(new SortOrder<>("headQuarters", SortDirection.ASCENDING));
		layout.addSortOrder(new SortOrder<>("name", SortDirection.ASCENDING));

		layout.setPostProcessMainButtonBar(buttonBar -> {
			Button revisionButton = new Button("Revision");
			revisionButton.addClickListener(event -> {

				ViewRevisionDialog<Integer, Organization, VersionedOrganization> dialog = new ViewRevisionDialog<>(
						versionService, getModelFactory().getModel(VersionedOrganization.class),
						new FormOptions().setAttributeGroupMode(AttributeGroupMode.TABSHEET),
						layout.getSelectedItem().getId());
				dialog.buildAndOpen();
			});
			layout.registerComponent(revisionButton);
			buttonBar.add(revisionButton);
		});

		main.add(layout);

		SimpleSearchLayout<RevisionKey<Integer>, VersionedOrganization> versLayout = new SimpleSearchLayout<>(
				versionService, getModelFactory().getModel(VersionedOrganization.class), QueryType.ID_BASED,
				new FormOptions().setReadOnly(true), null);
		main.add(versLayout);

//		Accordion acc = new Accordion();
//		AccordionPanel panel = new AccordionPanel();
//		acc.add(panel);
//		panel.setSummaryText("Menu1");
//
//		Accordion subAcc = new Accordion();
//		AccordionPanel sub1 = new AccordionPanel();
//
//		Button button = new Button("Menu11");
//		button.addClickListener(event -> helper.navigate("personView"));
//
//		sub1.setSummary(button);
//		subAcc.add(sub1);
//
//		AccordionPanel sub2 = new AccordionPanel();
//		sub2.setSummaryText("Menu12");
//		subAcc.add(sub2);
//
//		panel.setContent(subAcc);
//
//		AccordionPanel panel2 = new AccordionPanel();
//
//		acc.add(panel2);
//		panel2.setSummaryText("Panel2");
//
//		VerticalLayout vert = new VerticalLayout();
//		vert.add(new Text("Bob"));
//		panel2.setContent(vert);
//
//		main.add(acc);
	}

}
