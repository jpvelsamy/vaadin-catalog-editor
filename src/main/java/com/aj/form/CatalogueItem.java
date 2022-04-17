package com.aj.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reusuables.AskJunoImage;

public class CatalogueItem {

	public static final String NEW_STATUS = "NEW";
	public static final String EXISTING_STATUS = "EXISTING";
	public static final String DIRTIED_NEVERTHLESS = "DIRTIED";

	private volatile String updateFlag = NEW_STATUS;// OTHER VALUE BEING existing

	private String title;

	private String currency;

	private String pricingValue;

	private String alternateCurrency;

	private String alternatePricingValue;

	private String ctaDemo;

	private String ctaEnroll;

	private String ctaQuote;

	private String catalogueItemDesignId;

	private AskJunoImage askJunoImage;

	private List<String> simpleQuotes = new ArrayList<String>();

	private String testimonialQuote;

	private String testimonialSignature;

	private List<String> bannerQuotes = new ArrayList<String>();

	private Map<String, String> catalogueItemMetrics = new HashMap<String, String>();

	private String videoUrl;
	
	private Integer position;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPricingValue() {
		return pricingValue;
	}

	public void setPricingValue(String pricingValue) {
		this.pricingValue = pricingValue;
	}

	public String getCtaDemo() {
		return ctaDemo;
	}

	public void setCtaDemo(String cta1) {
		this.ctaDemo = cta1;
	}

	public String getCtaEnroll() {
		return ctaEnroll;
	}

	public void setCtaEnroll(String cta2) {
		this.ctaEnroll = cta2;
	}

	public List<String> getSimpleQuotes() {
		return simpleQuotes;
	}

	public void setSimpleQuotes(List<String> pricingQuotes) {
		this.simpleQuotes = pricingQuotes;
	}

	public void addQuote(String pricingQuote) {
		this.simpleQuotes.add(pricingQuote);
	}

	public AskJunoImage getImage() {
		return askJunoImage;
	}

	public void setImage(AskJunoImage askJunoImage) {
		this.askJunoImage = askJunoImage;
	}

	public String getAlternateCurrency() {
		return alternateCurrency;
	}

	public void setAlternateCurrency(String alternateCurrency) {
		this.alternateCurrency = alternateCurrency;
	}

	public String getAlternatePricingValue() {
		return alternatePricingValue;
	}

	public void setAlternatePricingValue(String alternatePricingValue) {
		this.alternatePricingValue = alternatePricingValue;
	}

	public Map<String, String> getCatalogueItemMetrics() {
		return catalogueItemMetrics;
	}

	public void setCatalogueItemMetrics(Map<String, String> catalogueItemMetrics) {
		this.catalogueItemMetrics = catalogueItemMetrics;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getTestimonialQuote() {
		return testimonialQuote;
	}

	public void setTestimonialQuote(String testimonialQuote) {
		this.testimonialQuote = testimonialQuote;
	}

	public String getTestimonialSignature() {
		return testimonialSignature;
	}

	public void setTestimonialSignature(String testimonialSignature) {
		this.testimonialSignature = testimonialSignature;
	}

	public List<String> getBannerQuotes() {
		return bannerQuotes;
	}

	public void setBannerQuotes(List<String> bannerQuotes) {
		this.bannerQuotes = bannerQuotes;
	}

	public void addBannerQuote(String pricingQuote) {
		this.bannerQuotes.add(pricingQuote);
	}

	public String getCtaQuote() {
		return ctaQuote;
	}

	public void setCtaQuote(String ctaQuote) {
		this.ctaQuote = ctaQuote;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getCatalogueItemDesignId() {
		return catalogueItemDesignId;
	}

	public void setCatalogueItemDesignId(String catalogueItemDesignId) {
		this.catalogueItemDesignId = catalogueItemDesignId;
	}

	public AskJunoImage getAskJunoImage() {
		return askJunoImage;
	}

	public void setAskJunoImage(AskJunoImage askJunoImage) {
		this.askJunoImage = askJunoImage;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	

}
