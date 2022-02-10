package model;

import javax.swing.ImageIcon;

import main.Main;

public class Photo {
	int num;
	String fileName, OriginfileName;
	ImageIcon photo, photoOn;
	public Photo(int num) {
		this.num = num;
		String N = Integer.toString(num+1);
		this.fileName = "/view/photoGUI/photo/main.png";
		this.OriginfileName = "/view/photoGUI/photo/Originals/"+N+".jpg";
		this.photo = new ImageIcon(Main.class.getResource(fileName));
		this.photoOn = new ImageIcon(Main.class.getResource(OriginfileName));
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName() {
		this.fileName = "/view/photoGUI/photo/main.png";
		this.photo = new ImageIcon(Main.class.getResource(fileName));
	}
	public String getOriginfileName() {
		return OriginfileName;
	}
	public void setOriginfileName(int num) {
		this.num = num;
		String N = Integer.toString(num+1);
		OriginfileName = "/view/photoGUI/photo/Originals/"+N+".jpg";
		this.photoOn = new ImageIcon(Main.class.getResource(OriginfileName));
	}
	public ImageIcon getPhoto() {
		return photo;
	}
	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}
	public ImageIcon getPhotoOn() {
		return photoOn;
	}
	public void setPhotoOn(ImageIcon photoOn) {
		this.photoOn = photoOn;
	}
}
