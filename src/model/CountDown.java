package model;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import view.MultiGameFrame;
import view.SingleGameFrame;
import view.buttonsGUI.MainButtons;

public class CountDown extends JLabel implements Runnable {
	JFrame frameC = new JFrame();
	JLabel frameL = new JLabel();
	int sc, n;

	public CountDown(int sc, int n) {
		frameC.setLayout(new FlowLayout());
		frameC.setBounds(100, 100, 300, 300);
		frameC.add(frameL);
		frameC.setVisible(true);
		this.sc = sc;
		this.n = n;
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (sc != 3) {
					Thread.sleep(1000); // 1초
				 }
			 }catch (Exception e) {
				 e.printStackTrace();
			   }
			
			if (sc > 0) {
				frameL.setText(sc + "초후에 시작합니다.\n준비하세요");
				sc--;
			} else {
				try {
					if(n==1) {
						new SingleGameFrame(1);
					} else if(n==5) {
						new SingleGameFrame(5);
					} else if(n==10) {
						new SingleGameFrame(10);
					} else {
						new MultiGameFrame();
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameC.setVisible(false);
				MainButtons.CountDownFrame.setVisible(false);
				return;
			  }
        }
	
	}
}
