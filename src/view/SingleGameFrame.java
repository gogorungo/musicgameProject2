package view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.CountDown;
import main.Main;
import model.PlayWav;
import view.buttonsGUI.SingleGameButtons;
import view.countGUI.NextCount;
import view.menuGUI.MenuBar;

public class SingleGameFrame extends JFrame{
	public static int num;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("/view/playBackground.jpg")).getImage();
	
	int HintCount, NextCount, Timer;

	public SingleGameFrame(int num) throws IOException {
		this.num = num;
		Default.DefaultFrame(this, 1200, 700); // 프레임 디폴트
		MenuBar.GameMenubar(this); // 상단 메뉴바 추가 메소드
		SingleGameButtons.AddSingleGameButtons(this); // 싱글 게임 버튼 추가 메소드
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(1200, 900);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	
	public static void playMusic(int Num) {
		try {
			if(num == 1) {
				new PlayWav("../LineNo5/python_MH/audio/OneSecond/", Num);
			} else if(num == 5) {
				new PlayWav("../LineNo5/python_MH/audio/FiveSecond/", Num);
			} else if(num == 10) {
				new PlayWav("../LineNo5/python_MH/audio/TenSecond/", Num);
			}
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}
	}
}
