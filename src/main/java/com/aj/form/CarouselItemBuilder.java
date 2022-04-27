package com.aj.form;

import java.util.Collection;

public interface CarouselItemBuilder {

	public  CatalogItemView build(CatalogueItem item);
	public CatalogItemView buildNewCard(int position);
	public Collection<CatalogItemView> buildAllCards(int position);

}
