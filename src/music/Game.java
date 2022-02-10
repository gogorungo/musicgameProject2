package music;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

import clientChat.gameClient;
import view.buttonsGUI.MultiGameButtons;

public class Game extends Thread {
	private static BufferedWriter bw = gameClient.getBw();
	MusicInfo musicInfo;
	String songInfo, answer;
	int grade = 0; // 점수
	public static boolean flag = true;

	public Game(MusicInfo musicInfo) {
		this.musicInfo = musicInfo;
		System.out.println(musicInfo.song);
//		musicPlayer.musicStart(musicInfo);
//		gameStart();
		start();

	}

//	public void gameStart() {
	@Override
	public void run() {
//		flag = true;
		while (flag) {
			answer = MultiGameButtons.getAnswer();
			songInfo = musicInfo.song.trim();
			if(songInfo.equalsIgnoreCase(answer)) {
				try {
					bw.write("next"+"\n");
					bw.flush();
				} catch (IOException e) {
					if(bw != null) {
						try {
							bw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					e.printStackTrace();
				}
				grade++; // 점수
				flag = false; // 반복 스레드 종료
				
			}
		}
	}
}
