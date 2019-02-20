package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TPermission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7512049132416900243L;
	//id
	private int id;
	//权限名
	private String pname;
	//上级id
	private int pid;
	//层级
	private int lev;
	//是否叶子
	private int isleaf;
	//顺序
	private int sort;
	//路径
	private String url;
	//图标
	private String icon;
	
	//子权限集
	public List<TPermission> children=new ArrayList<>();
	
	//添加一个子权限
	public void addChild(TPermission per) {
		children.add(per);
	}
	
	
	public int getId() {
		return id;
	}
	public List<TPermission> getChildren() {
		return children;
	}
	public void setChildren(List<TPermission> children) {
		this.children = children;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "TPermission [id=" + id + ", pname=" + pname + ", pid=" + pid + ", lev=" + lev + ", isleaf=" + isleaf
				+ ", sort=" + sort + ", url=" + url + ", icon=" + icon + "]";
	}
	
}
