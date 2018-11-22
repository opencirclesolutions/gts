package com.ocs.gts.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.AttributeModel;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.filter.LikePredicate;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.dynamo.functional.domain.Domain;
import com.ocs.dynamo.functional.ui.MultiDomainEditLayout;
import com.ocs.dynamo.ui.composite.form.DetailsEditLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.domain.GiftTranslation;
import com.ocs.gts.domain.Role;
import com.ocs.gts.service.GiftService;
import com.ocs.gts.service.GiftTranslationService;
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

	@Autowired
	private GiftTranslationService giftTranslationService;

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
//					DetailsEditGrid<Integer, GiftTranslation> table = new DetailsEditGrid<Integer, GiftTranslation>(
//							getModelFactory().getModel(GiftTranslation.class), attributeModel, viewMode,
//							new FormOptions().setShowRemoveButton(true)) {
//
//						private static final long serialVersionUID = 7328970228276713442L;
//
//						@Override
//						protected GiftTranslation createEntity() {
//							GiftTranslation gt = new GiftTranslation();
//							giftLayout.getSelectedItem().addTranslation(gt);
//							return gt;
//						}
//
//						@Override
//						protected void removeEntity(GiftTranslation toRemove) {
//							giftLayout.getSelectedItem().removeTranslation(toRemove);
//						}
//
//						protected AbstractComponent constructCustomField(
//								com.ocs.dynamo.domain.model.EntityModel<GiftTranslation> entityModel,
//								AttributeModel attributeModel, boolean viewMode) {
////							if ("relevance".equals(attributeModel.getPath())) {
////								return new Slider();
////							}
//							return null;
//						};
//
//						protected void postProcessButtonBar(Layout buttonBar) {
//							Button viewButton = new Button("View");
//							viewButton.addClickListener(event -> Notification.show(getSelectedItem().getDescription()));
//							buttonBar.addComponent(viewButton);
//							registerButton(viewButton);
//						}
//
//					};
//					return table;

					DetailsEditLayout<Integer, GiftTranslation> layout = new DetailsEditLayout<Integer, GiftTranslation>(
							giftTranslationService, new ArrayList<>(),
							getEntityModelFactory().getModel(GiftTranslation.class), attributeModel, viewMode,
							new FormOptions(), null) {

						private static final long serialVersionUID = -5443255747775168653L;

						@Override
						protected void removeEntity(GiftTranslation toRemove) {
							giftLayout.getSelectedItem().removeTranslation(toRemove);
						}

						@Override
						protected GiftTranslation createEntity() {
							GiftTranslation gt = new GiftTranslation();
							giftLayout.getSelectedItem().addTranslation(gt);
							return gt;
						}

					};
					return layout;
				}
				return null;
			}
		};
		giftLayout.setDetailJoins(new FetchJoinInformation[] { new FetchJoinInformation("logo"),
				new FetchJoinInformation("translations") });
		giftLayout.setSortEnabled(false);
		main.addComponent(giftLayout);

		List<Class<? extends Domain>> classes = new ArrayList<>();
		classes.add(Role.class);
		classes.add(Country.class);

		//MultiDomainEditLayout domainLayout = new MultiDomainEditLayout(new FormOptions(), classes);
		//main.addComponent(domainLayout);
	}

}
