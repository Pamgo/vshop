package com.vshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		IUserService userService = new UserServiceImpl();
		String user_id = req.getParameter("user_id");
		if (user_id == null) {
			user_id = session.getAttribute("username").toString();
		}
		// 查询当前用户
		User current_user = userService.getUserByuserID(user_id);
		if (current_user != null) {
			// 根据当前用户查询该用户下的所有子节点
			List<User> childList = userService.getChildList(
					current_user.getLeft_num(), current_user.getRight_num(),
					current_user.getUser_level());
			int i = 0, j;
			
			//---------------------------
			//----很大一个bug，bug.........................
			//---------------------------
			for (User user2 : childList) {
				// 第二层
				j = 0;
				if (user2.getUser_level() == current_user.getUser_level() + 1) {
					switch (i) {
					case 0:
						req.setAttribute("user_1", user2);
						break;
					case 1:
						req.setAttribute("user_2", user2);
						break;
					default:
						req.setAttribute("user_3", user2);
						break;
					}
				} else {
					for (User user3 : childList) {
						// 第三层
						if (user2.getUser_level() == current_user
								.getUser_level() + 2) {
							switch (j) {
							case 0:
								req.setAttribute("user_4", user3);
								break;
							case 1:
								req.setAttribute("user_5", user3);
								break;
							default:
								req.setAttribute("user_6", user3);
								break;
							}
						}
						j++;
					}
					i++;
				}
			}
			req.setAttribute("current_user", current_user);
			// req.setAttribute("childList", childList);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
