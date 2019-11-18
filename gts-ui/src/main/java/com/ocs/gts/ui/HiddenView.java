package com.ocs.gts.ui;

import java.util.ArrayList;

import org.vaadin.gatanaso.MultiselectComboBox;

import com.ocs.dynamo.ui.auth.Authorized;
import com.ocs.dynamo.ui.component.EntityTokenSelect;
import com.ocs.dynamo.ui.view.LazyBaseView;
import com.ocs.gts.domain.Organization;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = "hidden")
@Authorized(roles = { "hidden" })
public class HiddenView extends LazyBaseView {

    private static final long serialVersionUID = 8590097551894996830L;

    @Override
    protected Component build() {
        VerticalLayout layout = new VerticalLayout();
        layout.add(new MultiselectComboBox<>());
        layout.add(new EntityTokenSelect<Integer, Organization>(getModelFactory().getModel(Organization.class), null, new ArrayList<>()));
        return layout;
    }

}