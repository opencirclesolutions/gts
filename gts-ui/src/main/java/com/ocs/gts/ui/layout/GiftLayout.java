package com.ocs.gts.ui.layout;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.domain.model.AttributeModel;
import com.ocs.dynamo.domain.model.EntityModel;
import com.ocs.dynamo.service.BaseService;
import com.ocs.dynamo.service.ServiceLocatorFactory;
import com.ocs.dynamo.ui.component.DetailsEditGrid;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.composite.layout.ServiceBasedSplitLayout;
import com.ocs.dynamo.ui.provider.QueryType;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.domain.GiftTranslation;
import com.ocs.gts.service.GiftTranslationService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.provider.SortOrder;

/**
 * Subclass of ServiceBasedSplitLayout that adds a DetailsEditTable for managing
 * translations
 * 
 * @author bas.rutten
 *
 */
public class GiftLayout extends ServiceBasedSplitLayout<Integer, Gift> {

    private static final long serialVersionUID = -4522636263216539064L;

    private GiftTranslationService giftTranslationService = ServiceLocatorFactory.getServiceLocator()
            .getService(GiftTranslationService.class);

    public GiftLayout(BaseService<Integer, Gift> service, EntityModel<Gift> entityModel, FormOptions formOptions, SortOrder<?> sortOrder,
            FetchJoinInformation... joins) {
        super(service, entityModel, QueryType.ID_BASED, formOptions, sortOrder, joins);
    }

    @Override
    protected Component constructCustomField(EntityModel<Gift> entityModel, AttributeModel attributeModel, boolean viewMode,
            boolean searchMode) {

        // add custom field for the "translations" attribute
        if ("translations".equals(attributeModel.getName())) {
            FormOptions fo = new FormOptions().setShowRemoveButton(true);

            // create the table - notice how we pass the "viewMode" parameter
            DetailsEditGrid<Integer, GiftTranslation> dt = new DetailsEditGrid<Integer, GiftTranslation>(
                    getEntityModelFactory().getModel(GiftTranslation.class), attributeModel, viewMode, fo);
            dt.setCreateEntitySupplier(() -> {
                Gift gift = GiftLayout.this.getSelectedItem();
                GiftTranslation translation = new GiftTranslation();
                gift.addTranslation(translation);
                return translation;
            });
            dt.setRemoveEntityConsumer(t -> {
                Gift gift = GiftLayout.this.getSelectedItem();
                gift.removeTranslation(t);
            });

            return dt;
        }
        return null;
    }
};
