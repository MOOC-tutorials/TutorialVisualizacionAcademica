package coursemanager.persistence;

import java.util.ArrayList;

import coursemanager.model.CCurriculum;
import coursemanager.model.CRulesAdmin;



public class AcademicProgramFields {
	
	/**
	 * Au lieu d'acceder aux champs via leur position, ont fera reference au champs via un code unique.
	 * L'idee est de toujours utilise ce code (le nom de la variable) au lieu du chiffre, pour referer
	 * a un champ.
	 */
	public static final int ITEM_ID = 0;
	public static final int NAME = 1;
	public static final int CODE = 2;
	public static final int COORDINATOR = 3;
	public static final int STUDENTS = 4;
	public static final int CURRICULUM = 5;
	public static final int RULES = 6;
	public static final int MESSAGES = 7;
	
	/**
	 * Retourne le nom du champ correspondant pour un fieldCode donne.
	 * @param fieldCode - code du champ demandé.
	 * @return String - nom du champ correspondant au code donne.
	 */
	public static String getFieldName(int fieldCode){
		switch(fieldCode){
		case ITEM_ID: return "Id";
		case NAME: return "Name";
		case CODE: return "Code";
		case COORDINATOR: return "Coordinator";
		case STUDENTS: return "Students";
		case CURRICULUM: return "Curriculum";
		case RULES: return "Rules";
		case MESSAGES: return "Messages";
		default: return null;
		}
	}
		
	/**
	 * Retourne le type du champ pour un fieldCode donne.
	 * @param fieldCode - Code du champ demande.
	 * @return Class<?> - La classe correspondant au parametre donne
	 */
	public static Class<?> getFieldType(int fieldCode) {
		switch(fieldCode){
		case ITEM_ID: return Integer.class;
		case NAME: return String.class;
		case CODE: return String.class;
		case COORDINATOR: return String.class;
		case STUDENTS: return ArrayList.class;
		case CURRICULUM: return CCurriculum.class;
		case RULES: return CRulesAdmin.class;
		case MESSAGES: return ArrayList.class;
		default: return null;
		}
	}	
}
