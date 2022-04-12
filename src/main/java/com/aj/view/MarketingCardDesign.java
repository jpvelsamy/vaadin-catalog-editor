package com.aj.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


public class MarketingCardDesign implements Serializable {



    private String bgColor;

    private String titleFontColor;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private Collection<CatalogueItemDesign> catalogueDetails = new ArrayList<>();

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getTitleFontColor() {
		return titleFontColor;
	}

	public void setTitleFontColor(String titleFontColor) {
		this.titleFontColor = titleFontColor;
	}

	public Collection<CatalogueItemDesign> getCatalogueDetails() {
		return catalogueDetails;
	}

	public void setCatalogueDetails(Collection<CatalogueItemDesign> catalogueDetails) {
		this.catalogueDetails = catalogueDetails;
	}
    
    

}