package com.aj;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.dom.Style;

public class StyleUtil {
	
	private StyleUtil() {		
	}
	
	public static Style setMargin(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_MARGIN, value);		
	}
	public static Style setMarginLeft(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_MARGIN_LEFT, value);		
	}
	public static Style setMarginRight(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_MARGIN_RIGHT, value);		
	}
	public static Style setMarginTop(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_MARGIN_TOP, value);		
	}
	public static Style setMarginBottom(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_MARGIN_BOTTOM, value);		
	}
	public static Style setPadding(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_PADDING, value);		
	}
	public static Style setPaddingLeft(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_PADDING_LEFT, value);		
	}
	public static Style setPaddingRight(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_PADDING_RIGHT, value);		
	}
	public static Style setPaddingTop(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_PADDING_TOP, value);		
	}
	public static Style setPaddingBottom(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_PADDING_BOTTOM, value);		
	}
	public static Style setTextTransform(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.TEXT_TRANSFORM, value);		
	}
	public static Style setFontColor(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_FONT_COLOR, value);		
	}
	public static Style setLineHeight(HasStyle hasStyle,String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_LINE_HEIGHT, value);		
	}
	public static Style setFontSize(HasStyle hasStyle, String value) {
		return hasStyle.getStyle().set(UIConstants.STYLE_ATTRIBUTE_FONT_SIZE, value);		
	}

}
