package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import Bean.Program;
import DAO.ProgramDAO;

@ManagedBean(name = "mbProgram")
public class MBProgram {

	private List<Program> programTable;
	private ProgramDAO programDAO;
	private Program SelectedProgram;
	private boolean propertyName;

	@PostConstruct
	public void init() {
		programDAO = new ProgramDAO();
		programTable = programDAO.selectall();
		SelectedProgram = new Program();
	}

	public void checkselection() {
		System.out.println("1111");
		System.out.println(getSelectedProgram());
	}

	public String updateProgram() {
		System.out.println("updated");
		programDAO.update(SelectedProgram);
		programTable = programDAO.selectall();
		System.out.println("x");
		return null;
	}

	public String removeProgram() {
		programDAO.delete(SelectedProgram.getProgram_id());
		programTable = programDAO.selectall();
		return null;
	}

	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public ProgramDAO getProgramDAO() {
		return programDAO;
	}

	public void setProgramDAO(ProgramDAO programDAO) {
		this.programDAO = programDAO;
	}

	public Program getSelectedProgram() {
		return SelectedProgram;
	}

	public void setSelectedProgram(Program selectedProgram) {
		SelectedProgram = selectedProgram;
	}

	public boolean isPropertyName() {
		return propertyName;
	}

	public void setPropertyName(boolean propertyName) {
		this.propertyName = propertyName;
	}

}
