package clientChat;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class gameUserList {
	StringTokenizer StringTZ;
	public static ArrayList<String> gameUserName = new ArrayList<String>();
	
	public gameUserList(String serverMsg) {
		serverMsg = serverMsg.substring(9);
		StringTZ = new StringTokenizer(serverMsg,"-");
		while(StringTZ.hasMoreTokens()) {
			String token = StringTZ.nextToken();
			gameUserName.add(token);
		}
		System.out.println(gameUserName.toString());
	}

}
