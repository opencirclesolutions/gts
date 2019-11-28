package com.ocs.gts.ui;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ocs.dynamo.service.MessageService;
import com.ocs.dynamo.ui.UIHelper;
import com.ocs.dynamo.ui.component.DefaultHorizontalLayout;
import com.ocs.dynamo.ui.component.DefaultVerticalLayout;
import com.ocs.dynamo.ui.menu.MenuService;
import com.ocs.dynamo.ui.utils.VaadinUtils;
import com.ocs.gts.domain.Organization;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * Main class
 * 
 * @author bas.rutten
 * 
 */
@UIScope
@Theme(Lumo.class)
@CssImport("./styles/shared-styles.css")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@CssImport("./styles/vaadin-custom-field.html")
@CssImport("./styles/vaadin-menu-bar.html")
@CssImport("./styles/vaadin-dialog.html")
@CssImport("./styles/vaadin-button.html")
@PreserveOnRefresh
public class GtsUI extends VerticalLayout implements RouterLayout {

    private static final long serialVersionUID = -4652393330832382449L;

    private MenuBar menu;

    @Autowired
    private MenuService menuService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private UIHelper uiHelper;

    /**
     * The version number - retrieved from POM file via application.properties
     */
    @Value("${application.version}")
    private String versionNumber;

    @Value("${oauth.service.url}")
    private String oauthServiceUrl;

    @Value("${security.oauth2.resource.logout-uri}")
    private String logoutUri;

    /**
     * Main method - sets up the application
     */
    @PostConstruct
    protected void init() {

        VaadinUtils.storeLocale(new Locale("en"));
        VaadinUtils.storeDateLocale(new Locale("en"));

        HorizontalLayout flex = new HorizontalLayout();
        flex.setSizeFull();

        add(flex);

        Image image = VaadinUtils.createImage("img-logo.png");
        flex.add(image);
        flex.setFlexGrow(2, image);

        VerticalLayout center = new VerticalLayout();
        center.setAlignItems(Alignment.CENTER);
        center.setJustifyContentMode(JustifyContentMode.CENTER);

        flex.add(center);
        flex.setFlexGrow(5, center);

        Text titleLabel = new Text(messageService.getMessage("gts.application.name", VaadinUtils.getLocale()) + " v" + versionNumber);
        VerticalLayout titleLayout = new VerticalLayout();
        titleLayout.add(titleLabel);
        center.add(titleLayout);

        HorizontalLayout rightLayout = new DefaultHorizontalLayout(false, false);
        flex.add(rightLayout);
        rightLayout.setJustifyContentMode(JustifyContentMode.END);

        VerticalLayout rightNested = new DefaultVerticalLayout(false, true);
        rightNested.setWidth("400px");
        rightLayout.add(rightNested);

        Button logoutButton = new Button("Logout");
        logoutButton.addClickListener(event -> {
            // String redirect = logoutUri + "?redirect_uri=" + oauthServiceUrl;
            UI.getCurrent().getPage().setLocation("/logout");
        });
        rightNested.add(logoutButton);

        // construct the menu
        menu = menuService.constructMenu("gts.menu");
        add(menu);
        uiHelper.setMenuBar(menu);

        menuService.setLastVisited(menu, Views.ORGANIZATION_VIEW);

        uiHelper.addEntityNavigationMapping(Organization.class, item -> {
            uiHelper.setSelectedEntity(item);
            uiHelper.navigate(Views.ORGANIZATION_VIEW);
            uiHelper.clearState();
        });

    }

    public MenuBar getMenu() {
        return menu;
    }

}
