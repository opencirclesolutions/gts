package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.composite.type.ScreenMode;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Person;
import com.ocs.gts.service.PersonService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
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

    @Override
    public void doInit() {
        VerticalLayout main = initLayout();

        EntityModel<Person> entityModel = getModelFactory().getModel(Person.class);
        FormOptions fo = new FormOptions().setScreenMode(ScreenMode.HORIZONTAL).setOpenInViewMode(true).setShowQuickSearchField(true);
        ServiceBasedSplitLayout<Integer, Person> layout = new ServiceBasedSplitLayout<Integer, Person>(personService, entityModel,
                QueryType.ID_BASED, fo, null) {

            private static final long serialVersionUID = 5299092888799253171L;

            @Override
            protected void postProcessButtonBar(FlexLayout buttonBar) {
                Button notificationButton = new Button("Show name");
                notificationButton.addClickListener(event -> {
                    showErrorNotification(getSelectedItem().getNickName());
                });
                buttonBar.add(notificationButton);
                registerComponent(notificationButton);

                for (int i = 0; i < 10; i++) {
                    Button button = new Button("" + i);
                    buttonBar.add(button);
                }
            }

        };

        main.add(layout);
    }
}
