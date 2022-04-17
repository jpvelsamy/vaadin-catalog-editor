package reusuables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.io.Serializable;


public class FormCardDesign implements Serializable {



    private String bgColor;

    private String titleColor;

    private String navBarColor;
    
    private boolean isNavBarNeeded = false;

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}

	public String getNavBarColor() {
		return navBarColor;
	}

	public void setNavBarColor(String navBarColor) {
		this.navBarColor = navBarColor;
	}

	public boolean isNavBarNeeded() {
		return isNavBarNeeded;
	}

	public void setNavBarNeeded(boolean isNavBarNeeded) {
		this.isNavBarNeeded = isNavBarNeeded;
	}

    
    

}