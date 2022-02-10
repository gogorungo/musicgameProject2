package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// txt 파일 ArrayList로 만들어서 저장
public class ReadTxt {
	public static List<String> links;
	public static List<String> names;
	public static List<String> singers;

	public ReadTxt() throws IOException {
		links = new ArrayList<String>();
        names = new ArrayList<String>();
        singers = new ArrayList<String>();
		try {
			//file 입력 스트림을 생성
			File List = new File("C:/Users/Minhyeok/Desktop/Git/LineNo5/python_MH/audio/List.txt");
			FileReader aReader = new FileReader(List);
			//스트림으로 입력 버퍼를 생성
	        BufferedReader aBufReader = new BufferedReader(aReader);
	        String link = "";
	        //txt를 List에 저장 저장
	        while((link = aBufReader.readLine()) != null) {
	        	String[] splitData = link.split("\t");
	        	links.add(splitData[0]);
	        	names.add(splitData[1]);
	        	singers.add(splitData[2]);
	        }
	        aBufReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
