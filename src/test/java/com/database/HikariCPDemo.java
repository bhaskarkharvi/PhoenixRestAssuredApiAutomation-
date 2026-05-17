package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.api.utils.ConfigManager14;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDemo {

	public static void main(String[] args) throws SQLException {
		
		HikariConfig hikariConfig= new HikariConfig();
		
		hikariConfig.setJdbcUrl(ConfigManager14.getProprty("DB_URL"));
		hikariConfig.setUsername(ConfigManager14.getProprty("DB_USER_NAME"));
		hikariConfig.setPassword(ConfigManager14.getProprty("DB_PASSWORD"));
		
		hikariConfig.setMaximumPoolSize(10);
		hikariConfig.setMinimumIdle(2);
		hikariConfig.setConnectionTimeout(10000);
		hikariConfig.setIdleTimeout(10000);
		hikariConfig.setMaxLifetime(1800000);//30 min 20*60*1000
		hikariConfig.setPoolName("Phoenix Automation Framework-Hikari");
		
		
		HikariDataSource dataSourceHikari= new HikariDataSource(hikariConfig);
		Connection conn = dataSourceHikari.getConnection();
		System.out.println(conn);
		Statement statement = conn.createStatement();
		ResultSet  resultSet=statement.executeQuery("Select first_name, last_name, mobile_number from tr_customer;");
		while(resultSet.next()) {
			
			System.out.println(resultSet.getString("first_name")+" " + resultSet.getString("last_name")+" " + resultSet.getString("mobile_number"));
		}
		
		
		dataSourceHikari.close();
		
		
		
		
	}

}
