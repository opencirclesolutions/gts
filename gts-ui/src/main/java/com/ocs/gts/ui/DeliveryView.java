package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.EditableGridLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.type.GridEditMode;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Delivery;
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

        EntityModel<Delivery> model = getModelFactory().getModel(Delivery.class);
        FormOptions fo = new FormOptions().setGridEditMode(GridEditMode.SINGLE_ROW).setShowRemoveButton(true).setOpenInViewMode(true);
        EditableGridLayout<Integer, Delivery> layout = new EditableGridLayout<>(deliveryService, model, fo, null);

        main.add(layout);
    }
}
