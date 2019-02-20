package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TDep;

public interface DepService {
	
	public List<TDep> queryByPid(int pid);
}
