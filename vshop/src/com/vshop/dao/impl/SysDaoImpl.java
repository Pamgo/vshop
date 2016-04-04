package com.vshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vshop.dao.ISysDao;
import com.vshop.db.DBUtil;
import com.vshop.db.IResultSetUtil;
import com.vshop.entity.Sys;

/**
 * 实现系统设置操作的接口类
 * 
 * @author alison
 * @version 1.0
 * 
 */
public class SysDaoImpl implements ISysDao {

	/**
	 * 根据id更新系统设置
	 */
	@Override
	public boolean updateSys(Sys sys, int id) {
		String sql = "UPDATE sys SET user_min = ?,user_max = ? ,user_money = ? WHERE id = ? ";
		return DBUtil.executeUpdate(sql, sys.getUser_min(), sys.getUser_max(),
				sys.getUser_money(), id) > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sys> getListSys() {
		String sql = "SELECT id,user_level,user_min,user_max,user_money FROM sys";
		return (List<Sys>) DBUtil.executeQuery(sql, new IResultSetUtil() {
			List<Sys> sysList = new ArrayList<Sys>();

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Sys sys = new Sys();
					sys.setId(rs.getInt(1));
					sys.setUser_level(rs.getInt(2));
					sys.setUser_min(rs.getInt(3));
					sys.setUser_max(rs.getInt(4));
					sys.setUesr_money(rs.getFloat(5));
					sysList.add(sys);
				}

				return sysList;
			}
		});
	}

	/**
	 * 根据系统id查询系统信息
	 */
	@Override
	public Sys getSysById(int id) {
		String sql = "SELECT user_level,user_min,user_max,user_money FROM sys where id = ?";
		return (Sys) DBUtil.executeQuery(sql, new IResultSetUtil() {

			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				if (rs.next()) {
					Sys sys = new Sys();
					sys.setUser_level(rs.getInt(1));
					sys.setUser_min(rs.getInt(2));
					sys.setUser_max(rs.getInt(3));
					sys.setUesr_money(rs.getFloat(4));
					return sys;
				}
				return null;
			}
		}, id);
	}

	@Override
	public float getMoneyByNum(int num) {
		String sql = "SELECT user_money FROM sys where ? >= user_min and ? <= user_max";
		return DBUtil.executeQuery(sql, num, num) == null ? 0 : Float
				.parseFloat(DBUtil.executeQuery(sql, num, num).toString());
	}

}
