package com.vshop.test;

import java.util.List;

import org.junit.Test;

import com.vshop.dao.IUserDao;
import com.vshop.dao.impl.UserDaoImpl;
import com.vshop.db.DBUtil;
import com.vshop.entity.User;
import com.vshop.util.StringHelper;

public class DBUtilTest {

	@Test
	public void testGetConnection() {
		System.out.println(DBUtil.getConnection());
	}

	@Test
	public void testExecuteUpdate() {
	}

	@Test
	public void testExecuteQueryStringIResultSetUtilObjectArray() {
	}

	@Test
	public void testExecuteQueryStringObjectArray() {
	}

	@Test
	public void testMD5(){
		System.out.println(StringHelper.MD5("11"));
	}
	@Test
	public void testadd(){
		IUserDao dao = new UserDaoImpl();
		User user = new User();
		user.setUser_id("pamgo");
		user.setUser_name("Ä¬±ù");
		user.setUser_birthday("1992-09-24");
		user.setUser_city("¹ãÖÝ");
		user.setUser_pass(StringHelper.MD5("11"));
		user.setUser_creator("alison");
		user.setCreated_time(StringHelper.getCurrentTimeStamp());
		user.setLeft_num(10);
		user.setRight_num(11);
		System.out.println(dao.addUserInfo(user));
	}
	@Test
	public void getChildList(){
		IUserDao dao = new UserDaoImpl();
		List<User> userList = dao.getChildList(2, 8, 3);
		for(User user:userList){
			System.out.println(user.getLeft_num()+","+user.getRight_num()+","+user.getUser_level());
		}
		
	}
}
