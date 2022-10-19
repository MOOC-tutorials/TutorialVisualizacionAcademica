/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import coursemanager.controller.CManager;



/**
 * @@author Familia
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StudentMenu extends JFrame implements ActionListener{
	
	private final static String EXIT = "exit";
	private final static String PERSONNEL = "personnel";
	private final static String SETPERSONNEL = "setpersonnel";
	private final static String ACADEMIC = "academic";
	private final static String FOLDER = "folder";
	private static final String LOGOUT = "logout";
	
	private JButton bExit ;
	private JButton bPersonInformat;
	private JButton bSetPersoInfor;
	private JButton bAcadmicInfor;
	private JButton bVirtFold;
	private ShowAcademicInformation acadeInf;
	private PersonnellInformation persInformation;
	private StudentVirtualFolder studVF;
	private CManager manager;
	private JButton logOut;
	private JFrame fLogIn;
	
	public StudentMenu()
    {	
		this.persInformation = new PersonnellInformation();
		this.acadeInf = new ShowAcademicInformation();
		studVF = new StudentVirtualFolder();
		
		setTitle( "Menu Estudiante - CriolloSoft" );
        setSize( 900, 600 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        getContentPane().setLayout (new BorderLayout());
        JPanel picture = new JPanel ();
 		picture.setLayout(null);
		picture.setPreferredSize(new Dimension(900,205));
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel();
    	JLabel textArea1 = new JLabel();
    	JLabel textArea2 = new JLabel();
    	JLabel textArea3 = new JLabel();
    	JLabel tittle = new JLabel();    	
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	title.setText("Men� Estudiante"); 
    	title.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	// Set components position
    	textArea1.setBounds(280, 30, 460, 30);
    	textArea2.setBounds(280, 60, 460, 30);
    	textArea3.setBounds(280, 90, 460, 30);
    	label.setBounds(30, 20, 159, 112);
    	title.setBounds(126, 180, 450, 21);
    	// add components
    	picture.add(label);
    	picture.add(title);
    	picture.add(textArea1);
    	picture.add(textArea2);
    	picture.add(textArea3);
    	picture.add(tittle);

    	getContentPane().add(picture,BorderLayout.NORTH);
        JPanel principal = new JPanel ();
        principal.setLayout(new BorderLayout());
        getContentPane().add(principal,BorderLayout.CENTER);
        JPanel exit = new JPanel ();
        exit.setLayout(new BorderLayout());
        exit.setPreferredSize(new Dimension(900,50));
        exit.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        getContentPane().add(exit,BorderLayout.SOUTH);

        logOut = new JButton ("LogOut");
        logOut.setFont(new Font("Serif", Font.BOLD, 18));
    	logOut.setBackground(new java.awt.Color(239, 239, 239));
    	logOut.setText("Log out");
    	logOut.setBounds(700, 210, 159, 21);
    	getContentPane().add(logOut);
    	
        bExit = new JButton (new ImageIcon ("data/salirMenu.JPG"));
        exit.add(bExit,BorderLayout.EAST);
        
        JPanel menu = new JPanel ();
        getContentPane().add(menu,BorderLayout.CENTER);
        menu.setLayout(new GridLayout(2,3));
        menu.setBorder(BorderFactory.createEmptyBorder(20,150,20,150));
       
        
        
        JPanel persoInformat = new JPanel ();
        persoInformat.setLayout (new BorderLayout());
        persoInformat.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        JLabel nPI = new JLabel ("   Ver Informacion Personal");
        persoInformat.add(nPI,BorderLayout.CENTER);
        nPI.setPreferredSize(new Dimension (150,40));
        bPersonInformat = new JButton (new ImageIcon("data/personal.JPG"));
        persoInformat.add(bPersonInformat,BorderLayout.NORTH);
		
        JPanel setPersoInfor = new JPanel ();
        setPersoInfor.setLayout (new BorderLayout());
        setPersoInfor.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        JLabel nSPI = new JLabel ("Cambiar Informac. Personal");
        setPersoInfor.add(nSPI,BorderLayout.CENTER);
        nSPI.setPreferredSize(new Dimension (150,40));
        bSetPersoInfor = new JButton (new ImageIcon("data/cambiar.JPG"));
        setPersoInfor.add(bSetPersoInfor,BorderLayout.NORTH);  

        
        JPanel acadmicInfor = new JPanel ();
        acadmicInfor.setLayout (new BorderLayout());
        acadmicInfor.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        JLabel nAI = new JLabel (" Ver Informacion Academica");
        acadmicInfor.add(nAI,BorderLayout.CENTER);
        nAI.setPreferredSize(new Dimension (150,40));
        bAcadmicInfor = new JButton (new ImageIcon("data/academica.JPG"));
        acadmicInfor.add(bAcadmicInfor,BorderLayout.NORTH);  
        
               
		JPanel virtFold = new JPanel ();
        virtFold.setLayout (new BorderLayout());
        virtFold.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        JLabel nFV = new JLabel ("            Folder Virtual");
        virtFold.add(nFV,BorderLayout.CENTER);
        nFV.setPreferredSize(new Dimension (150,40));
        bVirtFold = new JButton (new ImageIcon("data/folder.JPG"));
        virtFold.add(bVirtFold,BorderLayout.NORTH); 
        
        menu.add(persoInformat);
        menu.add(new JLabel (""));
        menu.add(setPersoInfor);
        menu.add(acadmicInfor);
        menu.add(new JLabel (""));
        menu.add(virtFold);
 
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
    	bPersonInformat.setActionCommand(PERSONNEL);
    	bPersonInformat.addActionListener(this);
    	bSetPersoInfor.setActionCommand(SETPERSONNEL);
    	bSetPersoInfor.addActionListener(this);
    	bAcadmicInfor.setActionCommand(ACADEMIC);
    	bAcadmicInfor.addActionListener(this);
    	bVirtFold.setActionCommand(FOLDER);
    	bVirtFold.addActionListener(this);
    	logOut.setActionCommand(LOGOUT);
    	logOut.addActionListener(this);
    	throwManager();
    }
	
	
	public void actionPerformed(ActionEvent arg0) 
	{
		
		String comando = arg0.getActionCommand();
		
		if (comando.equalsIgnoreCase(EXIT))
		{
			System.exit( 0 );		
		}
		else if(comando.equalsIgnoreCase(PERSONNEL))
		{
			this.persInformation.disable();
			persInformation.setManager(manager);
			this.persInformation.setLastFrame(this);
			this.persInformation.getTittle().setText("Informacion Personal Estudiante");
			this.persInformation.setJustSeeing(true);
			this.persInformation.enableFieldsShow();
			persInformation.setfields(manager.getUserStudentCode());
			
			this.persInformation.setVisible(true);
			this.setVisible(false);				
		}
		else if(comando.equalsIgnoreCase(SETPERSONNEL))
		{
			this.persInformation.disable();
			persInformation.setManager(manager);
			this.persInformation.setLastFrame(this);
			this.persInformation.getTittle().setText("Actualizar Informacion Personal Estudiante");
			this.persInformation.setJustSeeing(false);
			this.persInformation.setfields(manager.getUserStudentCode());
			this.persInformation.enableFieldsModify();
			this.persInformation.setVisible(true);
			this.setVisible(false);			
		}
		else if(comando.equalsIgnoreCase(ACADEMIC))
		{
			String ja [][]={{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"}};
			this.acadeInf.setLastFrame(this);
			this.acadeInf.setTable(ja);
			this.acadeInf.setVisible(true);
			this.setVisible(false);			
		}
		else if(comando.equalsIgnoreCase(FOLDER))
		{
			studVF.setLastFrame(this);
			studVF.setVisible(true);
			setVisible(false);
		}
		else if(comando.equalsIgnoreCase(LOGOUT))
		{
			manager.LogOut();
			fLogIn.setVisible(true);
			this.setVisible(false);
		}
	}

	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param: manager  
	 * @@return: void
	 * @@aditional_description:  
	 */
	public void setManager(CManager manManager) 
	{
		manager = manManager;		
	}

	public void throwManager()
	{
		studVF.setManager(manager);
		studVF.throwManager();
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:  LogIn 
	 * @@return: void
	 * @@aditional_description:  
	 */
	public void setLogIn(JFrame in) 
	{
		fLogIn = in;		
	}
}