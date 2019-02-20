package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.DepDao;
import com.zs.pms.po.TDep;
import com.zs.pms.service.DepService;

@Service
public class DepServiceImpl implements DepService{
	@Autowired
	DepDao dao;
	@Override
	public List<TDep> queryByPid(int pid) {
		// TODO Auto-generated method stub
		return dao.queryByPid(pid);
	}

}
