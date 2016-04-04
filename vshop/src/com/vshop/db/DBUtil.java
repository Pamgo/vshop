package com.vshop.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ��������
 * @author alison
 * @version 1.0
 *
 */
public class DBUtil {
	
	/**
	 * ��c3p0���ݿ����ӳ��л�ȡ���ݿ����Ӷ���
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try{
			// ���������ӳ��л�ȡ���ݿ����Ӷ���
			conn = ConnectionManager.getInstance().getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * ��ɾ��ͨ�÷���
	 * @param sql
	 * @param object
	 * @return
	 */
	public static int executeUpdate(String sql,Object... objects){
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			if(objects != null){
				for(int i = 0; i < objects.length; i++){
					psmt.setObject(i+1, objects[i]);
				}
			}
			result = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(conn, psmt, null);
		}
		return result;
	}
	
	/**
	 * ��ѯͨ�÷���
	 * @param sql
	 * @param rsHandler
	 * @param objects
	 * @return
	 */
	public static Object executeQuery(String sql,IResultSetUtil rsHandler,
			Object...objects){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			conn = getConnection();
			preparedStatement = conn.prepareStatement(sql);
			if(objects != null){
				for(int i = 0; i < objects.length; i++){
					preparedStatement.setObject(i+1, objects[i]);
				}
			}
			resultSet = preparedStatement.executeQuery();
			return rsHandler.doHandler(resultSet);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(conn, preparedStatement, resultSet);
		}
		return null;
	}
	
	/**
	 * ��ѯ�����ֶ�ֵͨ�õķ���
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static Object executeQuery(String sql, Object... objects){
		return executeQuery(sql, new IResultSetUtil(){
			@Override
			public Object doHandler(ResultSet rs) throws SQLException {
				Object object = null;
						if(rs.next()){
							object = rs.getObject(1);
						}
				return object;
			}
		},objects );
	}

	/**
	 * �ͷ���Դ
	 * @param connection
	 * @param psmtStatement
	 * @param resultSet
	 */
	public static void close(Connection connection , 
			PreparedStatement psmtStatement,ResultSet resultSet){
		try {
			if(resultSet != null){
				resultSet.close();
			}
			if(psmtStatement != null){
				psmtStatement.close();
			}
			if(connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
