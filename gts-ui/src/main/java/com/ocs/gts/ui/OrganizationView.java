package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.AndPredicate;
import com.ocs.dynamo.filter.LikePredicate;
import com.ocs.dynamo.filter.PropertyPredicate;
import com.ocs.dynamo.ui.component.EntityComboBox;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.service.OrganizationService;
import com.vaadin.data.provider.SortOrder;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Layout;

@UIScope
@SpringView(name = Views.ORGANIZATION_VIEW)
public class OrganizationView extends BaseView {

	@Autowired
	private OrganizationService organizationService;

	private static final long serialVersionUID = 3310122000037867336L;

	@Override
	public void enter(ViewChangeEvent event) {
		Layout main = initLayout();

//		FormOptions fo = new FormOptions();
//		SimpleSearchLayout<Integer, Organization> layout = new SimpleSearchLayout<>(organizationService, em,
//		        QueryType.ID_BASED, fo, null);
//		main.addComponent(layout);

		// PropertyPredicate<Organization> filter = new
		// EqualsPredicate<Organization>("name", "Coda Nostra");
		PropertyPredicate<Organization> like = new LikePredicate<Organization>("name", "%a%", false);

		EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
		EntityComboBox<Integer, Organization> combo = new EntityComboBox<>(em, null, organizationService, like,
				new SortOrder<String>("name", SortDirection.ASCENDING));
		main.addComponent(combo);

		EntityComboBox<Integer, Organization> fixed = new EntityComboBox<>(em, null, organizationService.findAll());
		main.addComponent(fixed);
	}
}
