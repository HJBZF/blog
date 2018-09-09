package com.zf.blog.bean;

import java.io.Serializable;

public class BlogType implements Serializable{
	private static final long serialVersionUID = -4061196480283860579L;
	private Integer tid;
	private String tname;
	

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
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
		BlogType other = (BlogType) obj;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (tname == null) {
			if (other.tname != null)  
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BlogType [tid=" + tid + ", tname=" + tname + "]";
	}
	public BlogType(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	public BlogType() {
		super();
	}
	
	
}
