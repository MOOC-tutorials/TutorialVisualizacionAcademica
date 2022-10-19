package coursemanager.model;

/**<br> This class manages the message information such as all its characteristics <\br>
*/
public class CMessage 
{
	/**
	 * Subject of the message
	 */
	private String sSubject;
	
	/**
	 * Body of the message
	 */
	private String sMessage;
	
	/**
	 * Indicates who sends the message
	 */
	private String sFrom;
	
	/**
	 * Indicates is the message is readed or not
	 */
	private boolean bReaded;
	
	/**
	 * Indicates the id of the message
	 */
	private int id;
	
	/**
	   * Class constructor 
	   * @@pre: true 
	   * @@post: A message's instance is created 
	   */ 
	public CMessage()
	{
		sSubject = "";
		sMessage = "";
		sFrom = "";
		bReaded = false; 
		id = -1;
	}
	
	/**
	 * Class constructor
	 * @@pre: psFrom, psSubject, psMessage and pnId are not NULL.
	 * @@pos: Creates a message with the respective parameters.
	 */ 
	public CMessage(String psFrom, String psSubject, String psMessage, int pnId)
	{
		sSubject = psSubject;
		sMessage = psMessage;
		sFrom = psFrom;
		bReaded = false;
		id = pnId;
	}

	/**
	 * @@brief: This method returns de autor of the message   
	 * @@pre: true     
	 * @@post: The autor of the message is given 
	 * @@param: none
	 * @@return: String 
	 */
	public String getFrom() 
	{
		return sFrom;
	}

	/**
	 * @@brief: This method returns de content of the message   
	 * @@pre: true     
	 * @@post: The content of the message is given 
	 * @@param: none
	 * @@return: String 
	 */
	public String getMessage() 
	{
		return sMessage;
	}

	/**
	 * @@brief: This method returns de subject the message   
	 * @@pre: true     
	 * @@post: The subject of the message is given 
	 * @@param: none
	 * @@return: String 
	 */
	public String getSubject() 
	{
		return sSubject;
	}
	
	/**
	 * @@brief: This method returns de identification of the message   
	 * @@pre: true     
	 * @@post: The identification of the message is given 
	 * @@param: none
	 * @@return: int 
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * @@brief: Mark the message as readed   
	 * @@pre: the message exist     
	 * @@post: The message apears like readed 
	 * @@param: none
	 * @@return: void 
	 */
	public void readMessage()
	{
		bReaded = true;
	}

	/**
	 * @@brief: Indicates if the message is readed or not   
	 * @@pre: the message exist     
	 * @@post: You know if the message is readed 
	 * @@param: none
	 * @@return: boolean 
	 */
	public boolean isReaded() 
	{
		return bReaded;
	}
	
	/**
	 * @@brief: Returns a mutable string with the serialization of this class, in the format defined below.   
	 * @@pre: sSubject != null, sMessage != null, sFrom != null, bReaded != null, id != -1       
	 * @@post: A StringBuilder containing the serialized object is returned, null otherwise 
	 * @@param: void
	 * @@return: StringBuilder Contains the serialized object 
	 * @@aditional_description: This is the format to be used: id\From\nSubject\nReaded\nMessage\n
	 */
	public StringBuilder serialize ( )
	{
		StringBuilder sbSerial = new StringBuilder();
		sbSerial.append(id);
		sbSerial.append('\n');
		sbSerial.append(sFrom);
		sbSerial.append('\n');
		sbSerial.append(sSubject);
		sbSerial.append('\n');
		sbSerial.append(bReaded);
		sbSerial.append('\n');
		sbSerial.append(sMessage);
		sbSerial.append("\nend\n");		
		return sbSerial;
	}
}