package com.aj.form;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;

public class CurrencyField extends CustomField<Money> {

	private static final long serialVersionUID = -3076414346361852317L;
	private TextField amount;
	private Select<String> currency;

	public CurrencyField(String currencyString) {
		this();
		currency.setValue(currencyString);
	}

	public CurrencyField() {
		amount = new TextField();

		currency = new Select<>();
		currency.setItems("INR","USD","EUR", "GBP");
		currency.setValue("INR");
		currency.setWidth("6em");

		

		HorizontalLayout layout = new HorizontalLayout(currency, amount);
		// Removes default spacing
		layout.setSpacing(false);
		// Adds small amount of space between the components
		layout.getThemeList().add("spacing-s");

		add(layout);
	}

	public void addThemeVariant(String theme) {
		getElement().getThemeList().add(theme);
		amount.addThemeName(theme);
		currency.getElement().getThemeList().add(theme);
	}

	@Override
	protected Money generateModelValue() {
		return new Money(amount.getValue(), currency.getValue());
	}

	@Override
	protected void setPresentationValue(Money money) {
		amount.setValue(money.getAmount());
		currency.setValue(money.getCurrency());
	}
}
