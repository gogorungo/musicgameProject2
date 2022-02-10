package model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import User.MusicInfo;

public class MusicList {
	public static ArrayList musiclist() throws IOException {
		JSONArray musicInfoArray = null;
		ArrayList<MusicInfo> musicInfo = null;
		try {
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader("../LineNo5/src/model/song_json_data.json");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			musicInfoArray = (JSONArray) jsonObject.get("songs");
			musicInfo = new ArrayList<>();

			for (int i = 0; i < musicInfoArray.size(); i++) {
				JSONObject musicObject = (JSONObject) musicInfoArray.get(i);
				String ip = musicObject.get("ip").toString();
				String song = musicObject.get("song").toString();
				String singer = musicObject.get("singer").toString();
				String path = musicObject.get("path").toString();
				String songHint = musicObject.get("songHint").toString();
				String singerHint = musicObject.get("singerHint").toString();

				musicInfo.add(new MusicInfo(ip, song, singer, path, songHint, singerHint));
			}
			System.out.println(musicInfo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return musicInfo;

	}
}
