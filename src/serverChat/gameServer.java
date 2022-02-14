package serverChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class gameServer extends Thread {
	// 유저 정보를 담을 해쉬맵
	private static HashMap<String, gameUser> user = new HashMap<String, gameUser>();
	private ServerSocket listener;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private Scanner scan;
	public static int readyCount;
	
	public gameServer() {
		// 포트 준비하고 대기
		try {
			listener = new ServerSocket(8888); // 포트 8500
			System.out.println("서버 접속 대기중!");
			// 접속자 승인 및 유저 등록
			this.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static HashMap<String, gameUser> getUser(){
		return user;
	}

	
	// 접속한 유저를 관리하기 위한 쓰레드
	@Override
	public void run() {
		String userId = null;
		while(true) {
			try {
				// 접속한 유저가 있을 시 소켓을 잇고 br과 bw 연결
				socket = listener.accept();
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				scan = new Scanner(System.in);

				// 유저 아이디 입력
				userId = br.readLine();

				// 서버의 해시맵으로 전달
				synchronized (user) {
					user.put(userId, new gameUser(socket, br, bw));

				}
				new userList();
				
				// 서버에 출력. 전체 출력
				new broadcast("[공지] : " + userId + "님이 입장하셨습니다123 \n");
				
				new broadcast(userList.userList + "\n");
				
				//유저가 입력하는 메세지 받는 곳
				new inputMsg(userId, br).start();
				
				
			} catch (IOException e) {
				//클라이언트 접속이 끊어질 시 전체 메세지
				new broadcast("[공지] : "+ userId + "님이 나가셨습니다 \n");
				

				
				// 소켓 접속이 끊길 시 close()를 해줘서 예외 차단
				if(socket != null)
					try {
						scan.close();
						bw.close();
						br.close();
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}
	}
	public static void main(String[] args) {
		new gameServer();
	}
	
}
