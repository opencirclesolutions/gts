package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.service.GiftService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.GIFT_VIEW, layout = GtsUI.class)
public class GiftView extends BaseView {

    @Autowired
    private GiftService giftService;

    private static final long serialVersionUID = 3310122000037867336L;

    @Override
    protected void doInit(VerticalLayout main) {

    }

}
