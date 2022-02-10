package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.Main;
import view.buttonsGUI.MainButtons;
import view.countGUI.HintCount;
import view.menuGUI.MenuBar;
import view.sounds.MusicBackGround;

import java.awt.event.*;

public class MainFrame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("/view/introBackground.jpg")).getImage();
	// 메인 배경음
	public static MusicBackGround introMusic = new MusicBackGround("/view/sounds/introMusic.mp3", true);

	public MainFrame() {
		Default.DefaultFrame(this, 1280, 700); // 프레임 디폴트
		MenuBar.MainMenuBar(this); // 상단 메뉴바 추가 메소드

		// 배경음악 재생
		introMusic.start();
		
		// 메인 버튼 추가 메소드
		MainButtons.AddMainButtons(this);
		
	}

	public void paint(Graphics g) {
		screenImage = createImage(1280, 700);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

}
