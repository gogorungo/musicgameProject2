package view.buttonsGUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import User.MusicInfo;
import main.Main;
import model.AutoLabel;
import model.MusicList;
import model.Photo;
import model.PlayWav;
import model.ReadTxt;
import model.TimeBar;
import view.SingleGameFrame;
import view.countGUI.HintCount;
import view.countGUI.NextCount;
import view.numberGUI.NumberGUI;
import view.photoGUI.addPhoto;
import view.sounds.MusicBackGround;


public class SingleGameButtons extends JFrame {
	public static Random random = new Random();
	public static int N = random.nextInt(30);
	public static int i = 0;
	public static void AddSingleGameButtons(JFrame jFrame) throws IOException {
		ImageIcon NextBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/NextButton.png"));
		ImageIcon NextBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/NextButtonMouseOver.png"));
		ImageIcon PlayMusicBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtn.png"));
		ImageIcon PlayMusicBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/PlayMusicBtnMouseOver.png"));
		ImageIcon SingerHintBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SingerHintBtn.png"));
		ImageIcon SingerHintBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SingerHintBtnMouseOver.png"));
		ImageIcon SongHintBtn = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SongHintBtn.png"));
		ImageIcon SongHintBtnMouseOver = new ImageIcon(Main.class.getResource("/view/buttonsGUI/SongHintBtnMouseOver.png"));

		NumberGUI numbergui = new NumberGUI();
		JLabel NGUI = new JLabel(numbergui.Numbergui(i));
		
		
		JButton NextButton = new JButton(NextBtn);
		JButton PlayMusicButton = new JButton(PlayMusicBtn);
		JButton SingerHintButton = new JButton(SingerHintBtn);
		JButton SongHintButton = new JButton(SongHintBtn);

		JTextField Enter = new JTextField(10);
		JLabel label = new JLabel();

		ArrayList MList = MusicList.musiclist();

		AutoLabel HintLabel = new AutoLabel("힌트 없음");
		
		HintCount hintcount = new HintCount();
		for(int i = 0; i<6; i++) {
			hintcount.setCount(i);
			hintcount.Remain().setVisible(true);
		}
		
		NextCount nextcount = new NextCount();
		for(int i = 0; i<6; i++) {
			nextcount.setCount(i);
			nextcount.Remain().setVisible(true);
		}
		ReadTxt readtxt = new ReadTxt();
		
		SingleGameFrame.playMusic(N);
		
		Photo photo = new Photo(N);
		JButton photoButton = new JButton(photo.getPhoto());
		photoButton.setBounds(370, 90, 500, 500);
		photoButton.setBorderPainted(false);
		photoButton.setContentAreaFilled(false);
		photoButton.setFocusPainted(false);
		photoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				photoButton.setIcon(photo.getPhotoOn());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				//photoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				//photoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		NextButton.setBounds(1000, 570, 120, 120);
		NextButton.setBorderPainted(false);
		NextButton.setContentAreaFilled(false);
		NextButton.setFocusPainted(false);
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (nextcount.getCount() > 0) {
					nextcount.Remain().setVisible(false);
					nextcount.setCount(nextcount.getCount()-1);
					jFrame.add(nextcount.Remain());
					N = random.nextInt(30);
					SingleGameFrame.playMusic(N);
					photo.setFileName();
					photo.setOriginfileName(N);
					photoButton.setIcon(photo.getPhoto());
					// 계속 정답을 맞춘다고 가정
					boolean answer = true;
					i++;
					if(answer == true) {
						NGUI.setIcon(numbergui.Numbergui(i));
					}
				} else {
					System.out.println("다음없음");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				NextButton.setIcon(NextBtnMouseOver);
				NextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				NextButton.setIcon(NextBtn);
				NextButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
				SingleGameFrame.playMusic(N);
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
		
		NGUI.setBounds(210, 60, 120, 120);

		SingerHintButton.setBounds(50, 310, 300, 81);
		SingerHintButton.setBorderPainted(false);
		SingerHintButton.setContentAreaFilled(false);
		SingerHintButton.setFocusPainted(false);
		SingerHintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (hintcount.getCount() > 0) {
					hintcount.Remain().setVisible(false);
					hintcount.setCount(hintcount.getCount()-1);
					jFrame.add(hintcount.Remain());
					MusicInfo musicinfo = (MusicInfo) MList.get(N);
					HintLabel.setText("가수 : " + musicinfo.getSingerHint());
					HintLabel.resize();
				} else {
					HintLabel.setText("힌트 없음");
					HintLabel.resize();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SingerHintButton.setIcon(SingerHintBtnMouseOver);
				SingerHintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SingerHintButton.setIcon(SingerHintBtn);
				SingerHintButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		SongHintButton.setBounds(50, 398, 300, 81);
		SongHintButton.setBorderPainted(false);
		SongHintButton.setContentAreaFilled(false);
		SongHintButton.setFocusPainted(false);
		SongHintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MusicBackGround buttonSound = new MusicBackGround("/view/sounds/ButtonSound.mp3", false);
				buttonSound.start();
				if (hintcount.getCount() > 0) {
					hintcount.Remain().setVisible(false);
					hintcount.setCount(hintcount.getCount()-1);
					jFrame.add(hintcount.Remain());
					MusicInfo musicinfo = (MusicInfo) MList.get(N);
					HintLabel.setText("제목 초성 : " + musicinfo.getSongHint());
					HintLabel.resize();
				} else {
					HintLabel.setText("힌트 없음");
					HintLabel.resize();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SongHintButton.setIcon(SongHintBtnMouseOver);
				SongHintButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SongHintButton.setIcon(SongHintBtn);
				SongHintButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		HintLabel.setBounds(50, 398+90, 300, 81);


		Enter.setBounds(465, 600, 300, 81);
		Font font = new Font("Courier", Font.BOLD, 25);
		Enter.setFont(font);

		jFrame.add(NextButton);
		jFrame.add(PlayMusicButton);
		jFrame.add(NGUI);
		jFrame.add(SongHintButton);
		jFrame.add(SingerHintButton);
		jFrame.add(HintLabel);
		jFrame.add(label);
		jFrame.add(Enter);
		jFrame.add(hintcount.Remain());
		jFrame.add(nextcount.Remain());
		jFrame.add(photoButton);
		
		TimeBar timeBar;
		Thread threadBar;
		timeBar = new TimeBar(180);
		threadBar = new Thread(timeBar);
		threadBar.start();
		jFrame.add(timeBar);
	}

}
