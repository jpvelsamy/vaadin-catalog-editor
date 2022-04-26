package com.aj.form;

import com.aj.reusuables.LapDesignTemplate;
import com.aj.reusuables.LapDesignTemplateConstant;
import com.aj.reusuables.LeadAcquisitionPage;
import com.aj.reusuables.LeadDataService;
import com.aj.view.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.*;

import javax.annotation.security.PermitAll;
import java.util.LinkedHashSet;
import java.util.Set;

@PermitAll
@Route(value = ArbitraryCatalogFormEditor.ROUTE_NAME, layout = MainLayout.class)
@PageTitle("Form editor")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class ArbitraryCatalogFormEditor extends Div implements HasUrlParameter<String> {

    private static final long serialVersionUID = 4437849387689106663L;
    public final static String ROUTE_NAME = "form-editor";

    private final HorizontalLayout carouselContainer = new HorizontalLayout();
    private final CatalogCarouselContainer carouselHolder = new CatalogCarouselContainer();
    private final Button addCard = new Button("Add Card");
    private final Button next;
    private final Button previous;
    private final LeadDataService leadDataService;
    private final ComboBox<LapDesignTemplate> lapDesign;
    private LeadAcquisitionPage lap;
    private String formId;
    Set<LapDesignTemplate> templateCollection;
    private LapDesignTemplate amaraFields;
    private int counter = 0;
	private LapDesignTemplate selectedTemplate;


    public ArbitraryCatalogFormEditor(LeadDataService leadDataService) {
        this.leadDataService = leadDataService;

        add(addCard);
        addCard.setIcon(new Icon(VaadinIcon.PLUS));

        lapDesign = new ComboBox<>();
        lapDesign.setPlaceholder("Select Design");
        lapDesign.setItemLabelGenerator(LapDesignTemplate::getName);
        templateCollection = createLapDesignTemplate();
		lapDesign.addValueChangeListener(event -> {

			selectedTemplate = event.getValue();

		});
        lapDesign.setItems(templateCollection);
        final LapDesignTemplate defaultTemplate = templateCollection.iterator().next();
        lapDesign.setValue(defaultTemplate);
        this.carouselHolder.swapTemplate(defaultTemplate);
        add(lapDesign);

        next = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_LEFT));
        previous = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
    }

    public void init() {

        lapDesign.addCustomValueSetListener(event -> {
            LapDesignTemplate template = lapDesign.getValue();
            this.carouselHolder.swapTemplate(template);
        });

        addCard.addClickListener(event -> {
            if (selectedTemplate.equals(amaraFields)) {
                counter += 1;
                Integer position = this.carouselHolder.getLastIndex();
                CatalogueItem emptyItem = new CatalogueItem();
                emptyItem.setPosition(position);
                this.carouselHolder.addNewCard(emptyItem);
				if (counter >= 4) {
					addCard.setEnabled(false);
					Notification notification = Notification.show("Only 4 Section allowed for selected Template");
					notification.setPosition(Notification.Position.MIDDLE);
//					notification.addDetachListener(detachEvent -> addCard.setEnabled(true));
				}
            } else {
                Integer position = this.carouselHolder.getLastIndex();
                CatalogueItem emptyItem = new CatalogueItem();
                emptyItem.setPosition(position);
                this.carouselHolder.addNewCard(emptyItem);
            }
        });

        carouselContainer.add(next);
        carouselContainer.add(carouselHolder);
        carouselContainer.add(previous);
        previous.getStyle().set("margin-left", "-210px");
        next.getStyle().set("margin-left", "10px");
        carouselContainer.setAlignSelf(Alignment.CENTER, next);
        carouselContainer.setAlignSelf(Alignment.CENTER, carouselHolder);
        carouselContainer.setAlignSelf(Alignment.CENTER, previous);
        add(carouselContainer);


        next.addClickListener(event -> {
            this.carouselHolder.moveForward();
        });

        previous.addClickListener(event -> {

            this.carouselHolder.moveBackward();

        });
    }

    public Set<LapDesignTemplate> createLapDesignTemplate() {
        Set<LapDesignTemplate> templateSet = new LinkedHashSet<LapDesignTemplate>();
        LapDesignTemplate t1 = new LapDesignTemplate();
        t1.setName("Pricing template");
        t1.setTemplateType(LapDesignTemplateConstant.DEFAULT_PRICING_CARD);
        templateSet.add(t1);

        LapDesignTemplate t2 = new LapDesignTemplate();
        t2.setName("Snake ladder");
        t2.setTemplateType(LapDesignTemplateConstant.DEFAULT_TEMPLATE_AMARA_CARD);
        templateSet.add(t2);

        amaraFields = new LapDesignTemplate();
        amaraFields.setName("AmaraFields");
        amaraFields.setTemplateType(LapDesignTemplateConstant.DEFAULT_TEMPLATE_AMARAFIELDS_CARD);

        templateSet.add(amaraFields);

        return templateSet;
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter != null) {
            this.formId = parameter;
            lap = this.leadDataService.get(this.formId);
            this.carouselHolder.loadLap(lap);
        }
        this.init();
    }
}
