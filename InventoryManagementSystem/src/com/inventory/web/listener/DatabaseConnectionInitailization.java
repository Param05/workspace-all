package com.inventory.web.listener;

import java.sql.Connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.inventory.util.DbUtil;

@WebListener
public class DatabaseConnectionInitailization implements ServletContextListener {
	private static Connection connection = null;
	public static DataSource dataSource = null;

	public void contextInitialized(ServletContextEvent event) {
		connection = DbUtil.getConnection();
		event.getServletContext().setAttribute("connection", connection);
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

}
