package com.aj.form;

import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class PricingContainer extends FlexLayout{

	
	private static final long serialVersionUID = -5637894479108018253L;
	private CurrencyField defaultPricingField;
	private CurrencyField alternatePricingField;
	
	
	public PricingContainer()
	{
		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.NOWRAP);
		defaultPricingField = new CurrencyField();
		alternatePricingField  = new CurrencyField("USD");
	/*	setAlignSelf(Alignment.CENTER, defaultPricingField);
		setAlignSelf(Alignment.CENTER, alternatePricingField);*/
		add(this.defaultPricingField);
		add(this.alternatePricingField);
	}

	public void getResetPrice() {
		defaultPricingField.getResetAmount();
		alternatePricingField.getResetAmount();
	}
}
