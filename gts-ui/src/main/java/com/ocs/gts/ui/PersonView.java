package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.AttributeModel;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.EqualsPredicate;
import com.ocs.dynamo.ui.component.ServiceBasedDetailsEditGrid;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.composite.type.ScreenMode;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.PersonService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.PERSON_VIEW, layout = GtsUI.class)
@PageTitle("Members")
public class PersonView extends BaseView {

    private static final long serialVersionUID = 5368745165020200786L;

    @Autowired
    private PersonService personService;

    private ServiceBasedSplitLayout<Integer, Person> layout;

    public PersonView() {
        super(true);
    }

    @Override
    protected void doInit(VerticalLayout main) {

        EntityModel<Person> entityModel = getModelFactory().getModel(Person.class);
        FormOptions fo = new FormOptions().setScreenMode(ScreenMode.HORIZONTAL).setOpenInViewMode(true).setShowQuickSearchField(true);
        layout = new ServiceBasedSplitLayout<Integer, Person>(personService, entityModel, QueryType.ID_BASED, fo, null) {

            private static final long serialVersionUID = -2456133540305599906L;

        };
        main.add(layout);
    }

    @Override
    protected boolean isEditing() {
        return layout.isEditing();
    }
}
