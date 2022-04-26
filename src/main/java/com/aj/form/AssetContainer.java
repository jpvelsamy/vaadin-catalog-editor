package com.aj.form;

import com.aj.reusuables.LayoutUtil;
import com.github.olafj.vaadin.flow.BlobSourceVideo;
import com.github.olafj.vaadin.flow.Video;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.server.StreamResource;

import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.Set;

public class AssetContainer extends FlexLayout {

	private static final long serialVersionUID = -5074000412750089618L;
	private final RadioButtonGroup<String> assetGroup = new RadioButtonGroup<>();
	private final MultiFileMemoryBuffer assetBuffer = new MultiFileMemoryBuffer();
	private final Upload uploadAssets = new Upload(assetBuffer);	
	private boolean isImageUploaded=true;
	private Image bgImage;
	private FlexLayout videoLayout;
	
	public AssetContainer()
	{
		setFlexDirection(FlexDirection.COLUMN);
//		setFlexWrap(FlexWrap.WRAP);
		
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
//		setAlignSelf(Alignment.CENTER, assetGroup);
		uploadAssets.setAutoUpload(true);
		uploadAssets.setAcceptedFileTypes("image/png", "image/jpeg", "image/gif","video/mp4");
		uploadAssets.setUploadButton(new Button("Upload"));		
		uploadAssets.addSucceededListener(event -> {
			String fileName = event.getFileName();
			InputStream inputStream = assetBuffer.getInputStream(fileName);
			String mimeType = event.getMIMEType();
			StreamResource resource = new StreamResource(fileName,
					() -> inputStream);

			if(isImageUploaded) {
				bgImage.setSrc(resource);
			}
			else {
				add(getVideoLayout(resource));
			}
		});
//		setAlignSelf(Alignment.CENTER, uploadAssets);
		bgImage = new Image();
		bgImage.setMaxHeight("350px");
		bgImage.setMaxWidth("400px");
		bgImage.setSrc("https://res.cloudinary.com/caseyforjuno/image/upload/v1593691871/no_image.jpg");
		bgImage.getStyle().set("border-radius", "25px");
		setAlignSelf(Alignment.CENTER, bgImage);
		add(this.assetGroup);
		add(this.uploadAssets);
		add(this.bgImage);
	}

	public FlexLayout getVideoLayout (StreamResource resource) {
		{
			videoLayout = LayoutUtil.getFlexVerticalLayout(true);
			Video video = new BlobSourceVideo();
			video.setMaxHeight("350px");
			video.setMaxWidth("400px");
			video.setMinHeight("150px");
			video.setMinWidth("150px");
			video.getStyle().set("filter", "opacity(0.5)");
			video.getStyle().set("border-radius", "20px");// border-radius: 20p
			videoLayout.add(video);
			ProgressBar pb = new ProgressBar();
			pb.setIndeterminate(true);
			videoLayout.add(pb);
			pb.setVisible(true);
			pb.getStyle().set("position", "absolute").set("z-index", "").set("left", "0").set("right", "0").set("top", "50%").set("--lumo-primary-color", "red");
			com.vaadin.flow.component.ComponentUtil.addListener(video, BlobSourceVideo.BlobSourceLoadedEvent.class, blobSourceLoadedEvent -> {
				pb.setVisible(false);
				video.getStyle().remove("filter");
			});
			video.setControls(true);
			video.setSource(resource);
			video.getStyle().set("object-fit", "cover");
			return videoLayout;
		}
	}

	public void getResetUploads(){
		uploadAssets.clearFileList();
		bgImage.setSrc("https://res.cloudinary.com/caseyforjuno/image/upload/v1593691871/no_image.jpg");
		videoLayout.removeAll();
	}

}
