package com.vshop.service.impl;

import java.util.List;

import com.vshop.dao.ISysDao;
import com.vshop.dao.impl.SysDaoImpl;
import com.vshop.entity.Sys;
import com.vshop.service.ISysService;

/**
 * ϵͳ����ҵ���߼�ʵ����
 * @author alison
 * @version 1.0
 *
 */
public class SysServiceImpl implements ISysService {

	/**
	 *����id����ϵͳ����
	 */
	@Override
	public boolean updateSys(Sys sys,int id) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.updateSys(sys,id);
	}

	/**
	 * ��ѯ����ϵͳ��Ϣ
	 */
	@Override
	public List<Sys> getListSys() {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getListSys();
	}

	/**
	 * ����id��ѯϵͳ��Ϣ
	 */
	@Override
	public Sys getSysById(int id) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getSysById(id);
	}

	/**
	 * �����Ӧ����
	 */
	@Override
	public float getMoneyByNum(int num) {
		ISysDao sysDao = new SysDaoImpl();
		return sysDao.getMoneyByNum(num);
	}

}
