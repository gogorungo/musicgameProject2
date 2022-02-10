package music;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import clientChat.gameClient;
import clientChat.gameClientReadMsg;
import view.buttonsGUI.MultiGameButtons;

public class MusicPlayer extends Thread {
	public static String musicjsonpath = "src\\music\\song_json_data.json";
	MusicInfo musicPath;
	ArrayList<MusicInfo> listInfo = new ArrayList<>();
	ArrayList<Integer> songRandomIntList = gameClientReadMsg.serverSongRandom;
	public static int num = 0;
	public static boolean flagIf = true;

	public MusicPlayer() {
		listInfo = initializeMusic();
		start();
	}
	
	
	@Override
	public void run() {
		while(num<10) {
			System.out.println(num + "   " + flagIf);
			if(flagIf) {
				System.out.println(num+"번 문제!");
				getMusicListInfo().get(songRandomIntList.get(num));
				musicPath = getMusicListInfo().get(songRandomIntList.get(num));
				musicStart(musicPath);
				new Game(musicPath);
				flagIf = false;
			}
		}
		// 숫자 10개 돌면 게임 끝
		System.out.println("게임 끝");

	}

	public synchronized ArrayList<MusicInfo> initializeMusic() {
		JSONMusicParser parser = new JSONMusicParser();
		JSONArray array = parser.getJsonArray(musicjsonpath);
		ArrayList<MusicInfo> musicInfo = new ArrayList<MusicInfo>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject musicObject = (JSONObject) array.get(i);
			String url = musicObject.get("url").toString();
			String song = musicObject.get("song").toString();
			String singer = musicObject.get("singer").toString();
			String path = musicObject.get("path").toString();
			String songHint = musicObject.get("songHint").toString();
			String singerHint = musicObject.get("singerHint").toString();
			musicInfo.add(new MusicInfo(url, song, singer, path, songHint, singerHint));
		}
		return musicInfo;
	}

	public ArrayList<MusicInfo> getMusicListInfo() {
		if (listInfo == null) {
			listInfo = initializeMusic();
		}
		return listInfo;
	}

//	public void restartMusic() {
//		songRandomIntList.clear();
//	}
	
	public void musicStart(MusicInfo musicPath) {
		File musicFile = new File(musicPath.path);
		try {
			AudioInputStream b = AudioSystem.getAudioInputStream(musicFile);
			Clip c = AudioSystem.getClip();
			c.open(b);
			c.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}