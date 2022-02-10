package view.countGUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.Main;

public class NextCount {
	public static ImageIcon RemainNext5 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainNext5.png"));
	public static JLabel RemainNext5Label = new JLabel(RemainNext5);
	public static ImageIcon RemainNext4 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainNext4.png"));
	public static JLabel RemainNext4Label = new JLabel(RemainNext4);
	public static ImageIcon RemainNext3 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainNext3.png"));
	public static JLabel RemainNext3Label = new JLabel(RemainNext3);
	public static ImageIcon RemainNext2 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainNext2.png"));
	public static JLabel RemainNext2Label = new JLabel(RemainNext2);
	public static ImageIcon RemainNext1 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainNext1.png"));
	public static JLabel RemainNext1Label = new JLabel(RemainNext1);
	public static ImageIcon RemainNext0 = new ImageIcon(
			Main.class.getResource("/view/countGUI/RemainNext0.png"));
	public static JLabel RemainNext0Label = new JLabel(RemainNext0);
	int count;
	
	public NextCount() {
		this.count = 5;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}



	public JLabel Remain() {
		RemainNext5Label.setBounds(880, 480, 300, 86);
		RemainNext4Label.setBounds(880, 480, 300, 86);
		RemainNext3Label.setBounds(880, 480, 300, 86);
		RemainNext2Label.setBounds(880, 480, 300, 86);
		RemainNext1Label.setBounds(880, 480, 300, 86);
		RemainNext0Label.setBounds(880, 480, 300, 86);
		JLabel remain = null;
		switch (count) {
		case 5: {remain = RemainNext5Label; break;}
		case 4: {remain = RemainNext4Label; break;}
		case 3: {remain = RemainNext3Label; break;}
		case 2: {remain = RemainNext2Label; break;}
		case 1: {remain = RemainNext1Label; break;}
		case 0: {remain = RemainNext0Label; break;}
		}
		return remain;
	}


}
