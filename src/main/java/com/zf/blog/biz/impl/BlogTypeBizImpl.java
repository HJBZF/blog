package com.zf.blog.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zf.blog.bean.BlogType;
import com.zf.blog.biz.IBlogTypeBiz;
import com.zf.blog.dao.BaseDao;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class BlogTypeBizImpl implements IBlogTypeBiz{
	@Autowired
	private BaseDao baseDao;

	@Override
	public List<BlogType> findAll() {
		return this.baseDao.findAll(BlogType.class, "findAll");
	}

	@Override
	public int add(BlogType bt) {
		return this.baseDao.add(BlogType.class, bt, "add");
	}

}
