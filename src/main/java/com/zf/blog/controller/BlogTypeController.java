package com.zf.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.zf.blog.bean.BlogType;
import com.zf.blog.biz.IBlogTypeBiz;
import com.zf.blog.util.FileUpload;

@Controller
public class BlogTypeController {
	@Autowired
	private IBlogTypeBiz blogTypeBiz;
	
	@RequestMapping("/findAllBlogType")
	@ResponseBody
	public String findAllBlogType(){
		List<BlogType> list=this.blogTypeBiz.findAll();
		Gson gson=new Gson();
		return gson.toJson(list);
	}
	
	public String ckeditor (HttpServletRequest request,@RequestParam(name="uploadfile") CommonsMultipartFile file,@RequestParam("CKEditorFuncNum") String callback){
		Map<String, String> map=FileUpload.upload(request,file,"uploadfile");
		return "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + callback + ",'../.."+map.get("uploadfile")+"'," + "'');</script>";
	}
}
