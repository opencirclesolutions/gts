package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.container.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.service.GiftService;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Layout;

@UIScope
@SpringView(name = Views.GIFT_VIEW)
public class GiftView extends BaseView {

	@Autowired
	private GiftService giftService;

	private static final long serialVersionUID = 3310122000037867336L;

	@Override
	public void enter(ViewChangeEvent event) {
		Layout main = initLayout();

		EntityModel<Gift> em = getModelFactory().getModel(Gift.class);
		FormOptions fo = new FormOptions().setEditAllowed(true);
		ServiceBasedSplitLayout<Integer, Gift> layout = new ServiceBasedSplitLayout<Integer, Gift>(giftService, em,
				QueryType.ID_BASED, fo, null) {

			private static final long serialVersionUID = 636437555793563673L;

		};
		layout.setDetailJoins(new FetchJoinInformation[] { new FetchJoinInformation("logo") });

		main.addComponent(layout);
	}

}
