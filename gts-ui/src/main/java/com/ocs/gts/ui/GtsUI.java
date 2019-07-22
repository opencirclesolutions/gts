package com.ocs.gts.ui;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ocs.dynamo.service.MessageService;
import com.ocs.dynamo.ui.BaseUI;
import com.ocs.dynamo.ui.component.BaseBanner;
import com.ocs.dynamo.ui.component.DefaultVerticalLayout;
import com.ocs.dynamo.ui.component.ErrorView;
import com.ocs.dynamo.ui.menu.MenuService;
import com.ocs.dynamo.ui.utils.VaadinUtils;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Main class
 * 
 * @author bas.rutten
 * 
 */
@SpringUI()
@Theme("light")
@SuppressWarnings("serial")
@UIScope
public class GtsUI extends BaseUI {

    private static final Logger LOG = LoggerFactory.getLogger(GtsUI.class);

    private VerticalLayout main;

    private MenuBar menu;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MessageService messageService;

    /**
     * The version number - retrieved from pom file via application.properties
     */
    @Value("${application.version}")
    private String versionNumber;

    private Panel viewPanel;

    @Autowired
    private SpringViewProvider viewProvider;

    /**
     * Main method - sets up the application
     */
    @Override
    protected void init(VaadinRequest request) {

        // handle a login
        Principal principal = request.getUserPrincipal();

        VaadinUtils.storeLocale(new Locale("en"));

        main = new DefaultVerticalLayout(false,false);
        setContent(main);

        BaseBanner banner = new BaseBanner("../../images/img-logo.png");
        main.addComponent(banner);

        // the center block
        HorizontalLayout hCenter = new HorizontalLayout();
        banner.addComponent(hCenter);

        VerticalLayout center = new DefaultVerticalLayout(true, false);
        hCenter.addComponent(center);
        hCenter.setPrimaryStyleName("");
        hCenter.setComponentAlignment(center, Alignment.MIDDLE_LEFT);
        hCenter.setSizeUndefined();

        // user name and logout button
        VerticalLayout titleLayout = new DefaultVerticalLayout(false, true);
        center.addComponent(titleLayout);

        // first line: application title
        Label titleLabel = new Label(
                "<b>" + messageService.getMessage("gts.application.name", VaadinUtils.getLocale()) + " v" + versionNumber + "</b>",
                ContentMode.HTML);
        titleLayout.addComponent(titleLabel);

        String userName = principal.getName();
        titleLayout.addComponent(
                new Label(messageService.getMessage("gts.logged.in.as", VaadinUtils.getLocale(), userName), ContentMode.HTML));

        banner.setExpandRatio(banner.getImage(), 0.3f);
        banner.setExpandRatio(hCenter, 2.0f);
        banner.setComponentAlignment(hCenter, Alignment.MIDDLE_RIGHT);

        // set up navigation
        VerticalLayout viewLayout = new VerticalLayout();
        viewPanel = new Panel();
        viewPanel.setContent(viewLayout);

        initNavigation(viewProvider, viewPanel, Views.ORGANIZATION_VIEW, true);

        getNavigator().setErrorView(new ErrorView());

        // construct the menu
        menu = menuService.constructMenu("gts.menu", getNavigator());
        main.addComponent(menu);

        main.addComponent(viewPanel);

    }
}
