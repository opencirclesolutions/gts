package com.ocs.gts.ui;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.LikePredicate;
import com.ocs.dynamo.service.UserDetailsService;
import com.ocs.dynamo.ui.auth.Authorized;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.composite.layout.SimpleSearchLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.PersonService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@UIScope
@Route(value = Views.PERSON_VIEW, layout = GtsUI.class)
@PageTitle("Members")
@Authorized(roles = "admin")
public class PersonView extends BaseView {

    private static final long serialVersionUID = 5368745165020200786L;

    @Autowired
    private PersonService personService;

    @Autowired
    private UserDetailsService userDetailsService;

    public PersonView() {
        super(true, false);
    }

    @Override
    protected void doInit(VerticalLayout main) {
        EntityModel<Person> em = getModelFactory().getModel(Person.class);
        FormOptions fo = new FormOptions().setShowSplitLayoutSearchButton(true).setOpenInViewMode(true);
        SimpleSearchLayout<Integer, Person> layout = new SimpleSearchLayout<>(personService,
                em, QueryType.ID_BASED, fo, null);
        //layout.setQuickSearchFilterCreator(text -> new LikePredicate<>("firstName", "%" + text + "%", false));
        layout.setPostProcessMainButtonBar(buttonBar -> {
            Button notificationButton = new Button("Show name");
            notificationButton.addClickListener(event -> {
                showErrorNotification(layout.getSelectedItem().getNickName());
            });
            buttonBar.add(notificationButton);
            layout.registerComponent("notificationButton", notificationButton);
        });
        layout.setMustEnableComponent((com, ent) -> {
            if (layout.isRegisteredComponent("notificationButton", com)) {
                return ent.getFirstName().startsWith("M");
            }
            return true;
        });
        layout.setEditAllowed(() -> userDetailsService.isUserInRole("super"));
        main.add(layout);
    }

}
