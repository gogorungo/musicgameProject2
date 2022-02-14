package serverChat;

import java.util.HashMap;
import java.util.Iterator;

public class userList {
	private HashMap<String, gameUser> userNamesAll;
	public static String userList = "userList-";
	
	public userList() {
		userNamesAll = gameServer.getUser();

		Iterator<String> keys = userNamesAll.keySet().iterator();
		while(keys.hasNext()) {
			userList = userList + keys.next() + "-";
		}

	}
	
}
