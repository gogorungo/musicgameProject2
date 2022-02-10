package serverChat;

import java.util.ArrayList;

public class songRandom {
	public static ArrayList<String> songRandomIntList = new ArrayList<String>();
	String randomNum;
	public songRandom() {
		while (songRandomIntList.size() != 10) {
			int i = songRandomIntList.size();
			int randomInt = (int) (Math.random() * 30);
			String stringNum = Integer.toString(randomInt); // 문자열로
			if (!songRandomIntList.contains(stringNum)) { // 중복제거
				songRandomIntList.add(stringNum);
				if(randomNum == null) { // 첫칸
					randomNum = "songRandom "+stringNum+"-";
				}
				else {
					randomNum = randomNum.concat(stringNum+"-"); // 두번째부터 문자열 통합
				}
			}
		}
		randomNum = randomNum+"\n";
		new broadcast(randomNum);
	}

}