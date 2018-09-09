package com.zf.blog.bean;

import java.io.Serializable;

public class BlogArticle implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer bid;
	private Integer tid;
	private String title;
	private String bdate;
	private Integer lid;
	private String content;
	private Integer views;
	private Integer status;
	
	private BlogType blogType;
	private Leaguer leaguer;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BlogType getBlogType() {
		return blogType;
	}
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
	public Leaguer getLeaguer() {
		return leaguer;
	}
	public void setLeaguer(Leaguer leaguer) {
		this.leaguer = leaguer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bdate == null) ? 0 : bdate.hashCode());
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result + ((blogType == null) ? 0 : blogType.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((leaguer == null) ? 0 : leaguer.hashCode());
		result = prime * result + ((lid == null) ? 0 : lid.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((views == null) ? 0 : views.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlogArticle other = (BlogArticle) obj;
		if (bdate == null) {
			if (other.bdate != null)
				return false;
		} else if (!bdate.equals(other.bdate))
			return false;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (blogType == null) {
			if (other.blogType != null)
				return false;
		} else if (!blogType.equals(other.blogType))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (leaguer == null) {
			if (other.leaguer != null)
				return false;
		} else if (!leaguer.equals(other.leaguer))
			return false;
		if (lid == null) {
			if (other.lid != null)
				return false;
		} else if (!lid.equals(other.lid))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (views == null) {
			if (other.views != null)
				return false;
		} else if (!views.equals(other.views))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BlogArticle [bid=" + bid + ", tid=" + tid + ", title=" + title + ", bdate=" + bdate + ", lid=" + lid
				+ ", content=" + content + ", views=" + views + ", status=" + status + ", blogType=" + blogType
				+ ", leaguer=" + leaguer + "]";
	}
	public BlogArticle(Integer bid, Integer tid, String title, String bdate, Integer lid, String content,
			Integer views, Integer status, BlogType blogType, Leaguer leaguer) {
		super();
		this.bid = bid;
		this.tid = tid;
		this.title = title;
		this.bdate = bdate;
		this.lid = lid;
		this.content = content;
		this.views = views;
		this.status = status;
		this.blogType = blogType;
		this.leaguer = leaguer;
	}
	public BlogArticle() {
		super();
	}
	
}
