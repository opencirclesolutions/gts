package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.EqualsPredicate;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedDetailLayout;
import com.ocs.dynamo.ui.composite.layout.SimpleEditLayout;
import com.ocs.dynamo.ui.composite.layout.TabLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Delivery;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.DeliveryService;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.ORGANIZATION_DETAIL_VIEW, layout = GtsUI.class)
@PageTitle("Organization Details")
public class OrganizationDetailView extends BaseView {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PersonService personService;

    @Autowired
    private DeliveryService deliveryService;

    private static final long serialVersionUID = 3310122000037867335L;

    public OrganizationDetailView() {
        super(true, false);
    }

    @Override
    protected void doInit(VerticalLayout main) {
        Organization org = getUiHelper().getSelectedEntity(Organization.class);

        TabLayout<Integer, Organization> tabLayout = new TabLayout<>(org);
        tabLayout.setTitleCreator(() -> "Look at my organization");
        tabLayout.setCaptions(new String[]{"Details", "Members", "Delivery"});

        tabLayout.setTabCreator(index -> {
            switch (index) {
                case 0:
                    EntityModel<Organization> em = getModelFactory().getModel(Organization.class);
                    FormOptions fo = new FormOptions().setOpenInViewMode(true).setShowEditButton(true);
                    return new SimpleEditLayout<>(org, organizationService, em, fo);
                case 1: {
                    ServiceBasedDetailLayout<Integer, Person, Integer, Organization> layout = new ServiceBasedDetailLayout<>(
                            personService, tabLayout.getEntity(), organizationService,
                            getModelFactory().getModel("OrganizationPerson", Person.class), QueryType.ID_BASED,
                            new FormOptions(), null);
                    layout.setCreateEntity(() -> {
                        Person person = new Person();
                        person.setOrganization(tabLayout.getEntity());
                        return person;
                    });
                    layout.setParentFilterCreator(
                            item -> new EqualsPredicate<>("organization", tabLayout.getEntity()));
                    return layout;
                }
                case 2: {
                    ServiceBasedDetailLayout<Integer, Delivery, Integer, Organization> layout = new ServiceBasedDetailLayout<>(
                            deliveryService, tabLayout.getEntity(), organizationService,
                            getModelFactory().getModel("OrganizationDelivery", Delivery.class), QueryType.ID_BASED,
                            new FormOptions(), null);
                    layout.setCreateEntity(Delivery::new);
                    layout.setParentFilterCreator(
                            item -> new EqualsPredicate<>("fromPerson.organization", tabLayout.getEntity()));
                    layout.addFieldFilter("fromPerson", new EqualsPredicate<>("organization", tabLayout.getEntity()));
                    return layout;
                }
            }
            return null;
        });
        tabLayout.setIconCreator(index -> VaadinIcon.ACADEMY_CAP.create());
        main.add(tabLayout);
    }

}
