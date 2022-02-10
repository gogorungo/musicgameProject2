package view.numberGUI;

import javax.swing.ImageIcon;

import main.Main;

public class NumberGUI {
	int n;
	
	public NumberGUI() {
		// TODO Auto-generated constructor stub
	}
	
	public ImageIcon Numbergui(int n) {
		this.n = n;
		String number = "";
		if(n < 10) {
			number = "0"+ Integer.toString(n);
		} else {
			number = Integer.toString(n);
		}
		String dir = "/view/numberGUI/"+number+".png";
		ImageIcon CheckNumber = new ImageIcon(Main.class.getResource(dir));
		return CheckNumber;
	}
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	
	
}
