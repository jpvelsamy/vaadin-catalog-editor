package com.aj.view;

import javax.annotation.security.PermitAll;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexDirection;
import com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PermitAll
@Route(value = "form-edit-2", layout = MainLayout.class)
@PageTitle("New Form editor 2")
public class SingleCatalogueItemView extends Div {

    private FlexLayout mainLayout;
    private FlexLayout cardContainer = getFlexVerticalLayout(true);
   

    public SingleCatalogueItemView() 
    {

    

        createMainLayout();
    }

    private void createMainLayout() {
        mainLayout = getFlexHorizontalLayout(true);
        mainLayout.setAlignContent(FlexLayout.ContentAlignment.CENTER);
        mainLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        
        mainLayout.setWidth("unset");

       createLabelLayout();
       createRadioLayout();
       createAddButton();
       mainLayout.add(cardContainer);
       createCard();
       createTestimonial();

        add(mainLayout);
    }

    private FlexLayout createLabelLayout() {
        FlexLayout formLabelLayout = getFlexVerticalLayout(true);
        formLabelLayout.getStyle().set("align-content","center");
        formLabelLayout.getElement().getStyle().set("border-bottom", "2px solid chocolate");
        Label heading = new Label("You are editing form ");
        heading.getStyle().set("font-size", "30px");
        formLabelLayout.add(heading);
        mainLayout.add(formLabelLayout);
        return formLabelLayout;
    }
    private FlexLayout createAddButton(){
        FlexLayout addButtonLayout = getFlexHorizontalLayout(true);
        addButtonLayout.getStyle().set("justify-content", "start");
//        buttonLayout.getStyle().set("margin-right", "150px");
        Button addCard = new Button("Add");
        Icon addIcon = new Icon(VaadinIcon.PLUS);
        addCard.setIcon(addIcon);
        addCard.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addCard.addClickListener(event -> {
                cardContainer.add(createCard());
        });
        addButtonLayout.add(addCard);
        mainLayout.add(addButtonLayout);
        return addButtonLayout;
    }

    private FormLayout createCard() {
        FormLayout cardLayout = new FormLayout();
        cardLayout.getStyle().set("width", "50%");
        cardLayout.setHeightFull();
        TextField text = new TextField();
        text.getStyle().set("width", "350px");

        Button delete = new Button("Delete");
        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.getStyle().set("width", "unset");
        delete.addClickListener(event -> {
           cardContainer.remove(cardLayout);
        });
        
        cardLayout.add(text, delete);
        cardLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("500px", 2)
        );
        cardContainer.add(cardLayout);
        return cardLayout;
    }

    private FlexLayout createTestimonial(){
        FlexLayout testimonialLayout = new FlexLayout();
        testimonialLayout.setHeightFull();
        testimonialLayout.setWidthFull();
        TextArea testimonialText = new TextArea("Testimonial");
        testimonialText.setPlaceholder("Enter Text");
        testimonialText.setWidth("20%");
        testimonialText.setHeight("142px");
        TextArea testimonialSign = new TextArea();
        testimonialSign.setPlaceholder("Enter Signature");
        testimonialSign.getStyle().set("margin-top", "32px");
        testimonialSign.getStyle().set("margin-left", "20px");
        testimonialSign.setWidth("20%");
        testimonialLayout.add(testimonialText,testimonialSign);

        mainLayout.add(testimonialLayout);
        return testimonialLayout;
    }

    private FlexLayout createRadioLayout() {
        FlexLayout radioLayout = getFlexHorizontalLayout(true);
        radioLayout.getStyle().set("flex-flow", "column wrap");
        radioLayout.getStyle().set("margin-top", "20px");
        Label continueCard = new Label("Continuing card details");
        
        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setItems("Simple quotes", "Banner quotes");
        add(radioGroup);

        radioLayout.add(continueCard,radioGroup);
        mainLayout.add(radioLayout);
        return radioLayout;
    }
    
    public static FlexLayout getFlexVerticalLayout(boolean wrap) {
		FlexLayout flexLayout = new FlexLayout();
		flexLayout.setWidthFull();
		flexLayout.setFlexDirection(FlexDirection.COLUMN);
		flexLayout.setFlexWrap(wrap ? FlexWrap.WRAP : FlexWrap.NOWRAP);
		flexLayout.setAlignContent(ContentAlignment.START);
		return flexLayout;
	}
    
    public static FlexLayout getFlexHorizontalLayout(boolean wrap) {
		FlexLayout flexLayout = new FlexLayout();
		flexLayout.setWidthFull();
		flexLayout.setFlexDirection(FlexDirection.ROW);
		flexLayout.setFlexWrap(wrap ? FlexWrap.WRAP : FlexWrap.NOWRAP);
		flexLayout.setAlignContent(ContentAlignment.START);
		return flexLayout;
	}
}
