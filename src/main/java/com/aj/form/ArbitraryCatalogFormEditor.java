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


    public ArbitraryCatalogFormEditor(LeadDataService leadDataService) {
        this.leadDataService = leadDataService;

        add(addCard);
        addCard.setIcon(new Icon(VaadinIcon.PLUS));

        lapDesign = new ComboBox<>();
        lapDesign.setPlaceholder("Select Design");
        lapDesign.setItemLabelGenerator(LapDesignTemplate::getName);
        templateCollection = createLapDesignTemplate();
        lapDesign.setItems(templateCollection);
        final LapDesignTemplate defaultTemplate = templateCollection.iterator().next();
        lapDesign.setValue(defaultTemplate);
        this.carouselHolder.swapTemplate(defaultTemplate);
        add(lapDesign);

        next = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_LEFT));
        previous = new Button("", new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
    }

    public void init() {

        lapDesign.addValueChangeListener(event -> {
            this.carouselHolder.removeAll();
            LapDesignTemplate template = lapDesign.getValue();
            this.carouselHolder.getItemMap().clear();
            this.carouselHolder.swapTemplate(template);
            this.carouselHolder.createAllCards();
        });

        addCard.addClickListener(event -> {
            Integer position = this.carouselHolder.getLastIndex();
            CatalogueItem emptyItem = new CatalogueItem();
            emptyItem.setPosition(position);
            this.carouselHolder.addNewCard(emptyItem);
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
        t2.setName("Amara");
        t2.setTemplateType(LapDesignTemplateConstant.DEFAULT_TEMPLATE_AMARA_CARD);
        templateSet.add(t2);

        LapDesignTemplate t3 = new LapDesignTemplate();
        t3.setName("AmaraFields");
        t3.setTemplateType(LapDesignTemplateConstant.DEFAULT_TEMPLATE_AMARAFIELDS_CARD);
        templateSet.add(t3);

        LapDesignTemplate t4 = new LapDesignTemplate();
        t4.setName("Askjuno Marketing");
        t4.setTemplateType(LapDesignTemplateConstant.DEFAULT_TEMPLATE_ASKJUNO_MARKETING);
        templateSet.add(t4);

        LapDesignTemplate t5 = new LapDesignTemplate();
        t5.setName("Intellisol");
        t5.setTemplateType(LapDesignTemplateConstant.DEFAULT_TEMPLATE_INTELLISOL_CARD);
        templateSet.add(t5);

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
    public void getAddCardDisable(){
        this.addCard.setEnabled(false);
    }
}
