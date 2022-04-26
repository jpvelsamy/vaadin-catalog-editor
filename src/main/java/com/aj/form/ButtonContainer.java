package com.aj.form;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import org.vaadin.miki.superfields.text.SuperTextField;

public class ButtonContainer extends FlexLayout {

    private SuperTextField enroll;
    private SuperTextField demo;
    private SuperTextField quote;

    public ButtonContainer() {

        setFlexDirection(FlexDirection.ROW);
        setFlexWrap(FlexWrap.WRAP);
        setMinWidth(460, Unit.PIXELS);

        this.enroll = new SuperTextField();
        enroll.setPlaceholder("Enroll");
        enroll.setWidth("146px");
        this.demo = new SuperTextField();
        demo.setPlaceholder("Demo");
        demo.setWidth("146px");
        demo.getStyle().set("margin-left", "9px");
        this.quote = new SuperTextField();
        quote.setPlaceholder("Quote");
        quote.getStyle().set("margin-left", "12px");
        quote.setWidth("143px");
        add(enroll,demo,quote);

    }

    public void getResetCta() {
        enroll.clear();
        demo.clear();
        quote.clear();
    }
}
