package com.vshop.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

/**
 * ���ݿ����Ӷ��������
 * @author alison
 * @version 1.0
 *
 */
public class ConnectionManager {
	private static ConnectionManager instance;
	
	//c3p0�����ӳض���
	private ComboPooledDataSource ds;
	
	public ConnectionManager() {
		ds = new ComboPooledDataSource("mysql");
	}
	
	/**
	 * ����ģʽ��ȡ���ݿ����Ӷ���
	 * @return
	 */
	public static final ConnectionManager getInstance(){
		if(instance == null){
			try{
				instance = new ConnectionManager();
			}catch(Exception e){
				e.printStackTrace();
				}
		}
		return instance;
	}
	
	/**
	 * Ϊ���̰߳�ȫ��ͬ��
	 * @return
	 */
	public synchronized final Connection getConnection(){
		
		try{
			return ds.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void finalize() throws Throwable {
		DataSources.destroy(ds);
		super.finalize();
	}
}
