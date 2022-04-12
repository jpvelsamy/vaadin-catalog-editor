package com.aj.view;

import com.aj.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

	private static final long serialVersionUID = -2367575791855548860L;

	private final SecurityService securityService;

	public MainLayout(SecurityService securityService) {
		this.securityService = securityService;
		createHeader();
		createDrawer();
	}

	private void createHeader() {
		H1 logo = new H1("Vaadin CRM");
		logo.addClassNames("text-l", "m-m");

		Button logout = new Button("Log out", e -> securityService.logout());

		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

		header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
		header.expand(logo);
		header.setWidth("100%");
		header.addClassNames("py-0", "px-m");

		addToNavbar(header);

	}

	private void createDrawer() {
		
		RouterLink capcatcarLink = new RouterLink("CaptiveCarousel", CaptiveCatalogCarousel.class);
		
		RouterLink catCarLink = new RouterLink("CatalogCarousel",ThirdPartyCarouselCatalogueView.class);
		
		RouterLink catalogLink = new RouterLink("Catalogue",SingleCatalogueItemView.class);
		
		RouterLink listLink = new RouterLink("List", ListView.class);
		listLink.setHighlightCondition(HighlightConditions.sameLocation());

		RouterLink carouselLink = new RouterLink("Carousel", CarouselView.class);
		carouselLink.setHighlightCondition(HighlightConditions.sameLocation());

		RouterLink dashboardLink = new RouterLink("Dashboard", DashboardView.class);
		addToDrawer(new VerticalLayout(capcatcarLink, catalogLink, listLink, carouselLink, dashboardLink));
	}
}