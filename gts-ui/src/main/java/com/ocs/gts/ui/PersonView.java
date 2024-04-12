package com.ocs.gts.ui;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.gts.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.PersonService;
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
        super(true, false);
    }

    @Override
    protected void doInit(VerticalLayout main) {
        EntityModel<Person> em = getModelFactory().getModel(Person.class);
        FormOptions fo = new FormOptions();
        ServiceBasedSplitLayout<Integer, Person> layout = new ServiceBasedSplitLayout<>(personService, em,
                QueryType.ID_BASED, fo, null);
        main.add(layout);
    }

}
