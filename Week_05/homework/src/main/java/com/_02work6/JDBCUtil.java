package com._02work6;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class JDBCUtil {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    //  Database credentials
    static final String USER = "username";
    static final String PASS = "password";

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource hikariDataSource;

    private static boolean USE_HIKAR = false;

    static {
        config.setJdbcUrl( DB_URL );
        config.setUsername( USER );
        config.setPassword( PASS );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        hikariDataSource = new HikariDataSource( config );
    }


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return USE_HIKAR ? getHikariDataSourceConnect() : getRawConnection();
    }

    public static Connection getRawConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        return conn;
    }

    public static Connection getHikariDataSourceConnect() throws SQLException {
        return hikariDataSource.getConnection();
    }

    public static void close(Connection connection, PreparedStatement preparedStatement) {

    }

}
