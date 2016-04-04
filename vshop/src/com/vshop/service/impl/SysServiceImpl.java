package com.vshop.service.impl;

import java.util.List;

import com.vshop.dao.ISysDao;
import com.vshop.dao.impl.SysDaoImpl;
import com.vshop.entity.Sys;
import com.vshop.service.ISysService;

/**
 * 系统设置业务逻辑实现类
 * @author alison
 * @version 1.0
 *
 */
public class SysServiceImpl implements ISysService {

	/**
	 *根据id更新系统设置
	 */
	@Override
	public boolean updateSys(Sys sys,int id) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.updateSys(sys,id);
	}

	/**
	 * 查询所用系统信息
	 */
	@Override
	public List<Sys> getListSys() {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getListSys();
	}

	/**
	 * 根据id查询系统信息
	 */
	@Override
	public Sys getSysById(int id) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getSysById(id);
	}

	/**
	 * 获得相应奖金
	 */
	@Override
	public float getMoneyByNum(int num) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getMoneyByNum(num);
	}

}
