package serverChat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class broadcast {
	HashMap<String, gameUser> user = gameServer.getUser();
	
	// 모든 유저에게 메세지 발송
	public broadcast(String msg) {
		Iterator<String> keys = user.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			gameUser gameuser = user.get(key);
			BufferedWriter bw = gameuser.getBw();
			try {
				bw.write(msg);
				bw.flush();
			} catch (IOException e) {
				if(bw != null)
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}	
		}
		//서버도 메세지 확인
		System.out.print(msg);
	}	
}
