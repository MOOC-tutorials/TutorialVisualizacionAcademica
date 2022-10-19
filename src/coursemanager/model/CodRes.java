/**
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CodRes.java 
 * @@brief    enumeration class
 * @@version  1.0
 * @@date     24/03/2006
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     
 * @@bug     
 */
//--------- Present package declaration
package coursemanager.model;

//--------- Standar Libraries import


//--------- Own libraries import 


//-------- Class declaration and documentation
/**<br> This enumeration saves the enumeration for the result code <\br>
 * @@invariant: None
 */
public enum CodRes {
	OBJECT_NOT_FOUND (-1),
	SUCCESS (-2),
	ERROR (-3),
	INVALID_ARGUMENTS (-4),
	ALREADY_EXISTS (-5),
	INEXISTENT (-6),
	NOT_IN_CURRICULUM (-7),
	NEW_RULE (-8),
	USER_NOT_FOUND (-9),
	COORDINATOR (-10),
	ADVISOR (-11),
	STUDENT (-12),
	PREREQ (-13),
	COREQ (-14),
	FULL (-15),
	INVALID_MOVE (-16), 
	INVALID_MOVE_MULTIPLE_COURSES (-17), 
	INVALID_SEMESTER (-18), 
	LEVEL_ERROR (-19);
	
	private final int code;
	CodRes(int code)
	{
		this.code =code;
	}
}