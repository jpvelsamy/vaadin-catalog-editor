package com.aj.form;

import com.aj.reusuables.LapDesignTemplate;
import com.aj.reusuables.LapDesignTemplateConstant;

@SuppressWarnings("EqualsBetweenInconvertibleTypes")
public class CarouselBuilderFactory {

	public static CarouselItemBuilder create(LapDesignTemplate template) {
		if(template.getTemplateType().equals(LapDesignTemplateConstant.DEFAULT_TEMPLATE_AMARAFIELDS_CARD)) {
			return new AmaraFieldsCatalogItemBuilder(template);
		}else if (template.getTemplateType().equals(LapDesignTemplateConstant.DEFAULT_TEMPLATE_ASKJUNO_MARKETING)) {
			return new AskjunoMarketingCatalogItemBuilder(template);
		}else if (template.getTemplateType().equals(LapDesignTemplateConstant.DEFAULT_TEMPLATE_INTELLISOL_CARD)) {
			return new IntellisolCatalogItemBuilder(template);
		}else if (template.getTemplateType().equals(LapDesignTemplateConstant.DEFAULT_TEMPLATE_AMARA_CARD)) {
			return new AmaraCatalogItemBuilder(template);
		}else {
			return new ArbitraryCatalogItemBuilder(template);
		}
	}
}
