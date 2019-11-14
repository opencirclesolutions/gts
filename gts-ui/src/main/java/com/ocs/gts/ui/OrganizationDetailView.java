package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.filter.EqualsPredicate;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.LazyTabLayout;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedDetailLayout;
import com.ocs.dynamo.ui.composite.layout.SimpleEditLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.OrganizationService;
import com.ocs.gts.service.PersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.ORGANIZATION_DETAIL_VIEW, layout = GtsUI.class)
public class OrganizationDetailView extends BaseView {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private PersonService personService;

    private static final long serialVersionUID = -4584198152680140250L;

    @Override
    protected void doInit() {
        VerticalLayout main = initLayout();

        main.add(new Text("Dit is een test"));

        if (getUiHelper().getSelectedEntity() instanceof Organization) {
            Organization org = (Organization) getUiHelper().getSelectedEntity();
            getUiHelper().setSelectedEntity(null);
            LazyTabLayout<Integer, Organization> tabs = new LazyTabLayout<Integer, Organization>(org) {

                private static final long serialVersionUID = 6396798113685074797L;

                @Override
                protected Component initTab(int index) {
                    if (index == 0) {
                        FormOptions fo = new FormOptions().setOpenInViewMode(true).setEditAllowed(true);
                        SimpleEditLayout<Integer, Organization> layout = new SimpleEditLayout<Integer, Organization>(getEntity(),
                                organizationService, getEntityModelFactory().getModel(Organization.class), fo);
                        return layout;
                    } else {
                        ServiceBasedDetailLayout<Integer, Person, Integer, Organization> layout = new ServiceBasedDetailLayout<Integer, Person, Integer, Organization>(
                                personService, getEntity(), organizationService,
                                getEntityModelFactory().getModel("OrganizationPerson", Person.class), QueryType.ID_BASED, new FormOptions(),
                                null) {

                            private static final long serialVersionUID = -2898632662487449765L;

                            protected Person createEntity() {
                                Person p = super.createEntity();
                                p.setOrganization(getEntity());
                                return p;
                            };
                        };
                        layout.setParentFilterSupplier(item -> new EqualsPredicate<Person>("organization", getEntity()));
                        return layout;

                    }
                }

                @Override
                protected String[] getTabCaptions() {
                    return new String[] { "Organization Details", "Members" };
                }

                @Override
                protected Icon getIconForTab(int index) {
                    return VaadinIcon.ACADEMY_CAP.create();
                }

                @Override
                protected String createTitle() {
                    return "Organization Details";
                }
            };
            add(tabs);
        }
    }
}
