package com.zs.pms.po;

import java.io.Serializable;

public class TRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1962827445200282876L;

	//id
	private int id;
	//角色名
	private String rname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "TRole [id=" + id + ", rname=" + rname + "]";
	}
	
}
