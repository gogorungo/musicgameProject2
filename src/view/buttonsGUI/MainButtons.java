package view.buttonsGUI;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clientChat.gameClient;
import main.Main;
import model.CountDown;
import view.MainFrame;
import view.sounds.MusicBackGround;

public class MainButtons extends JFrame{
	public static JFrame CountDownFrame = new JFrame();
	Container c = getContentPane();
	
	public static void AddMainButtons(JFrame jFrame) {
		ImageIcon PlayBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayBtn.png"));
		ImageIcon PlayBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayBtnMouseOver.png"));
		ImageIcon QuitBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/QuitBtn.png"));
		ImageIcon QuitBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/QuitBtnMouseOver.png"));
		ImageIcon Single1Btn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single1Btn.png"));
		ImageIcon Single1BtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single1BtnMouseOver.png"));
		ImageIcon Single5Btn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single5Btn.png"));
		ImageIcon Single5BtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single5BtnMouseOver.png"));
		ImageIcon Single10Btn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single10Btn.png"));
		ImageIcon Single10BtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Single10BtnMouseOver.png"));
		ImageIcon MultiBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/MultiBtn.png"));
		ImageIcon MultiBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/MultiBtnMouseOver.png"));
		
		JButton playButton = new JButton(PlayBtn);
		JButton QuitButton = new JButton(QuitBtn);
		JButton Single1Button = new JButton(Single1Btn);
		JButton Single5Button = new JButton(Single5Btn);
		JButton Single10Button = new JButton(Single10Btn);
		JButton MultiButton = new JButton(MultiBtn);
		
		playButton.setBounds(240, 500, 400, 204);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		playButton.setFocusPainted(false);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				playButton.setVisible(false);
				QuitButton.setVisible(false);
				jFrame.add(Single1Button);
				jFrame.add(Single5Button);
				jFrame.add(Single10Button);
				jFrame.add(MultiButton);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setIcon(PlayBtnMouseOver);
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setIcon(PlayBtn);
				playButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jFrame.add(playButton);

		QuitButton.setBounds(660, 500, 400, 204);
		QuitButton.setBorderPainted(false);
		QuitButton.setContentAreaFilled(false);
		QuitButton.setFocusPainted(false);
		QuitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				QuitButton.setIcon(QuitBtnMouseOver);
				QuitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				QuitButton.setIcon(QuitBtn);
				QuitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jFrame.add(QuitButton);
		

		Single1Button.setBounds(200, 250, 400, 204);
		Single1Button.setBorderPainted(false);
		Single1Button.setContentAreaFilled(false);
		Single1Button.setFocusPainted(false);
		Single1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 3초 후, 싱글 1초로 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,1);
				Thread thcom = new Thread(com);
				thcom.start();
				CountDownFrame.add(com);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Single1Button.setIcon(Single1BtnMouseOver);
				Single1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Single1Button.setIcon(Single1Btn);
				Single1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		Single5Button.setBounds(650, 250, 400, 204);
		Single5Button.setBorderPainted(false);
		Single5Button.setContentAreaFilled(false);
		Single5Button.setFocusPainted(false);
		Single5Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 싱글 5초로 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,5);
				Thread thcom = new Thread(com);
				thcom.start();
				CountDownFrame.add(com);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Single5Button.setIcon(Single5BtnMouseOver);
				Single5Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Single5Button.setIcon(Single5Btn);
				Single5Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		Single10Button.setBounds(200, 504, 400, 204);
		Single10Button.setBorderPainted(false);
		Single10Button.setContentAreaFilled(false);
		Single10Button.setFocusPainted(false);
		Single10Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 싱글 10초로 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,10);
				Thread thcom = new Thread(com);
				thcom.start();
				CountDownFrame.add(com);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Single10Button.setIcon(Single10BtnMouseOver);
				Single10Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Single10Button.setIcon(Single10Btn);
				Single10Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		MultiButton.setBounds(650, 504, 400, 204);
		MultiButton.setBorderPainted(false);
		MultiButton.setContentAreaFilled(false);
		MultiButton.setFocusPainted(false);
		MultiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				// 멀티 음악맞추기 게임 시작
				MainFrame.introMusic.close();
				CountDown com = new CountDown(3,111);
				Thread thcom = new Thread(com);
				thcom.start();
				CountDownFrame.add(com);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				MultiButton.setIcon(MultiBtnMouseOver);
				MultiButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				MultiButton.setIcon(MultiBtn);
				MultiButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}
}
