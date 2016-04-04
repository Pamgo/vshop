package com.vshop.service;

import java.sql.SQLException;
import java.util.List;

import com.vshop.entity.User;

/**
 * 用户业务逻辑接口
 * @author alison
 * @version 1.0
 *
 */
public interface IUserService {

	/**
	 * 用户登录验证
	 * @param user_id 用户名
	 * @param user_pass 密码
	 * 方法名称：login
	 * @return String (1:代表用户名错误，2：代表密码错误，3：用户名和密码都正确)
	 * @throws SQLException
	 */
	public String login(String user_id,String user_pass);
	
	/**
	 * 根据用户账号获取用户信息
	 * @param user_id 
	 * @return user对象
	 */
	public User getUserByuserID(String user_id);
	
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	public boolean saveUserInfo(User user);
	
	/**
	 * 添加联系人信息
	 * @param user
	 * @return
	 */
	public boolean addUserInfo(User user);
	
	/**
	 * 更新左下标值
	 * @param Right_num
	 * @return
	 */
	public boolean updateLeft_num(int right_num,int id);
	
	/**
	 * 更新右下标值
	 * @param Left_num
	 * @return
	 */
	public boolean updateRight_num(int left_num,int id);
	
	/**
	 * 根据用户账号查询用户所在的树形层级数
	 * @param user_id
	 * @return
	 */
	public int getUserLevelByUserId(String user_id);
	
	/**
	 * 根据用户的账号更新用户的层级数
	 * @param user_level
	 * @param user_id
	 * @return
	 */
	public boolean updateUserLevelByUserId(int user_level,String user_id);
	
	/**
	 * 查询当前结点的所有字节点
	 * @param left_num
	 * @param right_num
	 * @param level
	 * @return
	 */
	public List<User> getChildList(int left_num,int right_num,int user_level);
	
	/**
	 * 根据用户名查询用户信息
	 * @param user_id
	 * @return
	 */
	public User findUserMsgByUserId(String user_id);
}
