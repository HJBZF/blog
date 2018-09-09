package com.zf.blog.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.blog.bean.Leaguer;
import com.zf.blog.biz.ILeaguerBiz;
import com.zf.blog.dao.BaseDao;
import com.zf.blog.util.MD5Encryption;
import com.zf.blog.util.StringUtil;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class LeaguerBizImpl implements ILeaguerBiz{
	@Autowired
	private BaseDao baseDao;
	
	/**
	 * 添加	会员注册 
	 */
	@Override
	public int leaguerReg(Leaguer l) {
		if(StringUtil.isNull(l.getLname(),l.getPwd())){
			return 0;
		}else{
			//加密密码
			l.setPwd( MD5Encryption.createPassword(l.getPwd()) );
			return this.baseDao.add(Leaguer.class, l, "leaguerReg");
		}
	}

	/**
	 * 修改图像
	 */
	@Override
	public int updatePhoto(Integer lid, String photo) {
		if (StringUtil.isNull(photo)) {
			return 0;
		}else{
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("lid", lid);
			map.put("photo", photo);
			return this.baseDao.add(Leaguer.class, map, "updatePhoto");
		}
	}

	/**
	 * 登录
	 */
	@Override
	public Leaguer leaguerLogin(String account, String pwd) {
		if(StringUtil.isNull(account,pwd)){
			return null;
		}else{
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("account", account);
			pwd=MD5Encryption.createPassword(pwd);
			map.put("pwd", pwd);
			return (Leaguer) this.baseDao.find(Leaguer.class, map,"leaguerLogin");
		}
	}

}
