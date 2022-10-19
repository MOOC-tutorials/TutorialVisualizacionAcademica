/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     CoordinatorMenu.java 
 * @@brief    
 * @@version  1.0
 * @@par      
 *                      
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
public class CoordinatorMenu extends JFrame implements ActionListener {
    /**
     * Constants
     */
    public final static String INGRESAR = "Ingresar Nuevo Estudiante";
    public final static String FOLDER = "Folder Virtual";
    public final static String ACAD_PROG = "Modificar programa acad�mico";
    public final static String EXIT = "Salir";
    public final static String STUD_PER_INFO = "Modficar Informaci�n personal Estudiante";
    public final static String STUD_ACAD_INFO = "Modificar Informaci�n Acad�mica Estudiantes";
    public final static String LOGOUT = "log out";
	private static final String SAVE = "save";
	private final static String LOAD = "load";
    
    private CManager manager;
    private JFrame logIn;
    private JLabel textArea1 = new JLabel();
    private JLabel textArea2 = new JLabel();
    private JLabel textArea3 = new JLabel();
    private JButton logOut = new JButton();
    
    /** exit Button */
    private JButton button = new JButton(new ImageIcon("data/salirMenu.JPG"));
    
    private JFrame AddNewStudent;
    private AddNewStudent pan;
    private SearchStudent sai;
	private SetAcademicInformation pi;
	private SetAcademicProgram sap;
	private PersonnellInformation persInformation;
    private JFrame SetAcademicInformation;
	/**
	 * Button to add a new student
	 */
	private JButton button1 = new JButton(new ImageIcon("data/estudiantes.jpg"));
	
	/**
	 * Button to see an student academic information
	 */
	private JButton button2 = new JButton(new ImageIcon("data/acadecInfo.jpg"));
	
	/**
	 * Button to modify an student personal info
	 */
	private JButton button3 = new JButton(new ImageIcon("data/personalInfo.JPG"));
	
	/**
	 * button to modify the academic program
	 */
	private JButton button4 = new JButton(new ImageIcon("data/pensum_small.jpg"));
	
	/**
	 * Button to acces virtual folder
	 */
	private JButton button5 = new JButton(new ImageIcon("data/folderVirtual.jpg"));
	
	private JButton bSave = new JButton(new ImageIcon("data/save.JPG"));
	
	private VirtualFolderMenu vfMenu;
	
	/**
	 * Class Constructor
	 * @@pre:
	 * @@pos:
	 */
	public CoordinatorMenu()
	{		
		pan = new AddNewStudent();
		sai = new SearchStudent();
		pi = new SetAcademicInformation();
		sap = new SetAcademicProgram();
		vfMenu = new VirtualFolderMenu();
		this.persInformation = new PersonnellInformation();
		
		
		// Frame configuration data
    	setTitle("Men� Coordinador - CriolloSoft");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel label1 = new JLabel();
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel labelButton1 = new JLabel();
    	JLabel labelButton2 = new JLabel();
    	JLabel labelButton3 = new JLabel();
    	JLabel labelButton4 = new JLabel();
    	JLabel labelButton5 = new JLabel();
    	// components boot
    	label1.setText("MEN� COORDINADOR");
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	logOut.setFont(new Font("Serif", Font.BOLD, 18));
    	logOut.setBackground(new java.awt.Color(239, 239, 239));
    	logOut.setText("Log out");
    	label1.setFont(new Font("Serif", Font.BOLD, 20));
    	labelButton1.setText("Ingresar Estudiante");
    	labelButton1.setForeground(new java.awt.Color(0, 0, 204));
    	labelButton1.setFont(new Font("Serif", Font.PLAIN, 12));
    	labelButton2.setText("Modificar Informaci�n Acad�mica Estudiante");
    	labelButton2.setForeground(new java.awt.Color(0, 0, 204));
    	labelButton2.setFont(new Font("Serif", Font.PLAIN, 11));
    	labelButton3.setText("Modificar Informaci�n Personal Estudiante");
    	labelButton3.setForeground(new java.awt.Color(0, 0, 204));
    	labelButton3.setFont(new Font("Serif", Font.PLAIN, 11));
    	labelButton4.setText("Modificar Programa Acad�mico");
    	labelButton4.setForeground(new java.awt.Color(0, 0, 204));
    	labelButton4.setFont(new Font("Serif", Font.PLAIN, 12));
    	labelButton5.setText("Folder Virtual");
    	labelButton5.setForeground(new java.awt.Color(0, 0, 204));
    	labelButton5.setFont(new Font("Serif", Font.PLAIN, 12));
    	label.setToolTipText("Regresar al men�");
    	button1.setToolTipText("Forma para ingreso de estudiantes");
    	//Set components position
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label.setBounds(10, 10, 159, 112);
    	logOut.setBounds(700, 230, 159, 21);
    	label1.setBounds(15, 230, 260, 21);
    	button1.setBounds(15, 320, 109, 104);
    	labelButton1.setBounds(22, 424, 120, 21);
    	button2.setBounds(197, 320, 109, 104);
    	labelButton2.setBounds(164, 424, 240, 21);
    	button3.setBounds(407, 320, 109, 104);
    	labelButton3.setBounds(382, 425, 240, 21);
    	button4.setBounds(613, 320, 109, 104);
    	labelButton4.setBounds(595, 424, 210, 21);
    	button5.setBounds(770, 320, 109, 104);
    	labelButton5.setBounds(790, 424, 120, 21);
    	button.setBounds(820, 520, 63, 37);
    	bSave.setBounds(750, 520, 63, 37);
  
    	//add components
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(logOut);
    	add(button);
    	add(label);
    	add(label1);
    	add(button1);
    	add(labelButton1);
    	add(button2);
    	add(labelButton2);
    	add(button3);
    	add(labelButton3);
    	add(button4);
    	add(labelButton4);
    	add(button5);
    	add(labelButton5);
    	add(bSave);
    
    	//    	listeners
    	//label.addMouseMotionListener(mouseDragged());
    	logOut.setActionCommand(LOGOUT);
        logOut.addActionListener(this);
    	button1.setActionCommand(INGRESAR);
        button1.addActionListener(this);
        button2.setActionCommand(STUD_ACAD_INFO);
        button2.addActionListener(this);
        button3.setActionCommand(STUD_PER_INFO);
        button3.addActionListener(this);
        button4.setActionCommand(ACAD_PROG);
        button4.addActionListener(this);
        button5.setActionCommand(FOLDER);
        button5.addActionListener(this);
        button.setActionCommand(EXIT);
        button.addActionListener(this);
        bSave.setActionCommand(SAVE);
        bSave.addActionListener(this);
       // bLoad.setActionCommand(LOAD);
        //bLoad.addActionListener(this);
	}
	
