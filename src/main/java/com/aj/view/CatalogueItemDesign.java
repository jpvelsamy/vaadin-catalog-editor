package com.aj.view;





public class CatalogueItemDesign {

    
    private String id;
    
    private String fontColor;
    
    private String backgroundColor;
    
    private String imageLayoutBgColor;
    
    private String imageLayoutAlignment;
    
    private final String imageLayoutPosition = "left";
    
    private final String contentLayoutPosition = "right";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getImageLayoutBgColor() {
		return imageLayoutBgColor;
	}

	public void setImageLayoutBgColor(String imageLayoutBgColor) {
		this.imageLayoutBgColor = imageLayoutBgColor;
	}

	public String getImageLayoutAlignment() {
		return imageLayoutAlignment;
	}

	public void setImageLayoutAlignment(String imageLayoutAlignment) {
		this.imageLayoutAlignment = imageLayoutAlignment;
	}

	public String getImageLayoutPosition() {
		return imageLayoutPosition;
	}

	public String getContentLayoutPosition() {
		return contentLayoutPosition;
	}
    
    

}
