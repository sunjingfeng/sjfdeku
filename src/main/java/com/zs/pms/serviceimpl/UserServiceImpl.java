package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constents;
import com.zs.pms.vo.QueryUser;
@Service
@Transactional  //开启事物的业务对象
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao dao;
	@Override
	public void hello() {
		System.out.println("Hello Spring");
	}

	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> genMenu(List<TPermission> pers) {
		//创建新容器
		List<TPermission> list=new ArrayList<>();
		//遍历权限列表
		for(TPermission per:pers) {
			//一级菜单
			if(per.getLev()==1) {
				//加载一级菜单下的二级菜单
				for(TPermission per2:pers) {
					//二级权限的上级id等于一级权限id
					if (per2.getPid()==per.getId()) {
						//添加子权限
						per.addChild(per2);
					}
				}
				//添加到新的集合中
				list.add(per);
			}
		}
		return list;
		
	}

	@Override
	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		return dao.queryByCon(query);
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		dao.deleteUserById(id);
	}
	
	@Override
	public void deleteUserByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteUserByIds(ids);
	}

	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override   //只要事物异常就回滚事物
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser user) {
		//新增
		dao.insertUser(user);
	//	int a=1/0;  //产生异常
		//返回主键
		return user.getId();
	}

	@Override
	public List<TUser> queryByPage(int page,QueryUser query) {
		//起始数 从1开始
		int start=(page-1)*Constents.PAGECOUNT+1;
		//截止数
		int end=page*Constents.PAGECOUNT;
		
		query.setStart(start);
		query.setEnd(end);
		
		return dao.queryByPage(query);
		
		
	}


	//计算总页数
	public int queryPageByCont(QueryUser query) {
		//通过总条数计算总页数
		int cont=dao.queryCount(query);
		//能整除
		if(cont%Constents.PAGECOUNT==0) {
			return cont/Constents.PAGECOUNT;
		}else {
			return cont/Constents.PAGECOUNT+1;
		}

	}

	@Override
	public TUser queryById(int id) {
		
		return dao.queryById(id);
	}
	
}
