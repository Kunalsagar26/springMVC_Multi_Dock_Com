package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.User;


@Component
public class springDaoImpl implements springDao{

	@Autowired
	User user;

	@Autowired 
	DataSource dataSource;

	public void setDataSource(DataSource ds) {
        dataSource = ds;
    }
	
	
	@Override
	public User getUser() {
		String sql = "SELECT * FROM user_table;";
	    Connection conn = null;
	    User emp = new User();
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				emp.setUser_first_name(rs.getString("user_name"));
				emp.setUser_email_id(rs.getString("user_email"));
				emp.setUser_address(rs.getString("user_address"));
			}
			rs.close();
			ps.close();

		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		return emp;
		
	
	}

	
	
	
	@Override
	public void updateUser(String username, String address) {
		String sql = "UPDATE Customers SET City=? WHERE name = ?;";
	    Connection conn = null;
	    User emp = new User();
	   
		
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setString(1, address);
		 ps.setString(2, username);
			
		ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();

		}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
