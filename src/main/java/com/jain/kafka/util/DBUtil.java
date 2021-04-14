package com.jain.kafka.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	private Connection con;

	public Connection getConnection() {
		try {
			 con = DriverManager.getConnection("jdbc:ucanaccess://C:/MSaccessDB/kafkadb1.accdb");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
