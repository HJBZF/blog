package com.zf.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.zf.blog.bean.Leaguer;
import com.zf.blog.biz.ILeaguerBiz;

@Controller
public class LeaguerController {
	@Autowired
	private ILeaguerBiz leaguerBiz;
	
	@RequestMapping("/leaguerReg")
	@ResponseBody
	public Integer leaguerReg(Leaguer l){
		System.out.println(l);
		return this.leaguerBiz.leaguerReg(l);
	}
	
	/**
	 * 修改图片
	 * @param photos
	 * @param session
	 * @return
	 */
	@RequestMapping("/updatePhoto")
	@ResponseBody
	public String updatePhoto(@RequestParam("photos") MultipartFile photos,HttpSession session){
		if(photos!=null && photos.getSize()>0){
			try {
				String path=session.getServletContext().getRealPath("");
				String savePath="/uploadfile/"+new Date().getTime()+"_"+photos.getOriginalFilename();
				File dest=new File( new File(path).getParentFile(),savePath);
				photos.transferTo(dest);
				Leaguer lg=(Leaguer) session.getAttribute("currentLoginLeaguer");
				int result=this.leaguerBiz.updatePhoto(lg.getLid(), savePath);
				if(result<=0){
					return null;
				}else{
					lg.setPhoto(savePath);
					session.setAttribute("currentLoginLeaguer", lg);
					return savePath;
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 登录
	 * @param session
	 * @param account
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/leaguerLogin")
	@ResponseBody
	public String leaguerLogin(HttpSession session,String account,String pwd){
		Leaguer leaguer=this.leaguerBiz.leaguerLogin(account, pwd);
		System.out.println(leaguer);
		Gson gson=new Gson();
		if(leaguer==null){
			return gson.toJson(null);
		}else{
			session.setAttribute("currentLoginLeaguer", leaguer);
			return gson.toJson(leaguer);
		}
	}
	
	@RequestMapping("/back/showAddBlogPage")
	public String showAddBlogPage(){
		return "WEB-INF/back/blog";
	}
}

