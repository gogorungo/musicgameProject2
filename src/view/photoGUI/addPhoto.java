package view.photoGUI;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.Main;
import model.Photo;
import model.PlayWav;
import view.sounds.MusicBackGround;

public class addPhoto{
	static int num;
	public static Photo photo = new Photo(num);
	public static JButton photoButton = new JButton(photo.getPhoto());
	public addPhoto(int num) {
		this.num = num;
		
	}
	
	public JButton First() {
		photoButton = new JButton(photo.getPhoto());
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
		return photoButton;
	}

}
