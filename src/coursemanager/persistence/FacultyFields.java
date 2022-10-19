package coursemanager.persistence;

import java.util.ArrayList;

public class FacultyFields {
	
	/**
	 * Au lieu d'acceder aux champs via leur position, ont fera reference au champs via un code unique.
	 * L'idee est de toujours utilise ce code (le nom de la variable) au lieu du chiffre, pour referer
	 * a un champ.
	 */
	public static final int ITEM_ID = 0;
	public static final int NAME = 1;
	public static final int DEPARTMENTS = 2;
	
	/**
	 * Retourne le nom du champ correspondant pour un fieldCode donne.
	 * @param fieldCode - code du champ demand�.
	 * @return String - nom du champ correspondant au code donne.
	 */
	public static String getFieldName(int fieldCode){
		switch(fieldCode){
		case ITEM_ID: return "Id";
		case NAME: return "Name";
		case DEPARTMENTS: return "Departments";
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
		case DEPARTMENTS: return ArrayList.class;
		default: return null;
		}
	}	
}
