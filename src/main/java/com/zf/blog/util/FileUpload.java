package com.zf.blog.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	public static Map<String, String> upload(HttpServletRequest request,MultipartFile file,String path){
		Map<String, String> map=null;
		try {
			if (file!=null && !file.isEmpty()) {
				map=new HashMap<String,String>();
				File basepath=new File(request.getServletContext().getRealPath("/")).getParentFile();
				String savePath="/"+path+"/"+new Date().getTime()+"_"+file.getOriginalFilename();
				File dest=new File(basepath,savePath);
				file.transferTo(dest);
				map.put(file.getName(), savePath);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
