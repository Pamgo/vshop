package com.vshop.dao;

import java.util.List;

import com.vshop.entity.Sys;

/**
 * ϵͳ���õĽӿ���
 * 
 * @author alison
 * @version 1.0
 * 
 */
public interface ISysDao {

	/**
	 * ����id����ϵͳ����
	 * @param sys
	 * @return
	 */
	public boolean updateSys(Sys sys,int id);
	
	/**
	 * ��ѯ����ϵͳ����
	 * @return
	 */
	public List<Sys> getListSys();
	
	/**
	 * ����id��ѯϵͳ��Ϣ
	 * @param id
	 * @return
	 */
	public Sys getSysById(int id);
	
	/**
	 * ��ȡ��Ӧ�Ľ���
	 * @param num
	 * @return
	 */
	public float getMoneyByNum(int num);
}
