package server;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import youtube.ReadTxt;

public class MusicOne {
	public MusicOne() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		String path = "C:/Client/";		
		File dir = new File(path);
		File[] fileList = dir.listFiles();
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileList[0]);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
}
