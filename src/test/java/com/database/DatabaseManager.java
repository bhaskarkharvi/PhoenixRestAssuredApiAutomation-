package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.checkerframework.checker.units.qual.h;

import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager14;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseManager {

	private static String DB_URL = ConfigManager14.getProprty("DB_URL");
	private static String DB_USER_NAME = ConfigManager14.getProprty("DB_USER_NAME");
	private static String DB_PASSWORD = ConfigManager14.getProprty("DB_PASSWORD");

	private static HikariConfig hikariConfig;// = new HikariConfig();
	private static HikariDataSource dataSourceHikari;// = new HikariDataSource(hikariConfig);

	private static final int MAXIMUM_POOL_SIZE = Integer.parseInt(ConfigManager14.getProprty("MAXIMUM_POOL_SIZE"));
	private static final int MINIMUM_IDLE_COUNT = Integer.parseInt(ConfigManager14.getProprty("MINIMUM_IDLE_COUNT"));
	private static final int CONNECTION_TIMEOUT_IN_SECS = Integer
			.parseInt(ConfigManager14.getProprty("CONNECTION_TIMEOUT_IN_SECS"));
	private static final int IDLE_TIMEOUT_SECS = Integer.parseInt(ConfigManager14.getProprty("IDLE_TIMEOUT_SECS"));
	private static final int MAX_LIFE_TIME_IN_MINS = Integer
			.parseInt(ConfigManager14.getProprty("MAX_LIFE_TIME_IN_MINS"));
	private static final String HIKARI_CP_POOL_NAME = ConfigManager14.getProprty("HIKARI_CP_POOL_NAME");

	private static Connection conn;// Informs all threads that conn has value already in thread

	private DatabaseManager() {
		// Not allowing to create object , and static method class hence ---> Singleton
		// class
	}

	public static void initializePool() {
		synchronized (DatabaseManager.class) {

			if (dataSourceHikari == null) {// ONLY & Only for the first the connection request.
				HikariConfig hikariConfig = new HikariConfig();
				// dataSourceHikari = DriverManager.getConnection(DB_URL,
				// DB_USER_NAME,DB_PASSWORD);
				hikariConfig.setJdbcUrl(DB_URL);
				hikariConfig.setUsername(DB_USER_NAME);
				hikariConfig.setPassword(DB_PASSWORD);
				hikariConfig.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
				hikariConfig.setMinimumIdle(MINIMUM_IDLE_COUNT);
				hikariConfig.setConnectionTimeout(CONNECTION_TIMEOUT_IN_SECS * 1000);
				hikariConfig.setIdleTimeout(IDLE_TIMEOUT_SECS * 1000);
				hikariConfig.setMaxLifetime(MAX_LIFE_TIME_IN_MINS * 60 * 1000);
				hikariConfig.setPoolName(HIKARI_CP_POOL_NAME);

				dataSourceHikari = new HikariDataSource(hikariConfig);
			}
		}
		System.out.println(conn);
	}
	
	public static Connection getConnection() throws SQLException {
		
		Connection connection=null;
		if(dataSourceHikari==null) {
			initializePool();//Automatic initialization of Hikari Data Source
		}
		
		else if (dataSourceHikari.isClosed()) {
			throw new SQLException("Hikari Data Source is closed");
		}
		
			 connection= dataSourceHikari.getConnection();
	
		return connection;
	}
}
