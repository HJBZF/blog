package com.zf.blog.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.blog.bean.BlogArticle;
import com.zf.blog.biz.IBlogArticleBiz;
import com.zf.blog.dao.BaseDao;

/**
 * 博文类型业务层实现
 * @author zf
 * 2017年12月12日
 */
@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class BlogArticleBizImpl implements IBlogArticleBiz{
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<BlogArticle> findAll() {
		return null;
	}

	@Override
	public int add(BlogArticle bt) {
		return this.baseDao.add(BlogArticle.class, bt, "add");
	}

	@Override
	public List<BlogArticle> findByPage(int pageNo, int pageSize) {
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		return baseDao.findAll(BlogArticle.class, map,"findByPage");
	}

	@Override
	public BlogArticle findByBid(int bid) {
		baseDao.update(BlogArticle.class, bid, "updateViews");
		BlogArticle ba=(BlogArticle) baseDao.find(BlogArticle.class, bid,"findByBid");
		return ba;
	}

}
