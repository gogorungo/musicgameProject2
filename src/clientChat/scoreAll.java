package clientChat;

import java.util.HashMap;
import java.util.StringTokenizer;

public class scoreAll {
	public static HashMap<String, Integer> userScore = new HashMap<String, Integer>();
	StringTokenizer StringTZ;
	
	public scoreAll(String serverMsg) {
		serverMsg = serverMsg.substring(5);
		StringTZ = new StringTokenizer(serverMsg,"-");
		
		while(StringTZ.hasMoreTokens()) {
			String token1 = StringTZ.nextToken(); // 문자 쪼개기
			String token2 = StringTZ.nextToken();
			int intToken = Integer.valueOf(token2); // 숫자로 변경
			userScore.put(token1, intToken);
			System.out.println(token1 + " " + intToken);
		}
	}
	
}
