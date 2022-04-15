package com.aj.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.PermitAll;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * You still have issues with carousel navigation
 * @author jpvel
 *
 */
@PermitAll
@Route(value = "cutecat", layout = MainLayout.class)
@PageTitle("Cute catalog")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class CuteCatalogCarousel extends Div{

	private static final long serialVersionUID = 5381096124970188761L;
	private final HorizontalLayout carouselContainer = new HorizontalLayout();
	private final Div carouselHolder = new Div();
	private Map<Integer, CuteCatalogItem> itemMap = new LinkedHashMap<Integer, CuteCatalogItem>();
	private final AtomicInteger counter = new AtomicInteger(0);
	private Integer activeIndex = new Integer(0);
	private Button previous;
	private Button next;	
	private Button addCard = new Button("Add Card");
	
	
	
	public CuteCatalogCarousel( )
	{
		add(addCard);
		addCard.setIcon(new Icon(VaadinIcon.PLUS));
		addCard.addClickListener(event -> {
			Integer position = counter.incrementAndGet();
			CuteCatalogItem catalogItem = new CuteCatalogItem(null, position);
			itemMap.put(activeIndex, catalogItem);
			activeIndex = itemMap.size();
			this.carouselHolder.removeAll();
			this.carouselHolder.add(catalogItem);
			
		});
		previous = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_LEFT));
		next = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
		CuteCatalogItem firstPiece = new CuteCatalogItem(null, 0);
		itemMap.put(0, firstPiece);
		carouselHolder.add(firstPiece);
		carouselContainer.add(previous);
		carouselContainer.add(carouselHolder);
		carouselContainer.add(next);
		carouselContainer.setAlignSelf(Alignment.CENTER, previous);
		carouselContainer.setAlignSelf(Alignment.CENTER, firstPiece);
		carouselContainer.setAlignSelf(Alignment.CENTER, next);
		
		previous.addClickListener(event ->
		{
			if (activeIndex == 0)
			{
				previous.setEnabled(false);
			} else
			{
				activeIndex = activeIndex - 1;
				next.setEnabled(true);				
			}
			if (activeIndex >= 0)
			{
				this.carouselHolder.removeAll();
				CuteCatalogItem itemView = this.itemMap.get(activeIndex);
				this.carouselHolder.add(itemView);				
			}
		});
		next.addClickListener(event ->
		{
			if (activeIndex == itemMap.size() - 1)
			{
				next.setEnabled(false);
			} else
			{
				activeIndex = activeIndex + 1;
				previous.setEnabled(true);
			}
			if (activeIndex >= 0)
			{
				this.carouselHolder.removeAll();
				CuteCatalogItem itemView = this.itemMap.get(activeIndex);
				this.carouselHolder.add(itemView);	
			}
		});		
		
		add(carouselContainer);
	}

	
}
