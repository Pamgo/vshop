package com.vshop.service;

import java.sql.SQLException;
import java.util.List;

import com.vshop.entity.User;

/**
 * �û�ҵ���߼��ӿ�
 * @author alison
 * @version 1.0
 *
 */
public interface IUserService {

	/**
	 * �û���¼��֤
	 * @param user_id �û���
	 * @param user_pass ����
	 * �������ƣ�login
	 * @return String (1:�����û�������2�������������3���û��������붼��ȷ)
	 * @throws SQLException
	 */
	public String login(String user_id,String user_pass);
	
	/**
	 * �����û��˺Ż�ȡ�û���Ϣ
	 * @param user_id 
	 * @return user����
	 */
	public User getUserByuserID(String user_id);
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public boolean saveUserInfo(User user);
	
	/**
	 * �����ϵ����Ϣ
	 * @param user
	 * @return
	 */
	public boolean addUserInfo(User user);
	
	/**
	 * �������±�ֵ
	 * @param Right_num
	 * @return
	 */
	public boolean updateLeft_num(int right_num,int id);
	
	/**
	 * �������±�ֵ
	 * @param Left_num
	 * @return
	 */
	public boolean updateRight_num(int left_num,int id);
	
	/**
	 * �����û��˺Ų�ѯ�û����ڵ����β㼶��
	 * @param user_id
	 * @return
	 */
	public int getUserLevelByUserId(String user_id);
	
	/**
	 * �����û����˺Ÿ����û��Ĳ㼶��
	 * @param user_level
	 * @param user_id
	 * @return
	 */
	public boolean updateUserLevelByUserId(int user_level,String user_id);
	
	/**
	 * ��ѯ��ǰ���������ֽڵ�
	 * @param left_num
	 * @param right_num
	 * @param level
	 * @return
	 */
	public List<User> getChildList(int left_num,int right_num,int user_level);
	
	/**
	 * �����û�����ѯ�û���Ϣ
	 * @param user_id
	 * @return
	 */
	public User findUserMsgByUserId(String user_id);
}
