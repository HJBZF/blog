package com.zf.blog.biz;

import java.util.List;

import com.zf.blog.bean.BlogType;

public interface IBlogTypeBiz {
	/**
	 * 返回所有博文类型
	 * @return
	 */
	public List<BlogType> findAll();
	
	/**
	 * 添加博文类型
	 * @param bt
	 * @return
	 */
	public int add(BlogType bt);
}
