package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL
{
	public MySQL(String uri, String id, String password) throws Exception
	{
		connect(uri, id, password);
	}
	
	public void connect(String uri, String id, String password) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		connect_ = DriverManager.getConnection(uri, id, password);
		
		//Statement statement = connect_.createStatement();
		//String query = "set names utf8";
		//statement.execute(query);
		//query = "set character set utf8";
		//statement.execute(query);
		//statement.close();
	}
	
	public int queryExecute(String query) throws Exception
	{
		Statement statement = connect_.createStatement();
		
//		String encoding = "set names utf8";
//		statement.execute(encoding);
//		encoding = "set character set utf8";
//		statement.execute(encoding);
		
		int count = statement.executeUpdate(query);
		statement.close();
		
		return count;
	}
	
	public Statement getStatement() throws Exception
	{
		return connect_.createStatement();
	}
	
	public PreparedStatement getPreparedStatement(String query) throws Exception
	{
		return connect_.prepareStatement(query);
	}
	
	public void close() throws Exception
	{
		connect_.close();
	}
	
	private Connection connect_	 = null;
}
