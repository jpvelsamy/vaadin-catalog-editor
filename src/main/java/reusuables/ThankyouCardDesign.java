package reusuables;

import java.io.Serializable;

public class ThankyouCardDesign implements Serializable {

    
    private String bgColor;
    
    private String fontColor;
    
    private String titleColor;
    
    private String singleLineTextFontColor;
    
    private String multiLineTextFontColor;

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}

	public String getSingleLineTextFontColor() {
		return singleLineTextFontColor;
	}

	public void setSingleLineTextFontColor(String singleLineTextFontColor) {
		this.singleLineTextFontColor = singleLineTextFontColor;
	}

	public String getMultiLineTextFontColor() {
		return multiLineTextFontColor;
	}

	public void setMultiLineTextFontColor(String multiLineTextFontColor) {
		this.multiLineTextFontColor = multiLineTextFontColor;
	}
    
    
    
}