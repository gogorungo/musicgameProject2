package view.buttonsGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clientChat.gameClient;
import main.Main;
import view.MultiGameFrame;
import view.sounds.MusicBackGround;

public class MultiGameButtons extends JFrame {
	private static BufferedWriter bw = gameClient.getBw();	
	private static String readChatting;
	private static String answer;
	public static JTextArea display;
	public static Font displayFont;
	public static JScrollPane scroll;
	public static ImageIcon ReadyBtn;
	public static ImageIcon ReadyBtnMouseOver;
	public static ImageIcon ReadyBtnOn;
	public static JButton ReadyButton;
	public static boolean flag;
	
	public static void setReadChatting(String readChatting) { // 채팅창이 자꾸 위로 올라가서 사용
		MultiGameButtons.readChatting = readChatting;
	}

	
	public static String getReadChatting() {
		return readChatting;
	}
	
	public static String getAnswer() {
		return answer;
	}
	
	public static void AddMultiGameButtons(JFrame jFrame) {
		
		ImageIcon PlayMusicBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtn.png"));
		ImageIcon PlayMusicBtnMouseOver = new ImageIcon(
				Main.class.getResource("/view/buttonsGUI/PlayMusicBtnMouseOver.png"));
		JButton PlayMusicButton = new JButton(PlayMusicBtn);

		ImageIcon character1 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character1.png"));
		JLabel Ch1 = new JLabel(character1);
		ImageIcon character2 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character2.png"));
		JLabel Ch2 = new JLabel(character2);
		ImageIcon character3 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character3.png"));
		JLabel Ch3 = new JLabel(character3);
		ImageIcon character4 = new ImageIcon(Main.class.getResource("/view/charactersGUI/character4.png"));
		JLabel Ch4 = new JLabel(character4);

//		ImageIcon ReadyBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Readybutton.png"));
//		ImageIcon ReadyBtnMouseOver = new ImageIcon(
//				Main.class.getResource("/view/buttonsGUI/ReadybuttonMouseOver.png"));
//		ImageIcon ReadyBtnOn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/ReadybuttonOn.png"));
//		JButton ReadyButton = new JButton(ReadyBtn);

		JLabel Ch1Name = new JLabel();
		JLabel Ch2Name = new JLabel();
		JLabel Ch3Name = new JLabel();
		JLabel Ch4Name = new JLabel();

		JTextField Enter = new JTextField("", 10);
		Enter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					getMsg(Enter.getText());
					Enter.setText("");
					Enter.requestFocus();
				}
			}
		});

		PlayMusicButton.setBounds(80, 60, 120, 120);
		PlayMusicButton.setBorderPainted(false);
		PlayMusicButton.setContentAreaFilled(false);
		PlayMusicButton.setFocusPainted(false);
		PlayMusicButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				MultiGameFrame.playMusic();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				PlayMusicButton.setIcon(PlayMusicBtnMouseOver);
				PlayMusicButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				PlayMusicButton.setIcon(PlayMusicBtn);
				PlayMusicButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		readyButton();
		
