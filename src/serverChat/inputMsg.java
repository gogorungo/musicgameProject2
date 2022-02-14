package serverChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import music.MusicPlayer;

public class inputMsg extends Thread {
	private final String next = "next"; // 정답을 맞췄을 시 발송해주는 암호
	private final String sendMsg = "/to"; // 귓속말 명령어
	private HashMap<String, gameUser> user = gameServer.getUser();
	private BufferedReader br;
	private String userId, msg;
	int count = 0;
	boolean flag = true;

	public inputMsg(String userId, BufferedReader br) {
		this.userId = userId;
		this.br = br;
	}

	@Override
	public void run() {

		while (flag) {
			try {
				msg = br.readLine();
				if (msg != null) {
					if (msg.indexOf(sendMsg) == 0) { // 귓속말
						new sendmsg(msg, userId);
						
					} else if (msg.equals(next)) {
						// 다른 사람이 정답을 맞추면 모두에게 다음 문제로 넘어가라고 명령함
						
						if(count < 9) {
							user.get(userId).setScore(1); // 1점증가
							new broadcast(userId + "님 정답! 다음 문제로 넘어갑니다 \n");
	
							new broadcast("next"+"\n");
							
							count++;
						}
						else if(count == 9) { // 마지막문제는 다음문제 코드를 보내지 않는다
							user.get(userId).setScore(1); 
							//결과창으로 이동 코드
							new userScore();
							new broadcast("clear"+"\n");
						}
						
						
					} else if (msg.equals("ready+1")) {
						gameServer.readyCount++; // 레디 시 readyCount +1
						if (gameServer.readyCount == user.size()) {
							// gameServer.readyCount>1 && // 끝나고 추가할 것. 2명 이상일때만 시작
							new songRandom();
							new broadcast("readybutton"+"\n");
							new broadcast("start"+"\n");
						}
					} else if (msg.equals("ready-1")) {
						gameServer.readyCount--; // 레디 취소 시 readyCount -1
						
					} else { // 채팅이라면 채팅발송
						new broadcast(userId + " >>> " + msg + "\n");
					}
				}
			} catch (IOException e) {
				new broadcast("[공지] : "+ userId + "님이 나가셨습니다 \n");
				
				user.remove(userId); // 유저가 접속이 끊길 시 해시맵에서 삭제
				flag = false;
				
				if (br != null)
					try {
						br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		}
	}
}
