package com.aj.form;

public interface CarouselItemBuilder {

	public  CatalogItemView build(CatalogueItem item);
	public CatalogItemView buildNewCard(int position);

}
