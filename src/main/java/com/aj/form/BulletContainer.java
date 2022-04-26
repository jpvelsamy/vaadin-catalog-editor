package com.aj.form;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

import java.util.concurrent.atomic.AtomicInteger;

public class BulletContainer extends FlexLayout
{

	private static final long serialVersionUID = 6284423363964713884L;
	private Button addBullet = new Button("", new Icon(VaadinIcon.PLUS_CIRCLE));
	private AtomicInteger counter = new AtomicInteger(1);
	private BulletTextField defaultField;
	private BulletTextField field;
	
	public BulletContainer()
	{
		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.WRAP);
		add(addBullet);
		setAlignSelf(Alignment.END, addBullet);
		defaultField = new BulletTextField(counter.getAndIncrement(), this);
		add(defaultField);
		addBullet.addClickListener(event->{
			field = new BulletTextField(counter.getAndIncrement(), this);
			add(field);
		});
	}
	public void getResetBullet() {
		/*defaultField.getResetBulletText();
		field.clear();*/
		if (field==null){
			defaultField.getResetBulletText();
		} else {
			removeAll();
			defaultField.getResetBulletText();
			add(defaultField);

		}
	}
}
