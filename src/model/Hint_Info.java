package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hint_Info {
	public static List<String> links;
	public static List<String> names;
	public static List<String> singers;
	
	public Hint_Info() throws IOException {
		links = new ArrayList<String>();
        names = new ArrayList<String>();
        singers = new ArrayList<String>();
	
		try {
			File List = new File("../Project_Quiz/Music/MM.txt");
			FileReader fin = new FileReader(List);
			BufferedReader buf = new BufferedReader(fin);
			String Info = "";
			
			while ((Info = buf.readLine()) != null) {
				String[] splitData = Info.split("\t");
				links.add(splitData[0]);
				names.add(splitData[1]);
	        	singers.add(splitData[2]);
	           }
			buf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	       }
   }
}
