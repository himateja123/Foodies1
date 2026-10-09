package com.foodies1.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final class DatabaseConnection {
    private DatabaseConnection() {}

    static Connection getConnection() {
        String host = env("MYSQLHOST", "MYSQL_HOST", "localhost");
        String port = env("MYSQLPORT", "MYSQL_PORT", "3306");
        String database = env("MYSQLDATABASE", "MYSQL_DATABASE", "foodies");
        String username = env("MYSQLUSER", "MYSQL_USER", "root");
        String password = env("MYSQLPASSWORD", "MYSQL_PASSWORD", "");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&connectTimeout=10000&socketTimeout=20000";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException("MySQL connection failed. Check the MYSQLHOST, MYSQLPORT, MYSQLDATABASE, MYSQLUSER and MYSQLPASSWORD settings and database availability. " + e.getClass().getSimpleName() + ": " + e.getMessage(), e);
        }
    }

    private static String env(String primary, String alternate, String fallback) {
        String value = System.getenv(primary);
        if (value == null || value.isBlank()) value = System.getenv(alternate);
        return value == null || value.isBlank() ? fallback : value.trim();
    }
}
