package view;

import java.awt.Color;

import javax.swing.JFrame;


// 전체적인 프레임 구조 저장
public class Default extends JFrame{
	public static void DefaultFrame(JFrame jframe, int Width, int Height) {
		jframe.setUndecorated(true); // 기존 상단바 삭제
		jframe.setSize(Width, Height); // 프레임 크기조절
		jframe.setResizable(false); // 프레임 크기 고정
		jframe.setLocationRelativeTo(null); // 프레임 초기 위치 설정
		jframe.setVisible(true); // 프레임 보이기
		jframe.setBackground(new Color(0, 0, 0, 0)); // 초기 배경색 투명하게 설정
		jframe.setLayout(null); // 레이아웃 없음(좌표로 오브젝트 위치 설정)
	}
}
