package com.vshop.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.vshop.dao.IUserDao;
import com.vshop.dao.impl.UserDaoImpl;
import com.vshop.entity.User;
import com.vshop.service.IUserService;

/**
 * 实现用户业务逻辑的接口类
 * @author alison
 * @version 1.0
 *
 */
public class UserServiceImpl implements IUserService {

	/**
	 * 用户登录验证
	 * @param user_id 用户名
	 * @param user_pass 密码
	 * 方法名称：login
	 * @return String (1:代表用户名错误，2：代表密码错误，3：用户名和密码都正确)
	 * @throws SQLException
	 */
	@Override
	public String login(String user_id, String user_pass) {
		IUserDao userDao = new UserDaoImpl();	
		return userDao.login(user_id, user_pass);
	}

	/**
	 * 根据用户账号获取用户信息
	 * @param user_id 
	 * @return user对象
	 */
	@Override
	public User getUserByuserID(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getUserByuserID(user_id);
	}

	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	@Override
	public boolean saveUserInfo(User user) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.saveUserInfo(user);
	}

	/**
	 * 添加联系人信息
	 * @param user
	 * @return
	 */
	@Override
	public boolean addUserInfo(User user) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.addUserInfo(user);
	}

	/**
	 * 更新左下标值
	 */
	@Override
	public boolean updateLeft_num(int right_num,int id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateLeft_num(right_num,id);
	}

	/**
	 * 更新右下标值
	 */
	@Override
	public boolean updateRight_num(int left_num,int id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateRight_num(left_num, id);
	}

	/**
	 * 根据用户账号查询用户所在的树形层级数
	 */
	@Override
	public int getUserLevelByUserId(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getUserLevelByUserId(user_id);
	}

	/**
	 * 根据用户名更新用户所在的层级数
	 */
	@Override
	public boolean updateUserLevelByUserId(int user_level, String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateUserLevelByUserId(user_level, user_id);
	}

	/**
	 * 查询当前用户的所有子节点
	 */
	@Override
	public List<User> getChildList(int left_num, int right_num, int user_level) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getChildList(left_num, right_num, user_level);
	}

	/**
	 * 根据用户名查询用户信息
	 */
	@Override
	public User findUserMsgByUserId(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.findUserMsgByUserId(user_id);
	}

}
