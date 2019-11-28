package com.ocs.gts.ui;

import static com.google.common.collect.Lists.newArrayList;

import com.ocs.dynamo.functional.ui.MultiDomainEditLayout;
import com.ocs.dynamo.ui.composite.layout.FormOptions;
import com.ocs.dynamo.ui.view.BaseView;
import com.ocs.gts.domain.MainActivity;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
@Route(value = Views.DOMAIN_VIEW, layout = GtsUI.class)
public class DomainView extends BaseView {

    private static final long serialVersionUID = -4924496473085429208L;

    @Override
    @SuppressWarnings("unchecked")
    protected void doInit(VerticalLayout main) {
        MultiDomainEditLayout layout = new MultiDomainEditLayout(new FormOptions().setShowRemoveButton(true),
                newArrayList(MainActivity.class)) {

            private static final long serialVersionUID = 6876613808059544376L;

            protected boolean isDeleteAllowed(java.lang.Class<?> clazz) {
                return true;
            }
        };
        main.add(layout);
    }

}
