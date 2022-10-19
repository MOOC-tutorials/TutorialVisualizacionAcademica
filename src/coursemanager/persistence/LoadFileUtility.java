package coursemanager.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import coursemanager.model.CAcademicProgram;
import coursemanager.model.CCourse;
import coursemanager.model.CDepartment;
import coursemanager.model.CFaculty;
import coursemanager.model.CLogCoor;
import coursemanager.view.Welcome;


/**
 * 
 */
public class LoadFileUtility
{
	private static ArrayList<CCourse> courses = new ArrayList<CCourse>();
	private static ArrayList<CDepartment> departments = new ArrayList<CDepartment>();
	private static ArrayList<CLogCoor> coordinators = new ArrayList<CLogCoor>();
	private static ArrayList<CAcademicProgram> academicPrograms = new ArrayList<CAcademicProgram>();
	
	public static ArrayList<CCourse> getCourses()
	{
		return courses;
	}

	public static ArrayList<CDepartment> getDepartments()
	{
		return departments;
	}

	public static ArrayList<CLogCoor> getCoordinators()
	{
		return coordinators;
	}

	public static ArrayList<CAcademicProgram> getAcademicPrograms() {
		return academicPrograms;
	}
	
	public static Collection<List<String[]>> loadRawRegistersFromFile(String fileName) throws IOException{
		TextReader t = new TextReader(fileName);
		t.readFile();
		return new TextReader(fileName).readFile();
	}

	public static void initCoursesWithRegisters(Collection<List<String[]>> rawRegisters) {
		for(List<String[]> rawRegister : rawRegisters) {
			CCourse course = new CCourse();
			for(String[] data  : rawRegister){
				course.assignCourseFieldWithData(data[0], data[1]);
			}
			courses.add(course);
		}
	}
	
	public static void initCoordinatorsWithRegisters(Collection<List<String[]>> rawRegisters) {
		for(List<String[]> rawRegister : rawRegisters) {
			CLogCoor coor = new CLogCoor();
			for(String[] data  : rawRegister){
				coor.assignCoordinatorFieldWithData(data[0], data[1]);
			}
			Welcome.getManager().getLogin().addCoordinator(coor);
		}
	}
	
	public static void initDepartmentsWithRegisters(Collection<List<String[]>> rawRegisters) {
		for(List<String[]> rawRegister : rawRegisters) {
			CDepartment dep = new CDepartment();
			for(String[] data  : rawRegister){
				dep.assignDepartmentFieldWithData(data[0], data[1]);
			}
			departments.add(dep);
		}
	}
	
	public static void initFacultiesWithRegisters(Collection<List<String[]>> rawRegisters) {
		for(List<String[]> rawRegister : rawRegisters) {
			CFaculty fac = new CFaculty();
			for(String[] data  : rawRegister){
				fac.assignFacultyFieldWithData(data[0], data[1]);
			}
			Welcome.getManager().addFaculty(fac);
		}
	}
	
	public static void initProgramsWithRegisters(Collection<List<String[]>> rawRegisters) {
		for(List<String[]> rawRegister : rawRegisters) {
			CAcademicProgram program = new CAcademicProgram();
			for(String[] data  : rawRegister){
				program.assignAcademicProgramFieldWithData(data[0], data[1]);
			}
			academicPrograms.add(program);
		}
	}
}
