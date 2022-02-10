package youtube;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class YoutubeFrame extends JFrame implements ActionListener
{
	public YoutubeFrame()  {
		JFrame f1 =new JFrame();
		
		JButton b1 = new JButton("제출");
		b1.setBounds(280, 200, 70, 40);
		JButton b2 = new JButton("다음");
		b2.setBounds(360, 200, 70, 40);
		JButton b3 = new JButton("재생");
		b3.setBounds(130, 100, 70, 40);
		b3.addActionListener(this);
		
		JTextField l1 = new JTextField("정답입력");
		l1.setBounds(80, 200, 180, 40);
		
		f1.add(b1);
		f1.add(b2);
		f1.add(b3);
		f1.add(l1);
		f1.setTitle("노래재생 연습");
		f1.setSize(500,300);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			new Wav();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}
	}
}
