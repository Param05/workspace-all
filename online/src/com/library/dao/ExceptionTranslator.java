package com.library.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.library.exceptionHandling.CustomErrorCodeTranslator;

public class ExceptionTranslator {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		// create a JdbcTemplate and set data source
		this.jdbcTemplate = new JdbcTemplate();
		this.jdbcTemplate.setDataSource(dataSource);
		// create a custom translator and set the DataSource for the default
		// translation lookup
		CustomErrorCodeTranslator tr = new CustomErrorCodeTranslator();
		tr.setDataSource(dataSource);
		this.jdbcTemplate.setExceptionTranslator(tr);
	}

	public void updateRecords(String fn, long id) {
		// use the prepared JdbcTemplate for this update
		this.jdbcTemplate.update("update skills set first_name = ? where id = ?", fn, id);
	}
}