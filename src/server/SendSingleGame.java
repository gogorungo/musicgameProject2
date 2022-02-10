package server;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import model.ReadTxt;

public class SendSingleGame {
	private String filePathOne = "../LineNo5/python_MH/audio/OneSecond";
	private String filePathFive = "../LineNo5/python_MH/audio/FiveSecond";
	private String filePathTen = "../LineNo5/python_MH/audio/TenSecond";
	private int num;
	private String filePath = "";

	public SendSingleGame(int num, Socket socket) {
		this.num = num;
		if(num == 1) {filePath = filePathOne;}
		else if(num == 5) {filePath = filePathFive;}
		else if(num == 10) {filePath = filePathTen;}
		ReadTxt readtxt;
		try {
			readtxt = new ReadTxt();
			int N = readtxt.links.size() - 1;
			for (int i = 0; i < N; i++) {
				String number = Integer.toString(i);
				String filename =  "/"+ i + ".wav";
				// 파일 전송용 클래스
				server.FileSender fs = new server.FileSender(socket, filePath, filename);
				fs.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
