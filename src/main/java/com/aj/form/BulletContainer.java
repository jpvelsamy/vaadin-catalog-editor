package com.aj.form;

import java.util.concurrent.atomic.AtomicInteger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class BulletContainer extends FlexLayout
{

	private static final long serialVersionUID = 6284423363964713884L;
	private Button addBullet = new Button("", new Icon(VaadinIcon.PLUS_CIRCLE));
	private AtomicInteger counter = new AtomicInteger(1);
	
	public BulletContainer()
	{
		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.WRAP);
		add(addBullet);
		setAlignSelf(Alignment.END, addBullet);
		addBullet.addClickListener(event->{
			BulletTextField field = new BulletTextField(counter.getAndIncrement(), this);			
			add(field);
		});
	}
}
