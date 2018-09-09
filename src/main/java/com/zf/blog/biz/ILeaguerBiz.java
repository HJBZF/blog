package com.zf.blog.biz;

import com.zf.blog.bean.Leaguer;

public interface ILeaguerBiz {
	/**
	 * 会员注册
	 * @param l
	 * @return
	 */
	public int leaguerReg(Leaguer l);
	
	/**
	 * 图像修改
	 * @param lid
	 * @param photo
	 * @return
	 */
	public int updatePhoto(Integer lid,String photo);
	
	/**
	 * 会员登录
	 * @param account
	 * @param pwd
	 * @return
	 */
	public Leaguer leaguerLogin(String account,String pwd);
}
