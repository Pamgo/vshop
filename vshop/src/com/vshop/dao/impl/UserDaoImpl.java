package com.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vshop.dao.IUserDao;
import com.vshop.db.DBUtil;
import com.vshop.db.IResultSetUtil;
import com.vshop.entity.User;

/**
 * 实现用户操作的接口类
 * 
 * @author alison
 * @version 1.0
 */
public class UserDaoImpl implements IUserDao {

	/**
	 * 用户登录验证
	 * 
	 * @param user_id
	 *            用户名
	 * @param user_pass
	 *            密码 方法名称：login
	 * @return String (1:代表用户名错误，2：代表密码错误，3：用户名和密码都正确)
	 * @throws SQLException
	 */
	@Override
	public String login(String user_id, String user_pass) {
		String sql = "select user_pass from user where user_id = ?"; // SQL

		Object object = DBUtil.executeQuery(sql, user_id);
		if (object == null) {
			return "1"; // 用户名错误
		} else {
			if (object.toString().equals(user_pass)) {
				return "3"; // 正确
			} else {
				return "2"; // 密码错误
			}
		}
	}

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param user_id
	 *            用户名 方法名称：getUserByuserID
	 * @return User对象
	 */
	@Override
	public User getUserByuserID(final String user_id) {
		String sql = "SELECT user_creator,user_name,user_birthday,user_city,user_pass,user_faq,user_answer,left_num,right_num,id,user_level,created_time FROM user WHERE user_id=?";

		return (User) DBUtil.executeQuery(sql, new IResultSetUtil() {
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				if (rs.next()) {
					User user = new User();
					user.setUser_creator(rs.getString(1));
					user.setUser_name(rs.getString(2));
					user.setUser_birthday(rs.getString(3));
					user.setUser_city(rs.getString(4));
					user.setUser_pass(rs.getString(5));
					user.setUser_faq(rs.getInt(6));
					user.setUser_answer(rs.getString(7));
					user.setLeft_num(rs.getInt(8));
					user.setRight_num(rs.getInt(9));
					user.setId(rs.getInt(10));
					user.setUser_id(user_id);
					user.setUser_level(rs.getInt(11));
					user.setCreated_time(rs.getLong(12));
					return user;
				}
				return null;
			}
		}, user_id);
	}

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 *            return boolean
	 */
	@Override
	public boolean saveUserInfo(User user) {
		String sql = "UPDATE user SET user_name=?,user_birthday=?,user_city=?,user_pass=?,user_faq=?,user_answer=? WHERE user_id = ?";

		return DBUtil.executeUpdate(sql, user.getUser_name(),
				user.getUser_birthday(), user.getUser_city(),
				user.getUser_pass(), user.getUser_faq(), user.getUser_answer(),
				user.getUser_id()) > 0;
	}

	/**
	 * 添加联系人信息
	 */
	@Override
	public boolean addUserInfo(User user) {

		String sql = "INSERT INTO user(user_id,user_name,user_birthday,user_city,user_pass,user_creator,created_time,left_num,right_num ) VALUES(?,?,?,?,?,?,?,?,?)";
		return DBUtil.executeUpdate(sql, user.getUser_id(),
				user.getUser_name(), user.getUser_birthday(),
				user.getUser_city(), user.getUser_pass(),
				user.getUser_creator(), user.getCreated_time(),
				user.getLeft_num(), user.getRight_num()) > 0;
	}

	/**
	 * 更新左下标值
	 * 
	 * @param Right_num
	 * @return
	 */
	@Override
	public boolean updateLeft_num(int right_num, int id) {
		String sql = "UPDATE user SET left_num = left_num + 2 WHERE left_num >= ? AND id <> ?";
		return DBUtil.executeUpdate(sql, right_num, id) > 0;
	}

	/**
	 * 更新右下标值
	 * 
	 * @param Left_num
	 * @return
	 */
	@Override
	public boolean updateRight_num(int left_num, int id) {
		String sql = "UPDATE user SET right_num = right_num + 2 WHERE right_num >= ? AND id <> ?";
		return DBUtil.executeUpdate(sql, left_num, id) > 0;
	}

	/**
	 * 根据用户账号查询用户所在树形结构的层级数
	 */
	@Override
	public int getUserLevelByUserId(String user_id) {
		String sql = "SELECT COUNT(parent.user_id)+1 FROM USER AS node ,USER parent WHERE node.left_num > parent.left_num AND node.left_num < parent.right_num AND node.user_id = ?";
		return DBUtil.executeQuery(sql, user_id) == null ? 0 : Integer
				.parseInt(DBUtil.executeQuery(sql, user_id).toString());
	}

	/**
	 * 根据用户的账号更新用户的层级数
	 */
	@Override
	public boolean updateUserLevelByUserId(int user_level, String user_id) {
		String sql = "UPDATE user SET user_level = ? WHERE user_id = ?";
		return DBUtil.executeUpdate(sql, user_level, user_id) > 0;
	}

	/**
	 * 查询当前用户的所有子节点
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getChildList(int left_num, int right_num, int user_level) {
		String sql = "SELECT user_id,user_creator,created_time,left_num,right_num,user_level FROM USER WHERE left_num > ? AND right_num <? AND user_level <= ? ORDER BY left_num ASC LIMIT 12";
		return (List<User>)DBUtil.executeQuery(sql, new IResultSetUtil(){

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				List<User> userList = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setUser_id(rs.getString(1));
					user.setUser_creator(rs.getString(2));
					user.setCreated_time(rs.getLong(3));
					user.setLeft_num(rs.getInt(4));
					user.setRight_num(rs.getInt(5));
					user.setUser_level(rs.getInt(6));
					userList.add(user);
				}
				
				return userList;
			}
			
		}, left_num,right_num,user_level + 2);
	}

	/**
	 * 根据用户名查询用户信息
	 */
	@Override
	public User findUserMsgByUserId(String user_id) {
		String sql = "SELECT user_creator,user_id,user_name,user_birthday,user_city FROM user WHERE user_id = ?";
		return (User)DBUtil.executeQuery(sql, new IResultSetUtil() {
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				if(rs.next()){
					User user = new User();
					user.setUser_creator(rs.getString(1));
					user.setUser_id(rs.getString(2));
					user.setUser_name(rs.getString(3));
					user.setUser_birthday(rs.getString(4));
					user.setUser_city(rs.getString(5));
					return user;
				}
				return null;
			}
		}, user_id);
	}

}
