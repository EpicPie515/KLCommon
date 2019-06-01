package lol.kangaroo.common.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import lol.kangaroo.common.util.DoubleObject;

public class DatabaseManager {
	
	private String user, pass, db, host;
	private int port;
	
	public DatabaseManager(String user, String pass, String db, String host, int port) {
		this.user = user;
		this.pass = pass;
		this.db = db;
		this.port = port;
		this.host = host;
		
		try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
	
	public void update(String query, Object... o) {
		Connection c = connect();
		try {
			PreparedStatement ps = c.prepareStatement(query);
			for(int i = 0; i < o.length; i++) {
				if(o[i] instanceof UUID)
					ps.setObject(i+1, o[i].toString());
				else
					ps.setObject(i+1, o[i]);
			}
			ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(c);
		}
	}
	
	public void query(String query, Consumer<ResultSet> func, Object... o) {
		Connection c = connect();
		try {
			PreparedStatement ps = c.prepareStatement(query);
			for(int i = 0; i < o.length; i++) {
				if(o[i] instanceof UUID)
					ps.setObject(i+1, o[i].toString());
				else
					ps.setObject(i+1, o[i]);
			}
			ResultSet rs = ps.executeQuery();
			func.accept(rs);
			
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(c);
		}
	}
	
	public void multiQuery(Map<DoubleObject<String, Object[]>, Consumer<ResultSet>> queries) {
		Connection c = connect();
		try {
			for(Entry<DoubleObject<String, Object[]>, Consumer<ResultSet>> query : queries.entrySet()) {
				DoubleObject<String, Object[]> q = query.getKey();
				PreparedStatement ps = c.prepareStatement(q.getObject1());
				for(int i = 0; i < q.getObject2().length; i++) {
					if(q.getObject2()[i] instanceof UUID)
						ps.setObject(i+1, q.getObject2()[i].toString());
					else
						ps.setObject(i+1, q.getObject2()[i]);
				}
				ResultSet rs = ps.executeQuery();
				query.getValue().accept(rs);
				
				ps.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(c);
		}
	}
	
	public void multiUpdate(Set<DoubleObject<String, Object[]>> queries) {
		Connection c = connect();
		try {
			for(DoubleObject<String, Object[]> query : queries) {
				PreparedStatement ps = c.prepareStatement(query.getObject1());
				for(int i = 0; i < query.getObject2().length; i++) {
					if(query.getObject2()[i] instanceof UUID)
						ps.setObject(i+1, query.getObject2()[i].toString());
					else
						ps.setObject(i+1, query.getObject2()[i]);
				}
				ps.executeUpdate();
				ps.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(c);
		}
	}
	
	private Connection connect() {
		try {
			return DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+pass+"&zeroDateTimeBehavior=convertToNull&useSSL=false");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void close(Connection c) {
		try {
			c.close();
			c = null;
		} catch (Exception e) {}
	}
	
}
