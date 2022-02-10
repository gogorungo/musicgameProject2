package User;

public class MusicInfo {
//제이슨 데이터를 받아서
	//음악 제목 패스 힌트
	//서버에서 제이슨 파일 받아서 어레이에 넣으면
	private String ip;
	private String song;
	private String singer;
	private String path;
	private String songHint;
	private String singerHint;
	
	public MusicInfo(String ip,String song,String singer,String path,String songHint,String singerHint) {
		this.ip=ip;
		this.song=song;
		this.singer=singer;
		this.path=path;
		this.songHint=songHint;
		this.singerHint=singerHint;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
		return "MusicInfo [ip=" + ip + ", song=" + song + ", singer=" + singer + ", path=" + path + ", songHint="
				+ songHint + ", singerHint=" + singerHint + "]";
	}
	
}
