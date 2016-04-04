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

public class AddUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * �����ϵ����Ϣ
	 * @param user
	 * @return
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String user_id = req.getParameter("user_id");
		String user_name = req.getParameter("user_name");
		String user_birthday = req.getParameter("user_birthday");
		String user_city = req.getParameter("user_city");
		String user_pass = req.getParameter("user_pass");
		String user_creator = session.getAttribute("username").toString();
		IUserService userService = new UserServiceImpl();
		User user = new User();
		user.setUser_id(user_id);
		user.setUser_name(user_name);
		user.setUser_birthday(user_birthday);
		user.setUser_city(user_city);
		user.setUser_pass(StringHelper.MD5(user_pass));
		user.setUser_creator(user_creator);
		user.setCreated_time(StringHelper.getCurrentTimeStamp());
		
		//�����ڵ�
		User parent_user = userService.getUserByuserID(user_creator);
		user.setLeft_num(parent_user.getRight_num());
		user.setRight_num(parent_user.getRight_num() + 1);
		
		if(userService.addUserInfo(user)){
			//���½ڵ㸸�ڵ����ϵĽڵ�
			//ȥ�������ڵ�
			User new_user = userService.getUserByuserID(user_id);
			userService.updateLeft_num(user.getRight_num(),new_user.getId());
			userService.updateRight_num(user.getLeft_num(),new_user.getId());
			
			//��ѯ����ǰ�û����ڵĲ㼶��
			int new_Level = userService.getUserLevelByUserId(user_id);
			//���²㼶��
			userService.updateUserLevelByUserId(new_Level, user_id);
			req.setAttribute("msg", "�����û���Ϣ�ɹ�!");
		}else{
			req.setAttribute("msg", "�����û���Ϣʧ��!");
		}
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
