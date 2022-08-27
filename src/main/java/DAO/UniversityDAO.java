package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Bean.University;
import Database.Databasea;

public class UniversityDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private ArrayList<University> universityTable;
	private int row;

	// **select by Id **

	public University selectbyId(int university_id) {
		University univesity = null;

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select university_id, university_aname, university_ename, website from university where university_id= ?");
			


			ps.setInt(1,university_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				univesity = new University(rs.getInt("university_id"), rs.getString("university_aname"),
						rs.getString("university_ename"), rs.getString("website"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {

			Databasea.close(ps);
			Databasea.close(rs);
			Databasea.close(connection);
		}
		return univesity;
	}

	// **SELECT ALL**

	public List<University> selectAll() {

		try {
			db = new Databasea();
			universityTable = new ArrayList<University>();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select university_id, university_aname, university_ename, website from university order by university_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				University university = new University(rs.getInt("University_id"), rs.getString("University_aname"),
						rs.getString("University_ename"), rs.getString("website"));
				universityTable.add(university);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return universityTable;
	}

	// **INSERT**

	public int insert(University university) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into university(university_id, university_aname, university_ename, website) values(?, ?, ?, ?)");

			int counter = 1;
			ps.setInt(counter++, university.getUniversity_id());
			ps.setString(counter++, university.getUniversity_aname());
			ps.setString(counter++, university.getUniversity_ename());
			ps.setString(counter++, university.getWebsite());

			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);

		}
		return row;
	}

	// **Update**

	public int update(University university) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update university set university_aname= ?, university_ename= ?, website= ?  where university_id = ?");

			int counter = 1;
			ps.setString(counter++, university.getUniversity_aname());
			ps.setString(counter++, university.getUniversity_ename());
			ps.setString(counter++, university.getWebsite());
			ps.setInt(counter++, university.getUniversity_id());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return row;
	}

	// **DELETE**
	public int delete(int university_id) {

		db = new Databasea();
		try {
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from university where university_id=?");
			ps.setInt(1, university_id);
			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}

		return row;
	}

}
