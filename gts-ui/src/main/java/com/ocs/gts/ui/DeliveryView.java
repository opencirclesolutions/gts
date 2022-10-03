package com.ocs.gts.ui;

import com.vaadin.flow.router.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.EditableGridLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.type.GridEditMode;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Delivery;
import com.ocs.gts.service.DeliveryService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.data.provider.SortOrder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.DELIVERY_VIEW, layout = GtsUI.class)
@PageTitle("Deliveries")
public class DeliveryView extends BaseView {

    @Autowired
    private DeliveryService deliveryService;

    private static final long serialVersionUID = 3310122000037867336L;

    @Override
    public void doInit(VerticalLayout main) {
        EntityModel<Delivery> em = getModelFactory().getModel(Delivery.class);
        FormOptions fo = new FormOptions().setShowRemoveButton(true);
        EditableGridLayout<Integer, Delivery> layout = new EditableGridLayout<>(deliveryService, em, fo, null);
        main.add(layout);
    }
}
