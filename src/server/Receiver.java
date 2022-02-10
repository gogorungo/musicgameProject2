package server;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
    Socket socket;
    DataInputStream dis = null;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    public Receiver(Socket socket) {
        this.socket = socket;
    }
    //@Override
    public void run() {
    	try {
    		dis = new DataInputStream(socket.getInputStream());
    		String type = dis.readUTF();
    		if(type.equals("file")){
        		//전송된 파일 쓰기!
    			String result = fileWrite(dis);
    	    	System.out.println("result : " + result);
    		}	
		} catch (IOException e) {
	    	System.out.println("run() Fail!");
			e.printStackTrace();
		}
    }
    
    private String fileWrite(DataInputStream dis){
    	String result;
    	String filePath = "C:/Client";
    	 
        try {
            System.out.println("파일 수신 작업을 시작합니다.");
 
            // 파일명을 전송 받고 파일명 수정
            String fileNm = dis.readUTF();
            System.out.println("파일명 " + fileNm + "을 전송받았습니다.");
 
            // 파일을 생성하고 파일에 대한 출력 스트림 생성
            File file = new File(filePath + "/" + fileNm);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            System.out.println(fileNm + "파일을 생성하였습니다.");
 
            // 바이트 데이터를 전송받으면서 기록
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            while ((len = dis.read(data)) != -1) {
                bos.write(data, 0, len);
            }
            
            //bos.flush();
            result = "SUCCESS";
            
            System.out.println("파일 수신 작업을 완료하였습니다.");
            System.out.println("받은 파일 사이즈 : " + file.length());
        } catch (IOException e) {
            e.printStackTrace();
            result = "ERROR";
        }finally{
            try { bos.close(); } catch (IOException e) { e.printStackTrace(); }
            try { fos.close(); } catch (IOException e) { e.printStackTrace(); }
            try { dis.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    	
        return result;
    }
    
}
