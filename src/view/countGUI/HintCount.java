package view.countGUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Main;

public class HintCount {
	public static ImageIcon RemainHint5 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainHint5.png"));
	public static JLabel RemainHint5Label = new JLabel(RemainHint5);
	public static ImageIcon RemainHint4 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainHint4.png"));
	public static JLabel RemainHint4Label = new JLabel(RemainHint4);
	public static ImageIcon RemainHint3 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainHint3.png"));
	public static JLabel RemainHint3Label = new JLabel(RemainHint3);
	public static ImageIcon RemainHint2 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainHint2.png"));
	public static JLabel RemainHint2Label = new JLabel(RemainHint2);
	public static ImageIcon RemainHint1 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainHint1.png"));
	public static JLabel RemainHint1Label = new JLabel(RemainHint1);
	public static ImageIcon RemainHint0 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainHint0.png"));
	public static JLabel RemainHint0Label = new JLabel(RemainHint0);
	int count;
	
	public HintCount() {
		this.count = 5;
	}

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public JLabel Remain() {
		RemainHint5Label.setBounds(44, 220, 300, 86);
		RemainHint4Label.setBounds(44, 220, 300, 86);
		RemainHint3Label.setBounds(44, 220, 300, 86);
		RemainHint2Label.setBounds(44, 220, 300, 86);
		RemainHint1Label.setBounds(44, 220, 300, 86);
		RemainHint0Label.setBounds(44, 220, 300, 86);
		JLabel remain = null;
		switch (count) {
		case 5: {remain = RemainHint5Label; break;}
		case 4: {remain = RemainHint4Label; break;}
		case 3: {remain = RemainHint3Label; break;}
		case 2: {remain = RemainHint2Label; break;}
		case 1: {remain = RemainHint1Label; break;}
		case 0: {remain = RemainHint0Label; break;}
		}
		return remain;
	}

	
}
