package music;

import java.io.FileReader;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONMusicParser { // singleTon 형태로 변경
	JSONArray musicInfoArray;

	public JSONMusicParser() {

	}

	public synchronized JSONArray getJsonArray(String path) {
		JSONArray jsonArray = null;
		try {
			JSONParser jsonParser = new JSONParser();
			Reader reader = null;
			reader = new FileReader(path);
			JSONObject jsonObject;
			jsonObject = (JSONObject) jsonParser.parse(reader);
			jsonArray = (JSONArray) jsonObject.get("songs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

}