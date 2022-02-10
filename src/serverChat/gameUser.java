package serverChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public class gameUser {
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private int score = 0;
		
	public gameUser() {	}
	
	public gameUser(Socket socket, BufferedReader br, BufferedWriter bw) {
		this.socket = socket;
		this.br = br;
		this.bw = bw;
	}
	
//	public gameUser(int score) {
//		this.score = score;
//	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score += score;
		System.out.println(this.score); // 점수확인용
	}

	public Socket getSocket() {
		return socket;
	}

	public BufferedReader getBr() {
		return br;
	}

	public BufferedWriter getBw() {
		return bw;
	}
	
	
	
}
