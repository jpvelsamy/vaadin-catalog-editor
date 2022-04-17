package com.aj.view;


/*
 * Shiva's vision - Make this object embody the how the form is setup from a flow standpoint and how the form is setup
 * from experience standpoint, i.e - colors, fonts, sizes, single page, multipage
 */

public class LapDesignTemplate {


    private String id;

    private String name;

    private String templateType=LapDesignTemplateConstant.DEFAULT_PRICING_CARD;
    
    private String mappingUrl;

    private String junoBusinessId;

    private String junoBusinessAlias;

    private String junoAccountId;

    private String junoAccountAlias;

    private String ownerId;

    private String authorityId;

    private String description;

    private String font;

    private String textColor;

    private String notificationPosition;

    private boolean isSinglePage;


    private MarketingCardDesign marketingCardDesign;

    private FormCardDesign formCardDesign;

    private ThankyouCardDesign thankyouCardDesign;

    public LapDesignTemplate() {
        super();
    }

    public LapDesignTemplate(String name, MarketingCardDesign marketingCardDesign, FormCardDesign formCardDesign, ThankyouCardDesign thankyouCardDesign) {
        super();
        this.name = name;
        this.marketingCardDesign = marketingCardDesign;
        this.formCardDesign = formCardDesign;
        this.thankyouCardDesign = thankyouCardDesign;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isSinglePage() {
        return isSinglePage;
    }
    public void setSinglePage(boolean isSinglePage) {
        this.isSinglePage = isSinglePage;
    }
    public String getFont() {
        return font;
    }
    public void setFont(String font) {
        this.font = font;
    }
    public String getTextColor() {
        return textColor;
    }
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
    public String getNotificationPosition() {
        return notificationPosition;
    }
    public void setNotificationPosition(String notificationPosition) {
        this.notificationPosition = notificationPosition;
    }

    public String getJunoBusinessId() {
        return junoBusinessId;
    }

    public void setJunoBusinessId(String junoBusinessId) {
        this.junoBusinessId = junoBusinessId;
    }

    public String getJunoBusinessAlias() {
        return junoBusinessAlias;
    }

    public void setJunoBusinessAlias(String junoBusinessAlias) {
        this.junoBusinessAlias = junoBusinessAlias;
    }

    public String getJunoAccountId() {
        return junoAccountId;
    }

    public void setJunoAccountId(String junoAccountId) {
        this.junoAccountId = junoAccountId;
    }

    public String getJunoAccountAlias() {
        return junoAccountAlias;
    }

    public void setJunoAccountAlias(String junoAccountAlias) {
        this.junoAccountAlias = junoAccountAlias;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getMappingUrl() {
		return mappingUrl;
	}

	public void setMappingUrl(String mappingUrl) {
		this.mappingUrl = mappingUrl;
	}

	public MarketingCardDesign getMarketingCardDesign() {
		return marketingCardDesign;
	}

	public void setMarketingCardDesign(MarketingCardDesign marketingCardDesign) {
		this.marketingCardDesign = marketingCardDesign;
	}

	public FormCardDesign getFormCardDesign() {
		return formCardDesign;
	}

	public void setFormCardDesign(FormCardDesign formCardDesign) {
		this.formCardDesign = formCardDesign;
	}

	public ThankyouCardDesign getThankyouCardDesign() {
		return thankyouCardDesign;
	}

	public void setThankyouCardDesign(ThankyouCardDesign thankyouCardDesign) {
		this.thankyouCardDesign = thankyouCardDesign;
	}

	public CatalogueItemDesign findCatalogDesign(String itemDesignId) {
		return null;
		
	}
    
    
    
}