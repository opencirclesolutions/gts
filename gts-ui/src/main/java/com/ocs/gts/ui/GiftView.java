package com.ocs.gts.ui;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.AttributeModel;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.LikePredicate;
import com.ocs.dynamo.ui.composite.form.DetailsEditTable;
import com.ocs.dynamo.ui.composite.layout.BaseSplitLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.container.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.domain.GiftTranslation;
import com.ocs.gts.service.GiftService;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.SerializablePredicate;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Layout;

@UIScope
@SpringView(name = Views.GIFT_VIEW)
public class GiftView extends BaseView {

	@Autowired
	private GiftService giftService;

	private ServiceBasedSplitLayout<Integer, Gift> giftLayout;

	private static final long serialVersionUID = 3310122000037867336L;

	@Override
	public void enter(ViewChangeEvent event) {
		Layout main = initLayout();

		EntityModel<Gift> giftModel = getModelFactory().getModel(Gift.class);
		giftLayout = new ServiceBasedSplitLayout<Integer, Gift>(giftService, giftModel, QueryType.ID_BASED,
				new FormOptions().setOpenInViewMode(true).setEditAllowed(true).setShowQuickSearchField(true)
						.setShowRemoveButton(true),
				null) {

			private static final long serialVersionUID = -520100397841720139L;

			protected SerializablePredicate<Gift> constructFilter() {
				return new LikePredicate<Gift>("name", "%a%", false);
			}

			@Override
			protected AbstractField<?> constructCustomField(EntityModel<Gift> entityModel,
					AttributeModel attributeModel, boolean viewMode, boolean searchMode) {
				if ("translations".equals(attributeModel.getPath())) {
					DetailsEditTable<Integer, GiftTranslation> table = new DetailsEditTable<Integer, GiftTranslation>(
							getSelectedItem().getTranslations(), getModelFactory().getModel(GiftTranslation.class),
							viewMode, new FormOptions()) {

						private static final long serialVersionUID = 7328970228276713442L;

						@Override
						protected GiftTranslation createEntity() {
							GiftTranslation gt = new GiftTranslation();
							giftLayout.getSelectedItem().addTranslation(gt);
							return gt;
						}

						@Override
						protected void removeEntity(GiftTranslation toRemove) {
							// TODO Auto-generated method stub

						}

					};
					return table;
				}
				return null;
			}
		};
		giftLayout.setDetailJoins(new FetchJoinInformation[] { new FetchJoinInformation("logo"),
				new FetchJoinInformation("translations") });
		giftLayout.setSortEnabled(false);

		main.addComponent(giftLayout);
	}

}
