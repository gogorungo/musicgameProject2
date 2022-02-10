package youtube;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Wav {
	static Random random = new Random();
	public String sendname ="";
	public Wav() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		ReadTxt readtxt = new ReadTxt();
		String dir = "C:/Users/Minhyeok/Desktop/Git/LineNo5/python_MH/audio/";
		int N = random.nextInt(readtxt.links.size()-1);
		String number = Integer.toString(N);
		String filename = dir + number+".wav";
		sendname = number+".wav";
		File file = new File(filename);
		//AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		//Clip clip = AudioSystem.getClip();
		//clip.open(audioStream);
		//clip.start();
	}
}
