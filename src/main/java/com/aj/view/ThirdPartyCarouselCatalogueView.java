package com.aj.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;

import com.aj.GreetService;
import com.flowingcode.vaadin.addons.carousel.Carousel;
import com.flowingcode.vaadin.addons.carousel.Slide;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PermitAll
@Route(value = "catcar", layout = MainLayout.class)
@PageTitle("Catalogue carousel")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class ThirdPartyCarouselCatalogueView extends VerticalLayout {

	private static final long serialVersionUID = -570365902219842942L;
	private final AtomicInteger counter = new AtomicInteger(0);
	private final Map<Long, Slide> slideMap = new LinkedHashMap<Long, Slide>();
	
	public ThirdPartyCarouselCatalogueView(@Autowired GreetService service) {

		final Carousel cf = new Carousel().withoutNavigation();
		cf.setWidth("100%");
		Button addCard = new Button("Add Card");
		addCard.setIcon(new Icon(VaadinIcon.PLUS));
		addCard.addClickListener(event -> {
			createSlideContent(cf);
		});
		add(addCard);
		Button next = new Button(">>");
		Button prev = new Button("<<");
		// Button last = new Button(">|");
		// Button first = new Button("|<");
		next.addClickListener(e -> cf.moveNext());
		prev.addClickListener(e -> cf.movePrev());
		// last.addClickListener(e -> cf.movePos(3));
		// first.addClickListener(e -> cf.movePos(0));

		cf.addChangeListener(e -> Notification.show("Slide Changed!", 1000, Position.BOTTOM_START));
		HorizontalLayout btns = new HorizontalLayout(prev, next);
		btns.setAlignItems(Alignment.CENTER);
		btns.setJustifyContentMode(JustifyContentMode.CENTER);
		btns.setWidthFull();
		add(cf, btns);
	}

	private Component createSlideContent(Carousel cf) {

		CatalogueItemView catalogueItemView = new CatalogueItemView(null, counter.incrementAndGet());
		Slide slide = new Slide(catalogueItemView);
		int index = counter.incrementAndGet();
		this.slideMap.put(new Long(index), slide);
		Slide[] array = this.slideMap.values().toArray(new Slide[0]);
		
		cf.setSlides(array);

		catalogueItemView.getDeleteCard().addClickListener(delEvent -> {
			this.slideMap.remove(index);
			cf.setSlides(this.slideMap.values().toArray(new Slide[0]));
		});
		return catalogueItemView;
	}

}
