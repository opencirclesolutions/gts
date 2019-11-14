package com.ocs.gts.ui;

import com.ocs.dynamo.constants.DynamoConstants;
import com.ocs.dynamo.ui.component.DefaultVerticalLayout;
import com.ocs.dynamo.ui.view.BaseView;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

/**
 * A view that is displayed when the user navigates to a non-existing view or a
 * view for which the user is not authorized
 * 
 * @author bas.rutten
 */
@UIScope
@Route(value = DynamoConstants.ERROR_VIEW, layout = GtsUI.class)
public class GtsErrorView extends BaseView {

    private static final long serialVersionUID = 3955677765990706688L;

    @Override
    public void doInit() {
        VerticalLayout main = new DefaultVerticalLayout(true, true);

        VerticalLayout inside = new DefaultVerticalLayout(true, true);
        main.add(inside);

        Label errorLabel = new Label(message("ocs.view.unknown"));
        inside.add(errorLabel);

        add(main);
    }

}
