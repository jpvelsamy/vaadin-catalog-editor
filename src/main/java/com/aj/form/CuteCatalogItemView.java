package com.aj.form;


import java.io.InputStream;
import java.util.Objects;

import org.vaadin.miki.superfields.text.SuperTextArea;
import org.vaadin.miki.superfields.text.SuperTextField;

import com.aj.LumoConstants;
import com.aj.StyleUtil;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;

import reusuables.LapDesignTemplate;


public class CuteCatalogItemView extends FlexLayout 
{
	
	private static final long serialVersionUID = 7933518275280896892L;
	
	private final FlexLayout catalogContainer = getFlexVerticalLayout(true);
	private CatalogueItem catalogueItem;
	private Button deleteCard;
	private SuperTextField title = new SuperTextField("Title");
	private SuperTextField pricingValue = new SuperTextField("Pricing Value");
	private SuperTextField alternateValue = new SuperTextField("Alternate Value");
	private SuperTextField ctaDemo = new SuperTextField("ctaDemo");
	private SuperTextArea ctaEnroll = new SuperTextArea("ctaEnroll");
	private SuperTextField ctaQuote = new SuperTextField("ctaQuote");
	private Integer position;

	private H3 catalogHeader;
	
	public CuteCatalogItemView(CatalogueItem item, Integer index)
	{
		this.position = index;
		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.WRAP);
		setAlignContent(ContentAlignment.START);
		setWidth(410, Unit.PIXELS);
		StyleUtil.setMarginTop(this, LumoConstants.LUMO_SPACE_XL);
		StyleUtil.setMarginLeft(this, LumoConstants.LUMO_SPACE_L);
		StyleUtil.setMarginRight(this, LumoConstants.LUMO_SPACE_S);
		
		catalogHeader = new H3("Section "+index);
		StyleUtil.setMarginLeft(catalogHeader, LumoConstants.LUMO_SPACE_S);
		add(catalogHeader);
		setAlignSelf(Alignment.CENTER, catalogHeader);
		
		ComboBox<LapDesignTemplate> lapDesign = new ComboBox<>();
		lapDesign.setPlaceholder("Select Design");
		add(lapDesign);
		
		catalogContainer.addClassName("curved-border");
		catalogContainer.setAlignItems(Alignment.CENTER);
		catalogContainer.setAlignContent(ContentAlignment.CENTER);
		
		Image bgImage = new Image();
		bgImage.setMaxHeight("300px");
		bgImage.setMaxWidth("300px");
		bgImage.setSrc("https://res.cloudinary.com/caseyforjuno/image/upload/v1625040584/76929575_m.jpg.jpg");
		bgImage.getStyle().set("border-radius", "25px");// border-radius: 20p
		catalogContainer.add(bgImage);
		
		if (Objects.nonNull(catalogueItem)) {

			//title.setValue(this.catalogueItem.getTitle());
			pricingValue.setValue(this.catalogueItem.getPricingValue());
			alternateValue.setValue(this.catalogueItem.getAlternatePricingValue());
			ctaDemo.setValue(this.catalogueItem.getCtaDemo());
			ctaEnroll.setValue(this.catalogueItem.getCtaEnroll());
			ctaQuote.setValue(this.catalogueItem.getCtaQuote());

		} else 
		{
			title.setValue(Integer.toString(position));
		}
		MultiFileMemoryBuffer bufferImage = new MultiFileMemoryBuffer();
		Upload uploadImages = new Upload(bufferImage);
		uploadImages.setAutoUpload(true);
		uploadImages.setAcceptedFileTypes("image/png", "image/jpeg", "image/gif");
		uploadImages.setUploadButton(new Button("Upload Images"));
		uploadImages.addSucceededListener(event -> {
			String fileName = event.getFileName();
			InputStream inputStream = bufferImage.getInputStream(fileName);

		});

		MultiFileMemoryBuffer bufferVideos = new MultiFileMemoryBuffer();
		Upload uploadVideos = new Upload(bufferVideos);
		uploadVideos.setAutoUpload(true);
		uploadVideos.setAcceptedFileTypes("video/mp4", "video/avi", "video/webm", "video/flv", "video/wmv", "video/mov",
				"video/mkv");
		uploadVideos.setUploadButton(new Button("Upload Videos"));
		uploadVideos.getStyle().set("margin-left", "800px");
		uploadVideos.addSucceededListener(event -> {
			String fileName = event.getFileName();
			InputStream inputStream = bufferVideos.getInputStream(fileName);

		});

		catalogContainer.add(this.title, this.pricingValue, this.alternateValue, this.ctaDemo, this.ctaEnroll,
				this.ctaQuote, uploadImages, uploadVideos);
		add(catalogContainer);
	}
	
	public static FlexLayout getFlexVerticalLayout(boolean wrap) {
		FlexLayout flexLayout = new FlexLayout();
		flexLayout.setWidthFull();
		flexLayout.setFlexDirection(FlexDirection.COLUMN);
		flexLayout.setFlexWrap(wrap ? FlexWrap.WRAP : FlexWrap.NOWRAP);
		flexLayout.setAlignContent(ContentAlignment.START);
		return flexLayout;
	}

	public Integer getIndex() {
		return this.position;
		
	}

	public void setIndex(int newPosition) {
		this.position = newPosition;
		this.catalogHeader.removeAll();
		this.catalogHeader.add("Section "+this.position);
		title.setValue(Integer.toString(position));
		
	}

}
