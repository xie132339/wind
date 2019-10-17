package com.wind.queen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;


public class URLDemo {
    private static String STR_URL = "http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input"; // 爬取地址

    public static void main(String[] args) {
	try {
	    URL url = new URL(STR_URL); // 创建连接
	    URLConnection conn = url.openConnection(); // 建立连接
	    InputStream is = conn.getInputStream();
	    System.out.println(conn.getContentEncoding());
	    // 一般按行读取网页数据，并进行内容分析
	    // 因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
	    // 进行转换时，需要处理编码格式问题
	    BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
	    // 按行读取并打印
	    File file = new File("D://tx.txt");
	    if(file.exists()) {
		file.delete();
	    }
	    if (!file.exists()) {
		file.createNewFile();
		String line = null;
		while ((line = br.readLine()) != null) {
		    writeFileContent("D://tx.txt", line);
		    System.out.println(line);
		}
	    }
	    br.close();
	} catch (Exception e) {
	    System.out.println(e);
	}
    }

    /**
     * 写入文件
     * @param filepath
     * @param newstr
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath, String newstr) throws IOException {
	Boolean f = false;
	String filein = newstr + "\r\n";
	String temp = "";
	FileInputStream fis = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	FileOutputStream fos = null;
	PrintWriter pw = null;
	try {
	    File file = new File(filepath);
	    fis = new FileInputStream(file);
	    isr = new InputStreamReader(fis);
	    br = new BufferedReader(isr);
	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; (temp = br.readLine()) != null; i++) {
		buffer.append(temp);
		// 行与行之间的分隔符 相当于“\n”
		buffer = buffer.append(System.getProperty("line.separator"));
	    }
	    buffer.append(filein);
	    fos = new FileOutputStream(file);
	    pw = new PrintWriter(fos);
	    pw.write(buffer.toString().toCharArray());
	    pw.flush();
	    f = true;
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    // 不要忘记关闭
	    if (pw != null) {
		pw.close();
	    }
	    if (fos != null) {
		fos.close();
	    }
	    if (br != null) {
		br.close();
	    }
	    if (isr != null) {
		isr.close();
	    }
	    if (fis != null) {
		fis.close();
	    }
	}
	return f;
    }
}
