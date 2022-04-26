package com.aj.form;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;

public class TextContainer extends FlexLayout {

	private static final long serialVersionUID = -2322710206497039634L;
	RadioButtonGroup<String> contentType = new RadioButtonGroup<String>();
	private final BulletContainer bulletContainer;
	private final TextArea paraContainer;

	public TextContainer() {

		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.WRAP);
		contentType.setItems("Bullet","Paragraph");
		bulletContainer = new BulletContainer();
		paraContainer = new TextArea();		
		add(contentType);
//		setAlignSelf(Alignment.CENTER, contentType);
		contentType.addValueChangeListener(event->{
			String value = event.getValue();
			if(value.equals("Bullet")) {
				remove(paraContainer);
				add(bulletContainer);
//				setAlignSelf(Alignment.CENTER, bulletContainer);
			}
			else {
				remove(bulletContainer);
				add(paraContainer);
//				setAlignSelf(Alignment.STRETCH, paraContainer);
			}
		});
	}
	public void getResetPara() {
		paraContainer.clear();
		bulletContainer.getResetBullet();
	}

}
