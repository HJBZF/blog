package com.zf.blog.biz;

import java.util.List;

import com.zf.blog.bean.BlogArticle;

public interface IBlogArticleBiz {
	/**
	 * 返回所有博文信息
	 * @return
	 */
	public List<BlogArticle> findAll();
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<BlogArticle> findByPage(int pageNo,int pageSize);
	
	/**
	 * 查找bid是否存在
	 * @param bid
	 * @return
	 */
	public BlogArticle findByBid(int bid);
	
	/**
	 * 添加博文信息
	 * @param bt
	 * @return
	 */
	public int add(BlogArticle bt);
}
