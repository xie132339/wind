package com.wind.fileoperation.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.OutputBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Value("${spring.servlet.multipart.location}")
    private String fileLocation;

    @RequestMapping(value = "/file")
    public String index() {
	return "upload";
    }

    /**
     *
     * @return
     * @throws IOException 
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
	String fileName = file.getOriginalFilename();
	String fileDest = fileLocation + "/" + fileName;
	long bytes = file.getSize();
	System.out.println("文件地址：" + fileDest + "，文件大小：" + bytes);
	// 这样默认上传文件就放在当前  项目路径下
	File dest = new File(fileDest);
	System.out.println();
	// 判断父目录存在不
	if (!dest.getParentFile().mkdirs()) {
	    // 父目录不存在就创建一个
	    dest.getParentFile().mkdir();
	}
	try {
	    file.transferTo(dest);
	    return fileDest;
	} catch (Exception e) {
	    e.printStackTrace();
	    return "文件上传失败";
	}
    }

    @RequestMapping(value = "/fileDownload")
    @ResponseBody
    public String download(HttpServletRequest request, HttpServletResponse response)
	    throws UnsupportedEncodingException {
	String fileName = "大型网站架构.pdf";
	String startName = fileName.substring(0, fileName.indexOf("."));
	String postfix = fileName.substring(fileName.indexOf("."), fileName.length());
	System.out.println(fileName.indexOf("."));
	File file = new File(fileLocation + "/" + fileName);
	response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	// 获取访问的浏览器
	String userAgent = request.getHeader("user-agent");
	if (userAgent != null && userAgent.indexOf("Firefox") >= 0 || userAgent.indexOf("Chrome") >= 0
		|| userAgent.indexOf("Safari") >= 0) {
	    response.setHeader("Content-Disposition",
		    "attachment;fileName=" + new String(("案发生发生").getBytes(), "ISO8859-1") + postfix);
	} else {
	    response.setHeader("Content-Disposition",
		    "attachment;fileName=" + URLEncoder.encode(startName, "UTF8") + postfix);
	}
	byte[] buff = new byte[1024];
	BufferedInputStream bis = null;
	OutputStream os = null;
	FileInputStream fis = null; // 文件输入流
	try {
	    os = response.getOutputStream();
	    fis = new FileInputStream(file);
	    bis = new BufferedInputStream(fis);
	    int i = bis.read(buff);
	    while (i != -1) {
		os.write(buff, 0, buff.length);
		os.flush();
		i = bis.read(buff);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return "文件下载失败";
	} finally {
	    if (bis != null) {
		try {
		    bis.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return "文件下载成功";
    }
}
