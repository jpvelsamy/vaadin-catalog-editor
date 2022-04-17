package com.aj.view;

import java.util.Collection;

public class ArbitraryCatalogItemBuilder implements CarouselItemBuilder {

	private final LapDesignTemplate lapDesign;

	public ArbitraryCatalogItemBuilder(LapDesignTemplate lapDesign) {
		this.lapDesign = lapDesign;
	}

	
	public CatalogItemView buildBootstrapCard(LeadAcquisitionPage lap) {
		CatalogueItem firstItem = findFirstItem(lap.getMarketingCard().getCatalogueDetails());
		firstItem.setPosition(1);
		return new CatalogItemView(firstItem);
	}

	private CatalogueItem findFirstItem(Collection<CatalogueItem> catalogueDetails) {
		if (catalogueDetails != null && !catalogueDetails.isEmpty())
			return catalogueDetails.iterator().next();
		else
			return null;

	}

	@Override
	public CatalogItemView build(CatalogueItem item) {
		String designId = item.getCatalogueItemDesignId();
		CatalogueItemDesign itemDesign = this.lapDesign.findCatalogDesign(designId);
		if(itemDesign!=null && itemDesign.isBootStrapCard())
			return new CatalogItemView(item);
		else
			return new CatalogItemView(item);
	}

}
