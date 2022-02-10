package music;

import java.io.File;

public class MusicFile {

	public static void main(String[] args) {

		// File file = new File("C:\\Program Files\\");
		String path = "C:\\MusicPlayerFolder"; // 폴더 경로
		File Folder = new File(path);

		if (!Folder.exists()) {
			try {
				Folder.mkdir(); // 폴더 생성합니다.
				System.out.println("폴더가 생성되었습니다.");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
	}

}
