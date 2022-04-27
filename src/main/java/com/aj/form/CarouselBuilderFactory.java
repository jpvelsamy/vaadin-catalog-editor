package com.aj.form;

import com.aj.reusuables.LapDesignTemplate;
import com.aj.reusuables.LapDesignTemplateConstant;

@SuppressWarnings("EqualsBetweenInconvertibleTypes")
public class CarouselBuilderFactory {

	public static CarouselItemBuilder create(LapDesignTemplate template) {
		if(template.getTemplateType().equals(LapDesignTemplateConstant.DEFAULT_TEMPLATE_AMARAFIELDS_CARD)) {
			return new AmaraFieldsCatalogItemBuilder(template);
		}else {

			return new ArbitraryCatalogItemBuilder(template);
		}
	}
}
