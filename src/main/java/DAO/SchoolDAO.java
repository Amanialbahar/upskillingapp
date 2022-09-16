package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Bean.School;
import Database.Databasea;

public class SchoolDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private ArrayList<School> schoolTable;
	private int row;

	public List<School> selectSchools() {
		try {
			db = new Databasea();
			schoolTable = new ArrayList<School>();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select school_id, school_aname, school_ename from school where school_ename is not null order by school_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				School school = new School(rs.getInt("school_id"), rs.getString("school_aname"),
						rs.getString("school_ename"));
				schoolTable.add(school);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return schoolTable;

	}

	// **select by Id **

	public School selectbyId(int school_id) {
		School school = null;

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select school_id, school_aname, school_ename from school where school_id=? order by school_id ");
			ps.setInt(1, school_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				school = new School(rs.getInt("school_id"), rs.getString("school_aname"), rs.getString("school_ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return school;
	}
// **Select max id**

	private int selectMaxId(Connection connection) {
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;

		try {
			ps2 = connection.prepareStatement("select nvl(max(school_id),0) AS School_Id from school");
			rs2 = ps2.executeQuery();
			if (rs2.next()) {
				return rs2.getInt("school_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs2);
		}
		return 0;
	}

	// **SELECT ALL**

	public List<School> selectAll() {

		try {
			db = new Databasea();
			schoolTable = new ArrayList<School>();
			connection = db.getConnection();
			ps = connection
					.prepareStatement("select school_id, school_aname, school_ename from school order by school_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				School school = new School(rs.getInt("school_id"), rs.getString("school_aname"),
						rs.getString("school_ename"));
				schoolTable.add(school);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return schoolTable;
	}

	// **INSERT**

	public int insert(School school) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection
					.prepareStatement("insert into school(school_id, school_aname, school_ename) values(?, ?, ?)");
			int maxId = selectMaxId(connection);
			int counter = 1;
			ps.setInt(counter++, maxId + 1);
//			ps.setInt(counter++, school.getSchool_id());
			ps.setString(counter++, school.getSchool_aname());
			ps.setString(counter++, school.getSchool_ename());

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

	public int update(School school) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement("update school set school_aname = ?, school_ename=?  where school_id = ?");

			int counter = 1;
			ps.setString(counter++, school.getSchool_aname());
			ps.setString(counter++, school.getSchool_ename());
			ps.setInt(counter++, school.getSchool_id());

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
	public int delete(int school_id) {

		db = new Databasea();
		try {
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from school where school_id=?");
			ps.setInt(1, school_id);
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
