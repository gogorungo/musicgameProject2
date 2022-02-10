package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import youtube.ReadTxt;
import youtube.Wav;

public class ServerMain {
	public static final String fileNm = null;
	static Random random = new Random();
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        Wav wav = new Wav();
        try {
        	serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			//클라이언트와의 연결 대기 루프
			while( true ){
				System.out.println("새로운 클라이언트의 연결요청을 기다립니다.");
				// 연결되면 통신용 소켓 생성
				socket = serverSocket.accept();
				System.out.println("클라이언트와 연결되었습니다.");
				//new SendSingleGame(1, socket);
				// 파일 전송용 클래스
				// String filePath = "C:/Users/Minhyeok/Desktop/Git/LineNo5/python_MH/audio";
				// String fileNm = wav.sendname;
				// server.FileSender fs = new server.FileSender(socket, filePath, fileNm);
				// fs.start();
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
