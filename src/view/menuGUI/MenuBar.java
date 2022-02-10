package view.menuGUI;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import main.Main;
import view.MainFrame;
import view.buttonsGUI.SingleGameButtons;
import view.countGUI.NextCount;
import view.sounds.MusicBackGround;

public class MenuBar extends JFrame{
	
	public static int mouseX, mouseY;
	
	public static void GameMenubar(JFrame jframe) {
		ImageIcon ExitBtn = new ImageIcon(Main.class.getResource("/view/menuGUI/ExitButton.png"));
		ImageIcon ExitBtnMouseOver = new ImageIcon(Main.class.getResource("/view/menuGUI/ExitButtonMouseOver.png"));
		JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("/view/menuGUI/MenuBar.png")));
		JButton exitButton = new JButton(ExitBtn);
		
		exitButton.setBounds(1160, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				jframe.dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(ExitBtnMouseOver);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(ExitBtn);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jframe.add(exitButton);

		menuBar.setBounds(0, 0, 1200, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				jframe.setLocation(x - mouseX, y - mouseY);
			}
		});
		jframe.add(menuBar);
	}
	
	
	public static void MainMenuBar(JFrame jframe) {
		ImageIcon ExitBtn = new ImageIcon(Main.class.getResource("/view/menuGUI/ExitButton.png"));
		ImageIcon ExitBtnMouseOver = new ImageIcon(Main.class.getResource("/view/menuGUI/ExitButtonMouseOver.png"));
		JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("/view/menuGUI/MenuBar.png")));
		JButton exitButton = new JButton(ExitBtn);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
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
				exitButton.setIcon(ExitBtnMouseOver);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(ExitBtn);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		jframe.add(exitButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				jframe.setLocation(x - mouseX, y - mouseY);
			}
		});
		jframe.add(menuBar);
	}
}
