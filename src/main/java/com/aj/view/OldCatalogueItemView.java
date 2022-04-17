package com.aj.view;

import java.io.InputStream;
import java.util.Objects;

import org.vaadin.miki.superfields.text.SuperTextArea;
import org.vaadin.miki.superfields.text.SuperTextField;

import com.aj.form.CatalogueItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;

import reusuables.LapDesignTemplate;

public class OldCatalogueItemView extends FormLayout {
	private static final long serialVersionUID = -2547872986384246417L;
	private CatalogueItem catalogueItem;
	private Button deleteCard;
	private SuperTextField title = new SuperTextField("Title");
	private SuperTextField pricingValue = new SuperTextField("Pricing Value");
	private SuperTextField alternateValue = new SuperTextField("Alternate Value");
	private SuperTextField ctaDemo = new SuperTextField("ctaDemo");
	private SuperTextArea ctaEnroll = new SuperTextArea("ctaEnroll");
	private SuperTextField ctaQuote = new SuperTextField("ctaQuote");
	private Integer position;

	public OldCatalogueItemView(CatalogueItem catalogueItem, Integer position) {

		this.position = position;
		addClassName("CI-View");
		setWidthFull();
		getStyle().set("margin-top", "40px");
		getStyle().set("margin-right", "1px");

		ComboBox<LapDesignTemplate> lapDesign = new ComboBox<>();
		lapDesign.setPlaceholder("Select Design");
		add(lapDesign);

		if (Objects.nonNull(catalogueItem)) {

			title.setValue(this.catalogueItem.getTitle());
			pricingValue.setValue(this.catalogueItem.getPricingValue());
			alternateValue.setValue(this.catalogueItem.getAlternatePricingValue());
			ctaDemo.setValue(this.catalogueItem.getCtaDemo());
			ctaEnroll.setValue(this.catalogueItem.getCtaEnroll());
			ctaQuote.setValue(this.catalogueItem.getCtaQuote());

		} else 
		{
			title.setValue(Integer.toString(position));
		}

		deleteCard = new Button("Delete");
		deleteCard.setIcon(new Icon(VaadinIcon.TRASH));
		deleteCard.setIconAfterText(true);

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

		add(this.deleteCard, this.title, this.pricingValue, this.alternateValue, this.ctaDemo, this.ctaEnroll,
				this.ctaQuote, uploadImages, uploadVideos);
	}

	public Button getDeleteCard() {
		return deleteCard;
	}
	
	public Integer getPosition()
	{
		return this.position;
	}
}
