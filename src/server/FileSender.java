package server;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

//파일 전송용 클래스
public class FileSender extends Thread {

	String filePath;
	String fileNm;
	Socket socket;
	DataOutputStream dos;
	FileInputStream fis;
	BufferedInputStream bis;

	public FileSender(Socket socket, String filePath, String fileNm) {

		this.socket = socket;
		this.fileNm = fileNm;
		this.filePath = filePath;

		try {
			// 데이터 전송용 스트림 생성
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @Override
	public void run() {
		try {
			// 파일전송을 서버에 알린다.('file' 구분자 전송)
			dos.writeUTF("file");
			dos.flush();

			// 전송할 파일을 읽어서 Socket Server에 전송
			String result = fileRead(dos);
			System.out.println("result : " + result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private String fileRead(DataOutputStream dos) {
		String result;
		try {
			dos.writeUTF(fileNm);
			System.out.println("파일 이름(" + fileNm + ")을 전송하였습니다.");

			// 파일을 읽어서 서버에 전송
			File file = new File(filePath + "/" + fileNm);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);

			int len;
			int size = 4096;
			byte[] data = new byte[size];
			while ((len = bis.read(data)) != -1) {
				dos.write(data, 0, len);
			}

			// 서버에 전송
			dos.flush();
			result = "SUCCESS";
		} catch (IOException e) {
			e.printStackTrace();
			result = "ERROR";
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
