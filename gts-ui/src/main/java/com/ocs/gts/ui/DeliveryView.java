package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.service.DeliveryService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.DELIVERY_VIEW, layout = GtsUI.class)
public class DeliveryView extends BaseView {

    @Autowired
    private DeliveryService deliveryService;

    private static final long serialVersionUID = 3310122000037867336L;

    @Override
    public void doInit() {
        VerticalLayout main = initLayout();

    }
}
