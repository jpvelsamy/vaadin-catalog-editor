package com.aj.form;

public class TextBullet {

	private int id;
	private String bulletText;
	
	
	public TextBullet(int id, String bulletText) {
		super();
		this.id = id;
		this.bulletText = bulletText;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBulletText() {
		return bulletText;
	}
	public void setBulletText(String bulletText) {
		this.bulletText = bulletText;
	}
	
	
}
