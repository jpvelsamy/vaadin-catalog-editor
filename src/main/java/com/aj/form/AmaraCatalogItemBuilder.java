package com.aj.form;

import com.aj.reusuables.LapDesignTemplate;
import com.aj.reusuables.LeadAcquisitionPage;
import com.aj.view.CatalogueItemDesign;

import java.util.ArrayList;
import java.util.Collection;

public class AmaraCatalogItemBuilder implements CarouselItemBuilder {

	private final LapDesignTemplate lapDesign;
	public AmaraCatalogItemBuilder(LapDesignTemplate lapDesign) {

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


	@Override
	public CatalogItemView buildNewCard(int position) {

		return new NewCatalogItemView(position);
	}

	@Override
	public Collection<CatalogItemView> buildAllCards(int position) {
		Collection<CatalogItemView> catalogItemViews = new ArrayList<>();
		for (int i=1;i<=4;i++){
			catalogItemViews.add(buildNewCard(++position));
		}
		return catalogItemViews;
	}

}
