
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Program;
import Bean.School;
import Bean.Student;
import Bean.University;
import Database.Databasea;

public class StudentDAO {

	private Databasea db;
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private ArrayList<Student> studentTable;
	private int row;

	// **select by Id **

	public Student selectbyId(int student_id) {
		Student student = null;

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, student_aname, student_ename, birthdate, sex, mobile,email, university_id, school_id, program_id,final_avaerage, max_avareage, rate, graduate_year, graduate_sem from student where student_id= ?");

			ps.setInt(1, student_id);
			rs = ps.executeQuery();
			if (rs.next()) {

				student = new Student(rs.getInt("student_id"), rs.getString("student_aname"),
						rs.getString("student_ename"), rs.getDate("birthdate"), rs.getInt("sex"),
						rs.getString("mobile"), rs.getString("email"), rs.getInt("final_avaerage"),
						rs.getInt("max_avareage"), rs.getString("rate"), rs.getInt("graduate_year"),
						rs.getInt("graduate_sem"));
				SchoolDAO daos = new SchoolDAO();
				School school = daos.selectbyId(rs.getInt("school_id"));
				student.setSchool(school);

				ProgramDAO daop = new ProgramDAO();
				Program program = daop.selectbyIdp(rs.getInt("program_id"));
				student.setProgram(program);

				UniversityDAO daou = new UniversityDAO();
				University university = daou.selectbyId(rs.getInt("university_id"));
				student.setUniversity(university);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return student;
	}

	// **Select all**

	public List<Student> selectall() {

		studentTable = new ArrayList<Student>();
		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id, student_aname, student_ename, birthdate, sex, mobile,email, university_id, school_id, program_id, final_avaerage, max_avareage,rate, graduate_year,graduate_sem from student order by student_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();

				student.setStudent_id(rs.getInt("student_id"));
				student.setStudent_aname(rs.getString("student_aname"));
				student.setStudent_ename(rs.getString("student_ename"));
				student.setBirthdate(rs.getDate("birthdate"));
				student.setSex(rs.getInt("sex"));
				student.setMobile(rs.getString("mobile"));
				student.setEmail(rs.getString("email"));

				SchoolDAO daos = new SchoolDAO();
				School school = daos.selectbyId(rs.getInt("school_id"));
				student.setSchool(school);

				ProgramDAO daop = new ProgramDAO();
				Program program = daop.selectbyIdp(rs.getInt("program_id"));
				student.setProgram(program);

				UniversityDAO daou = new UniversityDAO();
				University university = daou.selectbyId(rs.getInt("university_id"));
				student.setUniversity(university);

				student.setFinal_avarage(rs.getInt("final_avaerage"));
				student.setMax_avarage(rs.getInt("max_avareage"));
				student.setRate(rs.getString("rate"));
				student.setGraduate_year(rs.getInt("graduate_year"));
				student.setSem(rs.getInt("graduate_sem"));

				studentTable.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Databasea.close(ps);
			Databasea.close(connection);
		}
		return studentTable;
	}

	// **insert**

	public int insert(Student student) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student (student_id, student_aname, student_ename, birthdate, sex, mobile,email, university_id, school_id, program_id, final_avaerage, max_avareage, rate, graduate_year, graduate_sem) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, student.getStudent_id());
			ps.setString(counter++, student.getStudent_aname());
			ps.setString(counter++, student.getStudent_ename());
			ps.setDate(counter++, new Date(student.getBirthdate().getTime()));
			ps.setInt(counter++, student.getSex());
			ps.setString(counter++, student.getMobile());
			ps.setString(counter++, student.getEmail());
			ps.setInt(counter++, student.getUniversity().getUniversity_id());
			ps.setInt(counter++, student.getSchool().getSchool_id());
			ps.setInt(counter++, student.getProgram().getProgram_id());
			ps.setInt(counter++, student.getFinal_avarage());
			ps.setInt(counter++, student.getMax_avarage());
			ps.setString(counter++, student.getRate());
			ps.setInt(counter++, student.getGraduate_year());
			ps.setInt(counter++, student.getSem());

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

	public int update(Student student) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"update student set student_aname=?,student_ename=?, birthdate=?, sex=?, mobile=?,email=?, university_id=?, school_id=?, program_id=?, final_avaerage=?, max_avareage=?,rate=?, graduate_year=?,graduate_sem=? where student_id=? ");

			int counter = 1;
			ps.setString(counter++, student.getStudent_aname());
			ps.setString(counter++, student.getStudent_ename());
			ps.setDate(counter++, new Date(student.getBirthdate().getTime()));
			ps.setInt(counter++, student.getSex());
			ps.setString(counter++, student.getMobile());
			ps.setString(counter++, student.getEmail());
			ps.setInt(counter++, student.getUniversity().getUniversity_id());
			ps.setInt(counter++, student.getSchool().getSchool_id());
			ps.setInt(counter++, student.getProgram().getProgram_id());
			ps.setInt(counter++, student.getFinal_avarage());
			ps.setInt(counter++, student.getMax_avarage());
			ps.setString(counter++, student.getRate());
			ps.setInt(counter++, student.getGraduate_year());
			ps.setInt(counter++, student.getSem());
			ps.setInt(counter++, student.getStudent_id());

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

	public int delete(int student_id) {

		try {
			db = new Databasea();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete student where student_id= ?");
			ps.setInt(1, student_id);
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
