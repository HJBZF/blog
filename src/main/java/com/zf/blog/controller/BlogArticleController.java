package com.zf.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.zf.blog.bean.BlogArticle;
import com.zf.blog.bean.Leaguer;
import com.zf.blog.biz.IBlogArticleBiz;
import com.zf.blog.util.FileUpload;

@Controller
public class BlogArticleController {
	@Autowired
	private IBlogArticleBiz blogArticleBiz;
	
	/**
	 * 处理文件上传的
	 * @param request
	 * @param file
	 * @param callback
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,path="/ckeditorUpload")
	@ResponseBody
	public String ckeditor (HttpServletRequest request,@RequestParam(name="upload") CommonsMultipartFile file,@RequestParam("CKEditorFuncNum") String callback){
		Map<String, String> map=FileUpload.upload(request,file,"uploadfile");
		return "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + callback + ",'../../"+map.get("upload")+"'," + "'');</script>";
	}
	
	@RequestMapping("/addBlog")
	@ResponseBody
	public int addBlog(HttpSession session,BlogArticle bt){
		Object obj=session.getAttribute("currentLoginLeaguer");
		if (obj!=null) {
			Leaguer lg=(Leaguer) obj;
			bt.setLid(lg.getLid());
			System.out.println(obj);
			return blogArticleBiz.add(bt);
		}else {
			return 0;
		}
	}
	
	@RequestMapping("/findByPage")
	@ResponseBody
	public String findByPage(int pageNo,int pageSize){
		List<BlogArticle> list=blogArticleBiz.findByPage(pageNo, pageSize);
		Gson gson=new Gson();
		return gson.toJson(list);
	}
	
	@RequestMapping("/findByBid")
	@ResponseBody
	public String findByBid(int bid){
		Gson gson=new Gson();
		return gson.toJson(blogArticleBiz.findByBid(bid));
	}
}
