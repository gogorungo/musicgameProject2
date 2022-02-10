package view.sounds;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import main.Main;


// 배경음악 재생 쓰레드 클래스
// 받아온거 따로 수정안함
public class MusicBackGround extends Thread{
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public MusicBackGround(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource(name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if (player == null) 
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
