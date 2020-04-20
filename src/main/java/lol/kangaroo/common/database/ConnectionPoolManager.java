package lol.kangaroo.common.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolManager {
 
    private HikariDataSource dataSource;
 
    private String hostname;
    private String port;
    private String database;
    private String username;
    private String password;
 
    private int minimumConnections;
    private int maximumConnections;
    private long connectionTimeout;
 
    public ConnectionPoolManager(String hostname, String port, String database, String username, String password,
    		int minConns, int maxConns, long timeout) {
		this.hostname = hostname;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;
		this.minimumConnections = minConns;
		this.maximumConnections = maxConns;
		this.connectionTimeout = timeout;
        setupPool();
	}
 
    private void setupPool() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(
                "jdbc:mysql://" +
                        hostname +
                        ":" +
                        port +
                        "/" +
                        database +
                        "?useSSL=false"
        );
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setUsername(username);
        config.setPassword(password);
        config.setMinimumIdle(minimumConnections);
        config.setMaximumPoolSize(maximumConnections);
        config.setConnectionTimeout(connectionTimeout);
        dataSource = new HikariDataSource(config);
    }
 
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
 
    public void close(Connection conn) {
        if (conn != null) 
        	try { 
        		conn.close(); 
        	} catch (SQLException ex) {ex.printStackTrace();}
    }
 
}
        