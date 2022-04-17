package com.aj.form;

import com.vaadin.componentfactory.AnchorNav;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class ContentContainer extends FlexLayout{

	private static final long serialVersionUID = 5755026337181591633L;
	private AnchorNav contentNav;
	private TextContainer textContainer;
	
	public ContentContainer() {
		contentNav = new AnchorNav();
		contentNav.setHeight("300px");
		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.WRAP);
		
		textContainer = new TextContainer();
		add(textContainer);
	}
	
	
	
	

}
