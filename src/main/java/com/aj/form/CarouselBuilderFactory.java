package com.aj.form;

import com.aj.reusuables.LapDesignTemplate;

public class CarouselBuilderFactory {

	public static CarouselItemBuilder create(LapDesignTemplate template) {
		
		return new ArbitraryCatalogItemBuilder(template);
	}

}