	/**
     * @@brief: Answer to the events in the elements of the interface.    
     * @@pre:     
     * @@post:
     * @@param: ActionEvent  
     * @@return: void
     * @@aditional_description:   
     */
	public void actionPerformed(ActionEvent event)
    {
		String command = event.getActionCommand( );
    	if( command.equals( INGRESAR ))	//Call of button to open entrance form for a new student
        {
    		pan.setManager(manager);
    		pan.setVisible(true);
    		pan.setCordMenu(this);
    		this.setVisible(false);
        }    
    	else if( command.equals(STUD_ACAD_INFO))	//Call of button to open entrance form for a new student
        {
    		String nomStudent = JOptionPane.showInputDialog(this,"Ingrese el codigo del estudiante del \n cual quiere ver la informacion");   		
    		pi.setCordMenu(this);
    		this.setVisible(false);
    		pi.setVisible(true);
        } 
    	else if(command.equals(STUD_PER_INFO))
    	{
      		String code = JOptionPane.showInputDialog(this,"Ingrese el codigo del estudiante del \n cual quiere ver la informacion");
			Integer codeNum = new Integer (code);
			persInformation.setManager(manager);
			persInformation.setfields(codeNum.intValue());
			this.persInformation.setLastFrame(this);			
			this.persInformation.getTittle().setText("Actualizar Informacion Personal Estudiante");
			this.persInformation.setJustSeeing(false);
			this.persInformation.enableFieldsModify();			
			this.persInformation.setVisible(true);
			this.setVisible(false);
    	}
    	else if(command.equals(ACAD_PROG))
    	{
    		sap.setLastFrame(this);
    		sap.setVisible(true);
    		this.setVisible(false);
    		
    	}
    	else if(command.equals(FOLDER))
    	{
    		vfMenu.setVisible(true);
    		vfMenu.setLastFrame(this);
    		this.setVisible(false);    		
    	}
    	else if(command.equals(LOGOUT))
    	{
    		logIn.setVisible(true);    	
    		manager.LogOut();
    		setVisible(false);	
    	}
    	else if(command.equals(EXIT))
    	{
    		System.exit( 0 );
    	}
    	else if(command.equals(SAVE))
    	{
    		CodRes res = manager.saveWorld();
    		
    		if ( res == CodRes.SUCCESS)
    		{
    			JOptionPane pane = new JOptionPane();
        		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
        		JOptionPane.showMessageDialog(null, "La informaci�n se guard� correctamente", "Exito", 2);
    		}
    		else
    		{
    			JOptionPane pane = new JOptionPane();
        		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
        		JOptionPane.showMessageDialog(null, "No se pudo guardar.", "Error", 0);    			
    		}
    	}
    }
  

	public void setManager(CManager manager2) 
	{
		manager = manager2;		
	}
	
	public void setLogIn(JFrame nLogIn)
	{
		logIn = nLogIn;
	}
	
	public void throwManager()
	{
		pan.setManager(manager);
		sai.setManager(manager);
		sai.throwManager();
		pi.setManager(manager);
		sap.setManager(manager);
		sap.throwManager();
		vfMenu.setManager(manager);
		vfMenu.throwManager();
	}
}