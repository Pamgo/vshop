package com.vshop.service;

import java.util.List;

import com.vshop.entity.Sys;

/**
 * 系统设置业务逻辑接口
 * @author alison
 * @version 1.0
 *
 */
public interface ISysService {

	/**
	 * 根据id更新系统设置
	 * @param sys
	 * @return
	 */
	public boolean updateSys(Sys sys,int id);
	
	/**
	 * 查询所有系统设置
	 * @return
	 */
	public List<Sys> getListSys();
	
	/**
	 * 根据id查询系统信息
	 * @param id
	 * @return
	 */
	public Sys getSysById(int id);
	
	/**
	 * 获取相应的奖金
	 * @param num
	 * @return
	 */
	public float getMoneyByNum(int num);
}
