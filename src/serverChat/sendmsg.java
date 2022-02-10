package serverChat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class sendmsg {
	
	HashMap<String, gameUser> user = gameServer.getUser();
	
	
	public sendmsg(String msg, String userId) {
		BufferedWriter bw;
		// 전송 받는 사람의 아이디 찾기
		int startId = msg.indexOf(" ")+1; // 아이디 시작 지점
		int endId = msg.indexOf(" ",startId); // 아이디 끝 지점
		if(endId != -1) {
			String toId = msg.substring(startId,endId); // 받을 사람의 아이디
			String realMsg = msg.substring(endId+1); // 아이디를 떼어내고 남은 메시지
			if(user.containsKey(toId)) { // 해당 유저가 존재할 경우
				try {
					bw = user.get(toId).getBw(); // 받는이에게 전달
					bw.write(userId + "님의 귓속말 : "+realMsg+"\n");
					bw.flush();
					
					bw = user.get(userId).getBw(); // 보낸이에게 에코
					bw.write(userId + "님의 귓속말 : "+realMsg+"\n");
					bw.flush();
					
					System.out.println(userId + "님의 귓속말 : "+realMsg); // 서버도 내용 확인
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else { // 해당 유저가 존재하지 않을 시
				try {
					bw = user.get(userId).getBw();
					bw.write("해당 유저가 존재하지 않습니다!\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else { // 명령어를 잘못 입력했을 시
			try {
				bw = user.get(userId).getBw();
				bw.write("잘못 입력하셨습니다\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
