package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.service.GiftService;
import com.ocs.gts.ui.layout.GiftLayout;
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
    public void doInit() {
        VerticalLayout main = initLayout();

        // add your code here;
        EntityModel<Gift> em = getModelFactory().getModel(Gift.class);
        FormOptions fo = new FormOptions().setShowRemoveButton(true);
        GiftLayout layout = new GiftLayout(giftService, em, fo, null);
        layout.setDetailJoins(new FetchJoinInformation[] { new FetchJoinInformation("logo"), new FetchJoinInformation("translations") });
        main.add(layout);
    }

}