//		ReadyButton.setBounds(210, 50, 300, 153);
//		ReadyButton.setBorderPainted(false);
//		ReadyButton.setContentAreaFilled(false);
//		ReadyButton.setFocusPainted(false);
//		ReadyButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
//				buttonSound.start();
//				if (ReadyButton.getIcon() != ReadyBtnOn) {
//					ReadyButton.setIcon(ReadyBtnOn);
//					try {
//						bw.write("ready+1"+"\n"); // 레디 누를시 +1
//						bw.flush();
//					} catch (IOException e1) {
//						try {
//							bw.close();
//						} catch (IOException e2) {
//							// TODO Auto-generated catch block
//							e2.printStackTrace();
//						}
//						e1.printStackTrace();
//					}
//				} else if (ReadyButton.getIcon() == ReadyBtnOn) {
//					ReadyButton.setIcon(ReadyBtn);
//					try {
//						bw.write("ready-1"+"\n"); // 레디 취소할 시 -1
//						bw.flush();
//					} catch (IOException e1) {
//						try {
//							bw.close();
//						} catch (IOException e2) {
//							// TODO Auto-generated catch block
//							e2.printStackTrace();
//						}
//						e1.printStackTrace();
//					}
//					
//				}
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				if (ReadyButton.getIcon() != ReadyBtnOn) {
//					ReadyButton.setIcon(ReadyBtn);
//					ReadyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//				}
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				if (ReadyButton.getIcon() != ReadyBtnOn) {
//					ReadyButton.setIcon(ReadyBtnMouseOver);
//					ReadyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//				}
//			}
//		});

		Ch1.setBounds(150, 430, 165, 230);
		Ch1Name.setText("첫번째 플레이어");
		Ch1Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch1Name.setOpaque(true); // Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch1Name.setBackground(Color.WHITE);
		Ch1Name.setHorizontalAlignment(JLabel.CENTER);
		Ch1Name.setBounds(217, 430 + 160, 165, 25);

		Ch2.setBounds(150, 180, 165, 230);
		Ch2Name.setText("두번째 플레이어");
		Ch2Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch2Name.setOpaque(true); // Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch2Name.setBackground(Color.WHITE);
		Ch2Name.setHorizontalAlignment(JLabel.CENTER);
		Ch2Name.setBounds(217, 180 + 160, 165, 25);

		Ch3.setBounds(1200 - 165 - 200, 180, 165, 230);
		Ch3Name.setText("세번째 플레이어");
		Ch3Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch3Name.setOpaque(true); // Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch3Name.setBackground(Color.WHITE);
		Ch3Name.setHorizontalAlignment(JLabel.CENTER);
		Ch3Name.setBounds(1200 - 165 - 200, 180 + 160, 165, 25);

		Ch4.setBounds(1200 - 165 - 200, 430, 165, 230);
		Ch4Name.setText("네번째 플레이어");
		Ch4Name.setFont(new Font("Courier", Font.BOLD, 20));
		Ch4Name.setOpaque(true); // Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		Ch4Name.setBackground(Color.WHITE);
		Ch4Name.setHorizontalAlignment(JLabel.CENTER);
		Ch4Name.setBounds(1200 - 165 - 200, 430 + 160, 165, 25);

//		JTextArea display = new JTextArea("테스트중");
//		Font displayFont = new Font("Serif", Font.BOLD, 20);
//		display.setFont(displayFont);
//		display.setEditable(false);
//		display.setOpaque(true);
//		display.setBackground(new Color(0, 0, 0, 200));
//		display.setForeground(new Color(255, 255, 255));
//		JScrollPane scroll = new JScrollPane(display);
//		display.setBounds(450, 200, 900, 390);
//		display.append(readChatting);
		
		chatArea();
		

		Enter.setBounds(450, 600, 300, 81);
		Font font = new Font("Courier", Font.BOLD, 25);
		Enter.setFont(font);

		jFrame.add(PlayMusicButton);

		
		
		jFrame.add(Ch1Name);
		jFrame.add(Ch1);
		jFrame.add(Ch2Name);
		jFrame.add(Ch2);
		jFrame.add(Ch3Name);
		jFrame.add(Ch3);
		jFrame.add(Ch4Name);
		jFrame.add(Ch4);
		jFrame.add(Enter);
		jFrame.add(display);
		jFrame.add(ReadyButton);
		
		
		
	}
	
	public static void readyButton() {
		ReadyBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/Readybutton.png"));
		ReadyBtnMouseOver = new ImageIcon(
				Main.class.getResource("/view/buttonsGUI/ReadybuttonMouseOver.png"));
		ReadyBtnOn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/ReadybuttonOn.png"));
		ReadyButton = new JButton(ReadyBtn);
		
		
		ReadyButton.setBounds(210, 50, 300, 153);
		ReadyButton.setBorderPainted(false);
		ReadyButton.setContentAreaFilled(false);
		ReadyButton.setFocusPainted(false);
		ReadyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (ReadyButton.getIcon() != ReadyBtnOn) {
					ReadyButton.setIcon(ReadyBtnOn);
					try {
						bw.write("ready+1"+"\n"); // 레디 누를시 +1
						bw.flush();
					} catch (IOException e1) {
						try {
							bw.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						e1.printStackTrace();
					}
				} else if (ReadyButton.getIcon() == ReadyBtnOn) {
					ReadyButton.setIcon(ReadyBtn);
					try {
						bw.write("ready-1"+"\n"); // 레디 취소할 시 -1
						bw.flush();
					} catch (IOException e1) {
						try {
							bw.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						e1.printStackTrace();
					}
					
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (ReadyButton.getIcon() != ReadyBtnOn) {
					ReadyButton.setIcon(ReadyBtn);
					ReadyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (ReadyButton.getIcon() != ReadyBtnOn) {
					ReadyButton.setIcon(ReadyBtnMouseOver);
					ReadyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
	}
	
	
	
	public static void chatArea() { // 채팅창
		
		display = new JTextArea();
		displayFont = new Font("Serif", Font.BOLD, 20);
		display.setFont(displayFont);
		display.setEditable(false);
		display.setOpaque(true);
		display.setBackground(new Color(0, 0, 0, 200));
		display.setForeground(new Color(255, 255, 255));
		scroll = new JScrollPane(display);
		display.setBounds(450, 200, 500, 390);
		appendChat();
	}
	public static void appendChat() { // 받은 데이터를 display에 출력
		display.append(readChatting+"\n");
	}
	
	public static void getMsg(String msg) {		// 텍스트를 읽어서 서버로 보냄
		answer = msg;
		try {
			bw.write(msg + " " + "\n"); // 명령어를 사용 못하게 하기 위한 " " 추가
			bw.flush();
		} catch (IOException e) {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
}
