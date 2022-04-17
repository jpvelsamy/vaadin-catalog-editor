package reusuables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.aj.form.CatalogueItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketingCard implements Serializable {

	private static final long serialVersionUID = -7085701918699849984L;

	private String id;

	private String title;

	private String singleLineText;

	private String formButtonText = "";

	private String format;

	private String style;

	private AskJunoImage imageSource;

	private Collection<String> multiLineText = new ArrayList<String>();

	@JsonIgnoreProperties(ignoreUnknown = true)
	private Collection<CatalogueItem> catalogueDetails = new ArrayList<CatalogueItem>();

	public MarketingCard() {
		super();
	}

	public MarketingCard(String title, AskJunoImage imageSource, String singleLineText,
			Collection<String> multiLineText) {
		super();
		this.title = title;
		this.imageSource = imageSource;
		this.singleLineText = singleLineText;
		this.multiLineText = multiLineText;
	}

	public String getTitle() {
		return title != null ? title : "";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AskJunoImage getImageSource() {
		return imageSource;
	}

	public void setImageSource(AskJunoImage imageSource) {
		this.imageSource = imageSource;
	}

	public String getSingleLineText() {
		return singleLineText != null ? singleLineText : "";
	}

	public void setSingleLineText(String singleLineText) {
		this.singleLineText = singleLineText;
	}

	public Collection<String> getMultiLineText() {
		return multiLineText;
	}

	public void setMultiLineText(Collection<String> multiLineText) {
		this.multiLineText = multiLineText;
	}

	public String getId() {
		return id != null ? id : "";
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFormButtonText() {
		return formButtonText != null ? formButtonText : "";
	}

	public void setFormButtonText(String formButtonText) {
		this.formButtonText = formButtonText;
	}

	public String getFormat() {
		return format != null ? format : "";
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getStyle() {
		return style != null ? style : "";
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Collection<CatalogueItem> getCatalogueDetails() {
		return catalogueDetails;
	}

	public void setCatalogueDetails(Collection<CatalogueItem> pricingDetails) {
		this.catalogueDetails = pricingDetails;
	}

}
