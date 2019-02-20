package com.zs.pms.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class testUserService {
	@Autowired
	UserService us;
	
	public void testHello() {
		us.hello();
	}

	public void testLogin() {
		List<TPermission> list1=us.queryByUid(3084);
		for(TPermission tep:list1) {
			System.out.println(tep.getPname());
		}
		System.out.println("---------整理后的--------------");
		for(TPermission per1:us.genMenu(list1)) {
			//一级权限
			System.out.println(per1.getPname());
			for (TPermission per2 : per1.getChildren()) {
				System.out.println("----"+per2.getPname());
			}
		}
	}

	public void testQuery() {
		//创建查询对象
		QueryUser query=new QueryUser();
//		query.setSex("男");
		for(TUser user:us.queryByPage(1, query)) {
			System.out.println(user.getId()+"、"+user.getLoginname());
		}
		System.out.println("共"+us.queryPageByCont(query)+"页");
	}

	public void testDeletes() {
		int[] dis= {333,222,444};
		us.deleteUserByIds(dis);
	}
	
	

	public void tsetUpdate() {
		TUser user=new TUser();
		TDep dept=new TDep();
		dept.setId(4);
		user.setId(111);
		user.setLoginname("updat123");
		user.setPassword("updat123");
		user.setBirthday(new Date());
		user.setDept(dept);
		user.setEmail("updato@163.com");
		user.setIsenabled(1);
		user.setPic("update13");
		user.setRealname("upate123");
		user.setSex("女");
		user.setUpdator(1);
		us.updateUser(user);
	}
	
	@Test
	public void testInsert() {
		TUser user=new TUser();
		TDep dept=new TDep();
		dept.setId(2);
		user.setLoginname("啊哈哈哈");
		user.setPassword("ins");
		user.setBirthday(new Date());
		user.setDept(dept);
		user.setEmail("ins@163.com");
		user.setIsenabled(1);
		user.setPic("ins");
		user.setRealname("ins");
		user.setSex("男");
		user.setCreator(3084);
		us.insertUser(user);
	}
	

	public void testDelete() {
		int i=123;
		us.deleteUserById(i);
	}
}
