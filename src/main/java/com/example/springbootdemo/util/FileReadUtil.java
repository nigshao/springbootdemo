package com.example.springbootdemo.util;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class FileReadUtil {
	
	public static Set<String> readFile(String path){
		Set<String> result=new HashSet<String>();
		InputStream inputStream=FileReadUtil.class.getResourceAsStream(path);
		//File file=new File(FileReadUtil.class.getClassLoader().getResource("").getPath()+path);
       /* // 找到FileReadUtil这个.class同一个包下的文件资源
        System.out.println("class.getResource() : "+FileReadUtil.class.getResource("").getPath()+"urlwhitelist");
        //getClassLoader默认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源
        System.out.println("class.getClassLoader().getResource:"+ FileReadUtil.class.getClassLoader().getResource("").getPath()+"urlwhitelist");
        //会报错 ,在与FileReadUtil统计包下没有urlwhitelist文件
        System.out.println("class.getResource() : "+FileReadUtil.class.getResource("/urlwhitelist").getPath());
        System.out.println("class.getClassLoader.getResource(name): "+FileReadUtil.class.getClassLoader().getResource("urlwhitelist").getPath());
        System.out.println("class.getResourceAsStream(\"urlwhitelist\"):"+FileReadUtil.class.getResourceAsStream("urlwhitelist"));
*/
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
