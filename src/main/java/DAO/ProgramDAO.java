package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Program;
import Bean.School;
import Database.Databasea;

public class ProgramDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private int row;
	private ArrayList<Program> programTable;

	// select schools
	public List<String> selectSchools() {
		List<String> schoolsTable = new ArrayList<String>();

		try {
			db = new Databasea();
			programTable = new ArrayList<Program>();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select distinct school_ename from school where school_ename is not null order by school_ename");
			rs = ps.executeQuery();

			while (rs.next()) {
				schoolsTable.add(rs.getString("school_ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return schoolsTable;
	}

	// ** select programs by school id

	public List<String> getProgBySchool(int school_id) {
//		Program program = null;
		List<String> proTable = new ArrayList<String>();


		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select program_ename from program where school_id=?");
			ps.setInt(1,school_id);
			rs = ps.executeQuery();
			while (rs.next()) {
							proTable.add(rs.getString("program_ename"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(rs);
			Databasea.close(ps);
			Databasea.close(connection);
		}

		return proTable;
	}

	// **select by Id

	public Program selectbyIdp(int program_id) {

		Program program = null;

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select school_id, program_id, program_aname,program_ename from program where program_id=?");// add
																													// where
																													// condition
			ps.setInt(1, program_id);
			rs = ps.executeQuery();

			if (rs.next()) {

				program = new Program(rs.getInt("program_id"), rs.getString("program_aname"),
						rs.getString("program_ename"));
				SchoolDAO dao = new SchoolDAO();
				School school = dao.selectbyId(rs.getInt("school_id"));
				program.setSchool(school);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return program;
	}

	// **Select all**

	public List<Program> selectall() {
		programTable = new ArrayList<Program>();
		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select school_id, program_id, program_aname, program_ename from program order by school_id, program_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				Program program = new Program();

				SchoolDAO schooldao = new SchoolDAO();
				School school = schooldao.selectbyId(rs.getInt("school_id"));
				program.setSchool(school);

				program.setProgram_id(rs.getInt("program_id"));
				program.setProgram_aname(rs.getString("program_aname"));
				program.setProgram_ename(rs.getString("program_ename"));

				programTable.add(program);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return programTable;
	}

	// **insert**

	public int insert(Program program) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into program (school_id, program_id, program_aname, program_ename) values (?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, program.getSchool().getSchool_id());
			ps.setInt(counter++, program.getProgram_id());
			ps.setString(counter++, program.getProgram_aname());
			ps.setString(counter++, program.getProgram_ename());

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

	public int update(Program program) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update program set school_id=?, program_aname= ?, program_ename= ? where program_id= ?");

			int counter = 1;
			ps.setInt(counter++, program.getSchool().getSchool_id());
			ps.setString(counter++, program.getProgram_aname());
			ps.setString(counter++, program.getProgram_ename());
			ps.setInt(counter++, program.getProgram_id());

			row = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return row;
	}

	// ** Delete**

	public int delete(int program_id) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete program where program_id= ?");
			ps.setInt(1, program_id);
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
