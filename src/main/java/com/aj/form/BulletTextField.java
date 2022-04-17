package com.aj.form;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class BulletTextField extends CustomField<TextBullet> {

	private static final long serialVersionUID = -3076414346361852317L;
	private Label label;
	private TextField amount;
	private Button deleteButton= new Button("", new Icon(VaadinIcon.TRASH));
	private TextContainer textContainer;
	
	public BulletTextField(int counter, TextContainer textContainer) {
		this.label = new Label(Integer.toString(counter));
		this.amount = new TextField();
		this.amount.setWidth(390, Unit.PIXELS);
		this.textContainer = textContainer;
		HorizontalLayout layout = new HorizontalLayout(label, amount, deleteButton);
		// Removes default spacing
		layout.setSpacing(false);
		// Adds small amount of space between the components
		layout.getThemeList().add("spacing-s");

		add(layout);
		deleteButton.addClickListener(event->{
			this.textContainer.remove(this);
		});
	}

	public void addThemeVariant(String theme) {
		getElement().getThemeList().add(theme);
		amount.addThemeName(theme);

	}

	@Override
	protected TextBullet generateModelValue() {
		return new TextBullet(Integer.parseInt(label.getText()), amount.getValue());
	}

	@Override
	protected void setPresentationValue(TextBullet bullet) {
		label.setText(Integer.toString(bullet.getId()));
		amount.setValue(bullet.getBulletText());
	}
}
