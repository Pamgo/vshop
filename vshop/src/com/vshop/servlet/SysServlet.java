package com.vshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vshop.entity.Sys;
import com.vshop.service.ISysService;
import com.vshop.service.impl.SysServiceImpl;

public class SysServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("m");

		ISysService sysService = new SysServiceImpl();
		if (method == null) {
			List<Sys> sysList = sysService.getListSys();
			for (Sys sys : sysList) {
				switch (sys.getUser_level()) {
				case 1:
					req.setAttribute("sys_one", sys);
					break;

				case 2:
					req.setAttribute("sys_two", sys);
					break;
				case 3:
					req.setAttribute("sys_three", sys);
					break;
				case 4:
					req.setAttribute("sys_four", sys);
					break;
				default:
					req.setAttribute("sys_five", sys);
					break;
				}
			}
		}else{
			saveSys(req,resp);
		}
		req.getRequestDispatcher("sys.jsp").forward(req, resp);

	}
	
	/**
	 * 更新保存系统设置
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void saveSys(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//A
		int one_id = Integer.parseInt(req.getParameter("one_id"));
		int one_user_min = Integer.parseInt(req.getParameter("one_user_min"));
		int one_user_max = Integer.parseInt(req.getParameter("one_user_max"));
		Float one_user_money = Float.parseFloat(req.getParameter("one_user_money"));
		ISysService sysService = new SysServiceImpl();
		Sys sys_one = sysService.getSysById(one_id);
		if(one_user_min != sys_one.getUser_min()){
			sys_one.setUser_min(one_user_min);
		}
		if(one_user_max != sys_one.getUser_max()){
			sys_one.setUser_max(one_user_max);
		}
		if(one_user_money != sys_one.getUser_money()){
			sys_one.setUesr_money(one_user_money);
		}
		if(sysService.updateSys(sys_one,one_id)){
			req.setAttribute("savesysMsg", "保存成功!");
		}else{
			req.setAttribute("savesysMsg", "保存失败!");
			resp.sendRedirect(req.getContextPath()+"/sys.jsp");
		}
		
		//B
		int two_id = Integer.parseInt(req.getParameter("two_id"));
		int two_user_min = Integer.parseInt(req.getParameter("two_user_min"));
		int two_user_max = Integer.parseInt(req.getParameter("two_user_max"));
		Float two_user_money = Float.parseFloat(req.getParameter("two_user_money"));
		ISysService sysServiceTwo = new SysServiceImpl();
		Sys sys_two = sysServiceTwo.getSysById(two_id);
		if(two_user_min != sys_two.getUser_min()){
			sys_two.setUser_min(two_user_min);
		}
		if(two_user_max != sys_two.getUser_max()){
			sys_two.setUser_max(two_user_max);
		}
		if(two_user_money != sys_two.getUser_money()){
			sys_two.setUesr_money(two_user_money);
		}
		if(sysServiceTwo.updateSys(sys_two,two_id)){
			req.setAttribute("savesysMsg", "保存成功!");
		}else{
			req.setAttribute("savesysMsg", "保存失败!");
			resp.sendRedirect(req.getContextPath()+"/sys.jsp");
		}
		
		
		//C
		int three_id = Integer.parseInt(req.getParameter("three_id"));
		int three_user_min = Integer.parseInt(req.getParameter("three_user_min"));
		int three_user_max = Integer.parseInt(req.getParameter("three_user_max"));
		Float three_user_money = Float.parseFloat(req.getParameter("three_user_money"));
		ISysService systhreeService = new SysServiceImpl();
		Sys sys_three = systhreeService.getSysById(three_id);
		if(three_user_min != sys_three.getUser_min()){
			sys_three.setUser_min(three_user_min);
		}
		if(three_user_max != sys_three.getUser_max()){
			sys_three.setUser_max(three_user_max);
		}
		if(three_user_money != sys_three.getUser_money()){
			sys_three.setUesr_money(three_user_money);
		}
		if(systhreeService.updateSys(sys_three,three_id)){
			req.setAttribute("savesysMsg", "保存成功!");
		}else{
			req.setAttribute("savesysMsg", "保存失败!");
			resp.sendRedirect(req.getContextPath()+"/sys.jsp");
		}
		
		
		//D
		int four_id = Integer.parseInt(req.getParameter("four_id"));
		int four_user_min = Integer.parseInt(req.getParameter("four_user_min"));
		int four_user_max = Integer.parseInt(req.getParameter("four_user_max"));
		Float four_user_money = Float.parseFloat(req.getParameter("four_user_money"));
		ISysService sysfourService = new SysServiceImpl();
		Sys sys_four = sysfourService.getSysById(four_id);
		if(four_user_min != sys_four.getUser_min()){
			sys_four.setUser_min(four_user_min);
		}
		if(four_user_max != sys_four.getUser_max()){
			sys_four.setUser_max(four_user_max);
		}
		if(four_user_money != sys_four.getUser_money()){
			sys_four.setUesr_money(four_user_money);
		}
		if(sysfourService.updateSys(sys_four,four_id)){
			req.setAttribute("savesysMsg", "保存成功!");
		}else{
			req.setAttribute("savesysMsg", "保存失败!");
			resp.sendRedirect(req.getContextPath()+"/sys.jsp");
		}
		
		
		//E
		int five_id = Integer.parseInt(req.getParameter("five_id"));
		int five_user_min = Integer.parseInt(req.getParameter("five_user_min"));
		int five_user_max = Integer.parseInt(req.getParameter("five_user_max"));
		Float five_user_money = Float.parseFloat(req.getParameter("five_user_money"));
		ISysService sysfiveService = new SysServiceImpl();
		Sys sys_five = sysfiveService.getSysById(five_id);
		if(five_user_min != sys_five.getUser_min()){
			sys_five.setUser_min(five_user_min);
		}
		if(five_user_max != sys_five.getUser_max()){
			sys_five.setUser_max(five_user_max);
		}
		if(five_user_money != sys_five.getUser_money()){
			sys_five.setUesr_money(five_user_money);
		}
		if(sysfiveService.updateSys(sys_five,five_id)){
			req.setAttribute("savesysMsg", "保存成功!");
		}else{
			req.setAttribute("savesysMsg", "保存失败!");
			resp.sendRedirect(req.getContextPath()+"/sys.jsp");
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
