/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import coursemanager.controller.CManager;
import coursemanager.persistence.LoadFileUtility;


/**
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Welcome extends JFrame implements ActionListener{
	//Global Variables for the Application
	public static String ITEMS_PACKAGE = "stockmanager.model.items.concrete";
	public static String COURSES_DATA_FILE = "data/Courses.txt";
	public static String DEPARTMENTS_DATA_FILE = "data/Departments.txt";
	public static String FACULTIES_DATA_FILE = "data/Faculties.txt";
	public static String ACADEMIC_PROGRAMS_DATA_FILE = "data/AcademicPrograms.txt";
	public static String LOGIN_COORDINATORS_DATA_FILE = "data/LoginCoordinators.txt";
	public static String IMAGE_PATH = "images";


	// Format numerique par defaut
	public static final String NUMBER_FORMAT_STRING = "%8.2f"; // 10 caracteres on totale avec 2 decimales a la fin

	// Format date par defaut
	public static final String DATE_FORMAT_STRING = "dd/MM/yyyy";
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STRING, Locale.US);


	//Private variables
	private static CManager manager;

	private final static String LOGIN = "login";
	private final static String EXIT = "exit";
	private JButton bLogin;
	private JButton bExit;
	private LogIn login;

	public Welcome ()
	{
		manager = new CManager();
		try {
			LoadFileUtility.initCoursesWithRegisters(LoadFileUtility.loadRawRegistersFromFile(COURSES_DATA_FILE));
			LoadFileUtility.initProgramsWithRegisters(LoadFileUtility.loadRawRegistersFromFile(ACADEMIC_PROGRAMS_DATA_FILE));
			LoadFileUtility.initDepartmentsWithRegisters(LoadFileUtility.loadRawRegistersFromFile(DEPARTMENTS_DATA_FILE));
			LoadFileUtility.initFacultiesWithRegisters(LoadFileUtility.loadRawRegistersFromFile(FACULTIES_DATA_FILE));
			LoadFileUtility.initCoordinatorsWithRegisters(LoadFileUtility.loadRawRegistersFromFile(LOGIN_COORDINATORS_DATA_FILE));
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		login = new LogIn ();
		login.setManager(manager);

		setTitle( "Sistema Interactivo - CriolloSoft" );
		setSize( 900, 600 );
		setResizable( false );
		setDefaultCloseOperation( HIDE_ON_CLOSE );
		getContentPane().setLayout (new BorderLayout ());

		JPanel pPicture = new JPanel ();
		pPicture.setBorder(BorderFactory.createEmptyBorder(20,100,2,100));
		pPicture.setLayout (new BorderLayout ());
		JLabel lPicture =  new JLabel  (new ImageIcon ("data/uniandes.JPG"));
		pPicture.add(lPicture,BorderLayout.CENTER);
		pPicture.setPreferredSize(new Dimension(700,200));
		pPicture.setBackground(new java.awt.Color(239, 239, 239));

		JPanel pText = new JPanel ();
		pText.setLayout (new BorderLayout ());
		JLabel lText = new JLabel (new ImageIcon("data/inicio.JPG"));
		pText.add(lText,BorderLayout.CENTER);
		pText.setPreferredSize(new Dimension(700,300));
		pText.setBackground(new java.awt.Color(239, 239, 239));

		JPanel pLogin = new JPanel ();
		pLogin.setBorder(BorderFactory.createEmptyBorder(2,290,40,290));
		pLogin.setLayout (new BorderLayout ());
		bLogin =  new JButton  (new ImageIcon ("data/llave.JPG"));
		pLogin.add(bLogin,BorderLayout.EAST);
		bExit =  new JButton  (new ImageIcon ("data/salir.JPG"));
		pLogin.add(bExit,BorderLayout.WEST);
		pLogin.setBackground(new java.awt.Color(239, 239, 239));

		getContentPane().add(pPicture,BorderLayout.NORTH);
		getContentPane().add(pText,BorderLayout.CENTER);
		getContentPane().add(pLogin,BorderLayout.SOUTH);

		bLogin.setActionCommand(LOGIN);
		bLogin.addActionListener(this);
		bExit.setActionCommand(EXIT);
		bExit.addActionListener((ActionListener) this);
		//loadCourses();
	}

	public static CManager getManager() {
		return manager;
	}

	public void actionPerformed(ActionEvent arg0) 
	{

		String comando = arg0.getActionCommand();

		if (comando.equalsIgnoreCase(LOGIN))
		{	
			//login.setManager(manager);
			manager.LogOut();
			login.setVisible(true);
			this.setVisible(false);

		}
		else if(comando.equalsIgnoreCase(EXIT))
		{
			System.exit( 0 );
		}

	}


	public static void main(String[] args) 
	{

		try {
			Welcome w = new Welcome ();
			w.setVisible(true);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
