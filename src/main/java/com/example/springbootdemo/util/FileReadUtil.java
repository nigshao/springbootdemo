package com.example.springbootdemo.util;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileReadUtil {
	
	public static Set<String> readFile(String path){
		Set<String> result=new HashSet<String>();
		InputStream inputStream=FileReadUtil.class.getResourceAsStream(path);
		//File file=new File(FileReadUtil.class.getClassLoader().getResource("").getPath()+path);
		InputStreamReader bis = null;
		BufferedReader reader = null;
		try {
			//reader = new BufferedReader(new FileReader(file));
			bis = new InputStreamReader(inputStream);
			reader = new BufferedReader(bis);
	    	String lineText;
	    	while((lineText = reader.readLine()) != null){
	    		result.add(lineText);
	    	}
	    	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bis.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}

}
