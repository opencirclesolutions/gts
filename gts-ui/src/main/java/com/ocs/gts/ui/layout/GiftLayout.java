package com.ocs.gts.ui.layout;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.AttributeModel;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.service.BaseService;
import com.ocs.dynamo.ui.component.DetailsEditGrid;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.domain.GiftTranslation;
import com.vaadin.ui.AbstractField;

/**
 * Subclass of ServiceBasedSplitLayout that adds a DetailsEditTable for managing
 * translations
 * 
 * @author bas.rutten
 *
 */
public class GiftLayout extends ServiceBasedSplitLayout<Integer, Gift> {

	private static final long serialVersionUID = -4522636263216539064L;

	public GiftLayout(BaseService<Integer, Gift> service, EntityModel<Gift> entityModel, FormOptions formOptions,
			com.vaadin.data.provider.SortOrder<?> sortOrder, FetchJoinInformation... joins) {
		super(service, entityModel, QueryType.ID_BASED, formOptions, sortOrder, joins);
	}

	@Override
	protected AbstractField<?> constructCustomField(EntityModel<Gift> entityModel, AttributeModel attributeModel,
			boolean viewMode, boolean searchMode) {

		// add custom field for the "translations" attribute
		if ("translations".equals(attributeModel.getName())) {
			FormOptions fo = new FormOptions().setShowRemoveButton(true);

			// create the table - notice how we pass the "viewMode" parameter
			DetailsEditGrid<Integer, GiftTranslation> dt = new DetailsEditGrid<Integer, GiftTranslation>(
					getEntityModelFactory().getModel(GiftTranslation.class), attributeModel, viewMode, fo) {

				private static final long serialVersionUID = -3578481153580615529L;

				// method for adding a new row to the table
				@Override
				protected GiftTranslation createEntity() {
					Gift gift = GiftLayout.this.getSelectedItem();
					GiftTranslation translation = new GiftTranslation();
					gift.addTranslation(translation);
					return translation;
				}

				@Override
				protected void removeEntity(GiftTranslation toRemove) {
					Gift gift = GiftLayout.this.getSelectedItem();
					gift.removeTranslation(toRemove);
				}
			};
			return dt;
		}
		return null;
	}
};
