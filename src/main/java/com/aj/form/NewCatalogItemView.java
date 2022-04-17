package com.aj.form;

import com.aj.LumoConstants;
import com.aj.StyleUtil;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;

public class NewCatalogItemView extends CatalogItemView{

	
	private static final long serialVersionUID = 2086073785008407999L;
	private AssetContainer assetContainer;
	private PricingContainer pricingContainer;
	private ContentContainer contentContainer;
	
	public NewCatalogItemView(int position)
	{
		this.position = position;
		this.catalogueItem  = new CatalogueItem();
		this.catalogueItem.setPosition(this.position);
		setFlexDirection(FlexDirection.COLUMN);
		setFlexWrap(FlexWrap.WRAP);
		setAlignContent(ContentAlignment.START);
		setWidth(410, Unit.PIXELS);
		StyleUtil.setMarginTop(this, LumoConstants.LUMO_SPACE_XL);
		StyleUtil.setMarginLeft(this, LumoConstants.LUMO_SPACE_L);
		StyleUtil.setMarginRight(this, LumoConstants.LUMO_SPACE_S);
		
		catalogHeader = new H3("Section "+this.position);
		StyleUtil.setMarginLeft(catalogHeader, LumoConstants.LUMO_SPACE_S);		
		setAlignSelf(Alignment.CENTER, catalogHeader);
		this.resetCard = new Button();
		setAlignSelf(Alignment.END, this.resetCard);
		this.title.setPlaceholder("Enter your title");
		this.title.setWidth(410, Unit.PIXELS);
		this.resetCard.setText("Reset");
		this.assetContainer = new AssetContainer();
		this.pricingContainer = new PricingContainer();
		this.contentContainer = new ContentContainer();
		addAll();
		
	}

	private void addAll() {
		add(catalogHeader);
		add(this.resetCard);
		add(this.title);
		add(this.assetContainer);
		add(this.pricingContainer);
		add(this.contentContainer);
	}
	
	
}
