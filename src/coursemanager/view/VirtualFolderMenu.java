/*
 * @@Project  c2_Visualizacion_Control_Informacion_Academica
 * @@file     VirtualFolderMenu.java 
 * @@brief    
 * @@version  1.0
 * @@par                           
 * @@todo     
 * @@bug     
 */
//--------- Present package declaration
package coursemanager.view;

//--------- Standar Libraries import
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief: Frame to display coordinators menu.       
 * @@invariant:   
 * @@par:  	
 */
public class VirtualFolderMenu extends JFrame implements ActionListener{
	/**
     * Constants
     */
    public final static String CURRICULO = "Crear curriculo";
    public final static String EXIT = "exit";
    public final static String MESSAGE = "messsage";
    public final static String EXCEPT = "exception";
    public final static String FAULT = "fault";
    public final static String GOBACK = "goback";
	private static final String INBOX = "inbox";
    
	private JLabel textArea1 = new JLabel();
    private JLabel textArea2 = new JLabel();
    private JLabel textArea3 = new JLabel();
    
	private JLabel mLabel = new JLabel("Envio de mensajes");
	
	private JButton message = new JButton(new ImageIcon("data/mail.JPG"));
	
	private JButton bInbox = new JButton(new ImageIcon("data/buzonCorreo.JPG"));
	
	private JLabel cLabel = new JLabel("Organizar curriculo");
	
	private JButton curriculumB = new JButton(new ImageIcon("data/cur2.JPG"));
	
	private JLabel fLabel = new JLabel("Amonestar estudiantes");
	
	private JLabel inboxLabel = new JLabel("Bandeja Mensajes");
	
	private JButton fault = new JButton(new ImageIcon("data/fault.JPG"));
	
	private JLabel eLabel = new JLabel("Generar excepciones estudiantes");
	
	private JButton exception = new JButton(new ImageIcon("data/excepcion.JPG"));
	
	private JButton button = new JButton(new ImageIcon("data/salirMenu.JPG"));
	
	private JButton bGoBack= new JButton(new ImageIcon ("data/volver.JPG"));
	
	private JFrame lastFrame;
	
	private CManager manager;
	
	private CreateCurriculum curriculum;
	
	private MessageInterface messages;
	
	private DiciplinaryFault dicFault;
	
	private CourseExceptions exceptions;
	
	private Inbox inbox;
	
	public VirtualFolderMenu()
	{
		curriculum = new CreateCurriculum();
		messages = new MessageInterface();
		dicFault = new DiciplinaryFault();
		exceptions = new CourseExceptions();
		inbox = new Inbox ();
		JLabel label1 = new JLabel("MEN� DE FOLDER VIRTUAL");
		JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
		//		 Frame configuration data
    	setTitle("Men� de folder Virtual");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	
    	label1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	mLabel.setFont(new Font("Serif", Font.BOLD, 16));
    	cLabel.setFont(new Font("Serif", Font.BOLD, 16));
    	fLabel.setFont(new Font("Serif", Font.BOLD, 16));
    	inboxLabel.setFont(new Font("Serif", Font.BOLD, 16));
    	eLabel.setFont(new Font("Serif", Font.BOLD, 16));
    	//    	Set components position
    	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label1.setBounds(15, 230, 280, 21);
    	curriculumB.setBounds(160, 280, 100, 100);
    	cLabel.setBounds(280, 320, 240, 26);
    	message.setBounds(40, 400, 100, 100);
    	bInbox.setBounds(600, 400, 100, 100);
    	mLabel.setBounds(150, 440, 240, 26);
    	exception.setBounds(450, 280, 100, 100);
    	eLabel.setBounds(570, 320, 260, 26);
    	fault.setBounds(300, 400, 100, 100);
    	fLabel.setBounds(410, 440, 240, 26);
    	inboxLabel.setBounds(720, 440, 240, 26);
    	button.setBounds(820, 520, 63, 37);
    	bGoBack.setBounds(730, 523, 63, 37);
    	//    	add components
    	add(label);
    	add(label1);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(curriculumB);
    	add(cLabel);
    	add(exception);
    	add(eLabel);
    	add(message);
    	add(bInbox);
    	add(mLabel);
    	add(fault);
    	add(fLabel);
    	add(inboxLabel);
    	add(bGoBack);
    	add(button);
    	
    	curriculumB.addActionListener(this);
    	curriculumB.setActionCommand(CURRICULO);
    	fault.addActionListener(this);
    	fault.setActionCommand(FAULT);
    	exception.addActionListener(this);
    	exception.setActionCommand(EXCEPT);
    	button.addActionListener(this);
    	button.setActionCommand(EXIT);
    	message.addActionListener(this);
    	message.setActionCommand(MESSAGE);
    	bInbox.addActionListener(this);
    	bInbox.setActionCommand(INBOX);
    	bGoBack.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
    	throwManager();
	}
	
	
	public void actionPerformed(ActionEvent event) 
	{
		String command = event.getActionCommand( );
		if( command.equals(CURRICULO))
		{
			curriculum.setVisible(true);
			curriculum.setLastFrame(this);
			curriculum.loadCurricCoursesComboBox();
			curriculum.loadCurriculumCourses();
			curriculum.loadAreas();
			setVisible(false);
		}
		else if(command.equals(MESSAGE))
		{
			messages.setLastFrame(this);
			messages.setVisible(true);
			setVisible(false);
		}
		else if( command.equalsIgnoreCase(FAULT))
		{
			dicFault.setLastFrame(this);
			dicFault.setVisible(true);
			setVisible(false);
		}
		else if( command.equalsIgnoreCase(EXCEPT))
		{
			exceptions.setLastFrame(this);
			exceptions.setVisible(true);
			setVisible(false);
		}
		else if(command.equalsIgnoreCase(INBOX))
		{
			inbox.setLastFrame(this);
			inbox.cleanMailBox();
			inbox.loadMessage();
			inbox.setVisible(true);
			this.setVisible(false);			
		}
		else if(command.equalsIgnoreCase(GOBACK))
		{
				this.lastFrame.setVisible(true);
				this.setVisible(false);			
		}
		else if(command.equals(EXIT))
    	{
			System.exit( 0 );	
    	}
	}


	public void setManager(CManager manager2) 
	{
		manager = manager2;	
	}


	public void throwManager() 
	{
		curriculum.setManager(manager);	
		messages.setManager(manager);
		dicFault.setManager(manager);
		exceptions.setManager(manager);
		inbox.setManager(manager);
	}


	public void setLastFrame(CoordinatorMenu menu) 
	{
		lastFrame = menu;	
	}
}