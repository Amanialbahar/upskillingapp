package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.User;
import Database.Databasea;


public class UserDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;

	public int insert(User user) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into user_tbl(user_id, first_name, last_name, sex, birthdate, country, email, pwd,sal,mobile) values(?, ?, ?, ?, ?,?,?, ?, ?, ?)");

			int counter = 1;
			//int user_id = 2;
			ps.setInt(counter++, 2);
			ps.setString(counter++, user.getFname());
			ps.setString(counter++, user.getLname());
			ps.setString(counter++, user.getSex());
			ps.setDate(counter++, new Date(user.getCal().getTime()));
			ps.setString(counter++, user.getCountry());
			ps.setString(counter++, user.getEmail());
			ps.setString(counter++, user.getPass());
			ps.setDouble(counter++, user.getExpectetSalary());
			ps.setString(counter++, user.getMobile());
			

			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);

		}
		return row;
	}
	
	public User selectbyEmail(String email, String pass) {
		User user = null;

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement("select user_id, first_name, last_name, sex, birthdate, country, email from user_tbl where email = ? and pass=?");

			
			ps.setString(1, email);
			ps.setString(2, pass);
			
			
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User(rs.getString("first_name"), rs.getString("last_name"),rs.getString("sex"),rs.getDate("birthdate"),rs.getString("pass"),rs.getString("email"),rs.getString("country"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return user;
	}

}
