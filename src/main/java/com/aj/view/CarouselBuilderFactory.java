package com.aj.view;

public class CarouselBuilderFactory {

	public static CarouselItemBuilder create(LapDesignTemplate template) {
		
		return new ArbitraryCatalogItemBuilder(template);
	}

}
