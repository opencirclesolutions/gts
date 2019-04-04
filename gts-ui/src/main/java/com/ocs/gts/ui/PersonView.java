package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.ui.auth.Authorized;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.service.PersonService;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Layout;

@UIScope
@SpringView(name = Views.PERSON_VIEW)
@Authorized(roles = "bogus")
public class PersonView extends BaseView {

    private static final long serialVersionUID = 5368745165020200786L;

    @Autowired
    private PersonService personService;

    @Override
    public void enter(ViewChangeEvent event) {
        Layout main = initLayout();

    }
}
