package com.example.springbootdemo.util;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileReadUtil {
	
	public static Set<String> readFile(String path){
		Set<String> result=new HashSet<String>();
		File file=new File(FileReadUtil.class.getClassLoader().getResource("").getPath()+path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		
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
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}

}
