package com.aj.form;

import java.util.concurrent.atomic.AtomicInteger;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

public class TextContainer extends FlexLayout{

	
	private static final long serialVersionUID = -2322710206497039634L;	
	private Button addBullet = new Button("", new Icon(VaadinIcon.PLUS_CIRCLE));
	private AtomicInteger counter = new AtomicInteger(1);
	
	public TextContainer()
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
