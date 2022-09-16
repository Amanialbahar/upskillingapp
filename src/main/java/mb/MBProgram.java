package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Bean.Program;
import DAO.ProgramDAO;
import report.Reports;

@ViewScoped
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
		System.out.println("SelectedProgram: " + SelectedProgram);
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

	public String runProReport() throws Exception {

//		Map<String, Object> param = new HashMap<String, Object>();
//		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/image/HTULogo-250px.png"));
//		param.put("p_image", image);

		Reports report = new Reports();
		report.runPdf("program.jasper", null);

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
		if (SelectedProgram == null) {
			SelectedProgram = new Program();
		}
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
