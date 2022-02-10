package music;

public class MusicInfo {
	String url;
	String song;
	String singer;
	String path;
	String songHint;
	String singerHint;

	public MusicInfo(String url, String song, String singer, String path, String songHint, String singerHint) {
		this.url = url;
		this.song = song;
		this.singer = singer;
		this.path = path;
		this.songHint = songHint;
		this.singerHint = singerHint;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSongHint() {
		return songHint;
	}

	public void setSongHint(String songHint) {
		this.songHint = songHint;
	}

	public String getSingerHint() {
		return singerHint;
	}

	public void setSingerHint(String singerHint) {
		this.singerHint = singerHint;
	}

	@Override
	public String toString() {
		return url + ", " + song + ", " + singer + ", " + path + ", "
				+ songHint + ", " + singerHint;
	}

}
