package view.buttonsGUI;

import java.util.ArrayList;

import javax.swing.JLabel;

import clientChat.gameUserList;

public class userNames extends Thread {
	public static ArrayList<String> gameUserName;
	JLabel ch1Name, ch2Name, ch3Name, ch4Name;
	String player1, player2, player3, player4;

	public userNames(JLabel ch1Name, JLabel ch2Name, JLabel ch3Name, JLabel ch4Name) {
		this.ch1Name = ch1Name;
		this.ch2Name = ch2Name;
		this.ch3Name = ch3Name;
		this.ch4Name = ch4Name;
		start();
	}
	
	@Override
	public void run() {
		while(true) {
			gameUserName = gameUserList.gameUserName;
			
			switch(gameUserName.size()) {
			case 1:
				player1 = gameUserName.get(0);
				ch1Name.setText(player1);
				break;
			case 2:
				player1 = gameUserName.get(0);
				player2 = gameUserName.get(1);
				ch1Name.setText(player1);
				ch2Name.setText(player2);
				break;
			case 3:
				player1 = gameUserName.get(0);
				player2 = gameUserName.get(1);
				player3 = gameUserName.get(2);
				ch1Name.setText(player1);
				ch2Name.setText(player2);
				ch3Name.setText(player3);
				break;
			case 4:
				player1 = gameUserName.get(0);
				player2 = gameUserName.get(1);
				player3 = gameUserName.get(2);
				player4 = gameUserName.get(3);
				
				ch1Name.setText(player1);
				ch2Name.setText(player2);
				ch3Name.setText(player3);
				ch4Name.setText(player4);
				break;
			}
		}
	}
}
