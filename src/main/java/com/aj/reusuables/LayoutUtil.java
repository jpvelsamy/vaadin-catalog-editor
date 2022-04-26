package com.aj.reusuables;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;

public class LayoutUtil {

	
	public static FlexLayout getFlexVerticalLayout(boolean wrap) {
		FlexLayout flexLayout = new FlexLayout();
		flexLayout.setWidthFull();
		flexLayout.setFlexDirection(FlexDirection.COLUMN);
		flexLayout.setFlexWrap(wrap ? FlexWrap.WRAP : FlexWrap.NOWRAP);
		flexLayout.setAlignContent(ContentAlignment.CENTER);
		return flexLayout;
	}
}
