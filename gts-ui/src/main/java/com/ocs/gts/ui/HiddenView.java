//package com.ocs.gts.ui;
//
//import java.util.ArrayList;
//
//
//
//import com.ocs.dynamo.ui.auth.Authorized;
//import com.ocs.dynamo.ui.component.EntityTokenSelect;
//import com.ocs.dynamo.ui.view.BaseView;
//import com.ocs.gts.domain.Organization;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.Route;
//import com.vaadin.flow.spring.annotation.UIScope;
//import com.vaadin.flow.component.combobox.MultiSelectComboBox;
//
//@UIScope
//@Route(value = "hidden")
//@Authorized(roles = { "hidden" })
//public class HiddenView extends BaseView {
//
//    private static final long serialVersionUID = 8590097551894996830L;
//
//    @Override
//    protected void doInit(VerticalLayout main) {
//        VerticalLayout layout = new VerticalLayout();
//        layout.add(new MultiSelectComboBox<>());
//        layout.add(new EntityTokenSelect<>(getModelFactory().getModel(Organization.class), null, new ArrayList<>()));
//    }
//
//}
