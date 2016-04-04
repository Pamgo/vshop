package com.vshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;
import com.vshop.util.StringHelper;

public class SaveInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 保存会员信息
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = session.getAttribute("username").toString();
		//if (username != null && !"".equals(username)) {

			IUserService userService = new UserServiceImpl();

			User user = userService.getUserByuserID(username);
			user.setUser_name(req.getParameter("user_name"));
			user.setUser_birthday(req.getParameter("user_birthday"));
			user.setUser_city(req.getParameter("user_city"));
			String user_pass = req.getParameter("user_pass");
			if(user_pass != null){
				user.setUser_pass(StringHelper.MD5(user_pass));
			}else{
				user.setUser_pass(req.getParameter("hf_pass"));
			}
			user.setUser_faq(Integer.parseInt(req.getParameter("user_faq")));
			user.setUser_answer(req.getParameter("user_answer"));
			boolean isSaveSuccess = userService.saveUserInfo(user);
			if(isSaveSuccess){
				req.setAttribute("msg", "保存用户信息成功!");
				req.getRequestDispatcher("info.do").forward(req, resp);
			}else{
				req.setAttribute("msg", "保存用户信息失败!");
			}
			/*} else {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}*/
	}
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
