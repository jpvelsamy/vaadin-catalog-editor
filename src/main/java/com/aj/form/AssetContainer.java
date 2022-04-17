package com.aj.form;

import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Set;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;

public class AssetContainer extends FlexLayout {

	private static final long serialVersionUID = -5074000412750089618L;
	private final RadioButtonGroup<String> assetGroup = new RadioButtonGroup<>();
	private final MultiFileMemoryBuffer assetBuffer = new MultiFileMemoryBuffer();
	private final Upload uploadAssets = new Upload(assetBuffer);	
	private boolean isImageUploaded=true;
	private Image bgImage;
	
	public AssetContainer()
	{
		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.WRAP);
		
		Set<String> assetCollection = new LinkedHashSet<>();
		assetCollection.add("Image");
		assetCollection.add("Video");
		assetGroup.setItems(assetCollection);
		assetGroup.addValueChangeListener(event->{
			String value = event.getValue();
			if(value.equalsIgnoreCase("image"))
				this.isImageUploaded=true;
			else
				this.isImageUploaded=false;
		});
		setAlignSelf(Alignment.CENTER, assetGroup);
		uploadAssets.setAutoUpload(true);
		uploadAssets.setAcceptedFileTypes("image/png", "image/jpeg", "image/gif","video/mp4");
		uploadAssets.setUploadButton(new Button("Upload"));		
		uploadAssets.addSucceededListener(event -> {
			String fileName = event.getFileName();
			InputStream inputStream = assetBuffer.getInputStream(fileName);
			String mimeType = event.getMIMEType();
			if(isImageUploaded) {
				
			}
			else {
				
			}
		});
		setAlignSelf(Alignment.CENTER, uploadAssets);
		bgImage = new Image();
		bgImage.setMaxHeight("350px");
		bgImage.setMaxWidth("400px");
		bgImage.setSrc("https://res.cloudinary.com/caseyforjuno/image/upload/v1625040584/76929575_m.jpg.jpg");
		bgImage.getStyle().set("border-radius", "25px");
		setAlignSelf(Alignment.CENTER, bgImage);
		add(this.assetGroup);
		add(this.uploadAssets);
		add(this.bgImage);
	}

}
