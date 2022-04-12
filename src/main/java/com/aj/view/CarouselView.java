package com.aj.view;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;

import com.aj.GreetService;
import com.flowingcode.vaadin.addons.carousel.Carousel;
import com.flowingcode.vaadin.addons.carousel.Slide;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@PermitAll
@Route(value = "carousel", layout = MainLayout.class)
@PageTitle("Carousel | Vaadin CRM")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class CarouselView extends VerticalLayout {

	private static final long serialVersionUID = -570365902219842942L;

	public CarouselView(@Autowired GreetService service) {

		Slide s1 = new Slide(createSlideContent("Slide 1", "green"));
		Slide s2 = new Slide(createSlideContent("Slide 2", "blue"));
		Slide s3 = new Slide(createSlideContent("Slide 3", "red"));
		Slide s4 = new Slide(createSlideContent("Slide 4", "yellow"));

		final Carousel cf = new Carousel(s1, s2, s3, s4).withoutNavigation();
		cf.setWidth("100%");
		cf.setHeight("180px");
		Button next = new Button(">>");
		Button prev = new Button("<<");
		Button last = new Button(">|");
		Button first = new Button("|<");
		next.addClickListener(e -> cf.moveNext());
		prev.addClickListener(e -> cf.movePrev());
		last.addClickListener(e -> cf.movePos(3));
		first.addClickListener(e -> cf.movePos(0));

		cf.addChangeListener(e -> Notification.show("Slide Changed!", 1000, Position.BOTTOM_START));
		HorizontalLayout btns = new HorizontalLayout(first, prev, next, last);
		btns.setAlignItems(Alignment.CENTER);
		btns.setJustifyContentMode(JustifyContentMode.CENTER);
		btns.setWidthFull();
		add(cf, btns);
	}

	private Component createSlideContent(String string, String color) {
		H1 label = new H1(string);
		label.getStyle().set("margin-top", "auto");
		label.getStyle().set("margin-bottom", "auto");
		VerticalLayout d = new VerticalLayout(label);
		d.setAlignItems(Alignment.CENTER);
		d.setSizeFull();
		d.getStyle().set("background-color", color);
		return d;
	}

}
