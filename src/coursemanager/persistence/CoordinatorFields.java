package coursemanager.persistence;


public class CoordinatorFields {
	
	public static final int ITEM_ID = 0;
	public static final int NAME = 1;
	public static final int DEPARTMENT = 2;
	public static final int PASSWORD = 3;
	
	public static String getFieldName(int fieldCode){
		switch(fieldCode){
		case ITEM_ID: return "Id";
		case NAME: return "Name";
		case DEPARTMENT: return "Department";
		case PASSWORD: return "Password";
		default: return null;
		}
	}
		
	public static Class<?> getFieldType(int fieldCode) {
		switch(fieldCode){
		case ITEM_ID: return Integer.class;
		case NAME: return String.class;
		case PASSWORD: return String.class;
		case DEPARTMENT: return Integer.class;
		default: return null;
		}
	}	
}
