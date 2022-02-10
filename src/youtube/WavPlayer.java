package youtube;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.*;

public class WavPlayer {
	static Random random = new Random();
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		ReadTxt readtxt = new ReadTxt();
		Scanner scanner = new Scanner(System.in);
		String dir = "C:/Users/Minhyeok/Desktop/Git/LineNo5/python_MH/audio/";
		int N = random.nextInt(readtxt.links.size()-1);
		String number = Integer.toString(N);
		String filename = dir + number+".wav";
		File file = new File(filename);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		String response = "";
		while(!response.equals("Q")) {
			System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
			System.out.print("Enter yout choice: ");
			response = scanner.next();
			response = response.toUpperCase();
			switch (response) {
			case ("P"): clip.start();
			System.out.println("재생곡 : "+readtxt.names.get(N+1));
			break;
			case ("S"): clip.stop();
			break;
			case ("R"): clip.setMicrosecondPosition(0);
			break;
			case ("Q"): clip.close();
			break;
			default : System.out.println("Not a valid response");
			}
		}
		System.out.println("BYE");
	}
}
