package com.aj.view;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.PermitAll;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PermitAll
@Route(value = MultiItemCatalogCarousel.ROUTE_NAME, layout = MainLayout.class)
@PageTitle("Cute catalog")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MultiItemCatalogCarousel extends Div {

	private static final long serialVersionUID = 4437849387689106663L;
	public final static String ROUTE_NAME = "multicat";
	private final HorizontalLayout carouselContainer = new HorizontalLayout();
	private final ThreeCardContainer carouselHolder = new ThreeCardContainer();

	private Button next;
	private Button previous;
	private Button addCard = new Button("Add Card");

	public MultiItemCatalogCarousel() {
		add(addCard);
		addCard.setIcon(new Icon(VaadinIcon.PLUS));
		addCard.addClickListener(event -> {
			Integer position = carouselHolder.getLastIndex();
			CuteCatalogItem catalogItem = new CuteCatalogItem(null, position);
			this.carouselHolder.addCard(catalogItem);

		});
		next = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_LEFT));
		previous = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
		CuteCatalogItem firstPiece = new CuteCatalogItem(null, 1);
		carouselHolder.addFirstCard(firstPiece);
		carouselContainer.add(next);
		carouselContainer.add(carouselHolder);
		carouselContainer.add(previous);
		carouselContainer.setAlignSelf(Alignment.CENTER, next);
		carouselContainer.setAlignSelf(Alignment.CENTER, firstPiece);
		carouselContainer.setAlignSelf(Alignment.CENTER, previous);
		add(carouselContainer);

		next.addClickListener(event -> {
			this.carouselHolder.moveForward();
		});

		previous.addClickListener(event -> {
			this.carouselHolder.moveBackward();
		});
	}

}
