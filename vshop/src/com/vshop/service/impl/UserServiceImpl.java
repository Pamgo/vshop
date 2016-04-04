package com.vshop.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.vshop.dao.IUserDao;
import com.vshop.dao.impl.UserDaoImpl;
import com.vshop.entity.User;
import com.vshop.service.IUserService;

/**
 * ʵ���û�ҵ���߼��Ľӿ���
 * @author alison
 * @version 1.0
 *
 */
public class UserServiceImpl implements IUserService {

	/**
	 * �û���¼��֤
	 * @param user_id �û���
	 * @param user_pass ����
	 * �������ƣ�login
	 * @return String (1:�����û�������2�������������3���û��������붼��ȷ)
	 * @throws SQLException
	 */
	@Override
	public String login(String user_id, String user_pass) {
		IUserDao userDao = new UserDaoImpl();	
		return userDao.login(user_id, user_pass);
	}

	/**
	 * �����û��˺Ż�ȡ�û���Ϣ
	 * @param user_id 
	 * @return user����
	 */
	@Override
	public User getUserByuserID(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getUserByuserID(user_id);
	}

	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	@Override
	public boolean saveUserInfo(User user) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.saveUserInfo(user);
	}

	/**
	 * �����ϵ����Ϣ
	 * @param user
	 * @return
	 */
	@Override
	public boolean addUserInfo(User user) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.addUserInfo(user);
	}

	/**
	 * �������±�ֵ
	 */
	@Override
	public boolean updateLeft_num(int right_num,int id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateLeft_num(right_num,id);
	}

	/**
	 * �������±�ֵ
	 */
	@Override
	public boolean updateRight_num(int left_num,int id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateRight_num(left_num, id);
	}

	/**
	 * �����û��˺Ų�ѯ�û����ڵ����β㼶��
	 */
	@Override
	public int getUserLevelByUserId(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getUserLevelByUserId(user_id);
	}

	/**
	 * �����û��������û����ڵĲ㼶��
	 */
	@Override
	public boolean updateUserLevelByUserId(int user_level, String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.updateUserLevelByUserId(user_level, user_id);
	}

	/**
	 * ��ѯ��ǰ�û��������ӽڵ�
	 */
	@Override
	public List<User> getChildList(int left_num, int right_num, int user_level) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.getChildList(left_num, right_num, user_level);
	}

	/**
	 * �����û�����ѯ�û���Ϣ
	 */
	@Override
	public User findUserMsgByUserId(String user_id) {
		IUserDao userDao = new UserDaoImpl();
		return userDao.findUserMsgByUserId(user_id);
	}

}
