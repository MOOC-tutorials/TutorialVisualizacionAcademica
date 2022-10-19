/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import coursemanager.controller.CManager;
import coursemanager.view.AddDepartamentCourse;



/**
 * @@author Familia
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SetAcademicProgram extends JFrame implements ActionListener{
	
	private final static String EXIT = "exit";
	private final static String  GOBACK= "goback";
	private final static String  ADDCOURSECURR= "bAddCourseCurr";
	private final static String  SETDEPARTMENTCOURSE= "bsetDepartmentCourse";
	private final static String  DELETEDEPARTMENTCOURSE= "bdeleteDepartmentCourse";
	private final static String  DELETECURRICUCOURSE= "bdeleteCurriculumCourse";
	private final static String  ADDDEPARTMENTCOURSE= "baddDepartCourse";
	private final static String  ADDAREARULE= "baddAreaRule";
	private final static String  ADDRULE= "baddRule";
	private final static String  DELETERULE= "bdeleteRule";
	private final static String  SETRULE= "bsetRule";
	private final static String  SETRULEAREA= "bsetRuleArea";
	
	
	private JButton bExit ;
	private JButton bGoBack;
	private JButton bAddCourseCurr;
	private JButton bsetDepartmentCourse;
	private JButton bdeleteDepartmentCourse;
	private JButton bdeleteCurriculumCourse;
	private JButton baddDepartCourse;
	private JButton baddAreaRule;
	private JButton baddRule;
	private JButton bdeleteRule;
	private JButton bsetRule;
	private JButton bsetRuleArea;
	
	private AddDepartamentCourse addDepCour;
	private DeleteDepartamentCourse delDepCourse;
	private SetDepartmentCourse setDeparCourse;
	private AddCurriculumCourse addCurriCourse;
	private DeleteCurriculumCourse delCurriCourse;
	private AddAreaRule areaRule;
	private AddRule addRul;
	private ChangeAreaRule changeArea;
	private CManager manager;
	private DeleteTypeRules delTyRules;
	
	private JFrame lastFrame;
	
	public void setLastFrame(JFrame lastFrame) {
		this.lastFrame = lastFrame;
	}



	public SetAcademicProgram()
    {
		addDepCour = new AddDepartamentCourse ();	
		delDepCourse = new DeleteDepartamentCourse ();
		addRul = new AddRule () ;
		setDeparCourse = new SetDepartmentCourse ();
		addCurriCourse = new AddCurriculumCourse();
		delCurriCourse = new DeleteCurriculumCourse();
		areaRule = new AddAreaRule();
		changeArea = new ChangeAreaRule();
		delTyRules = new DeleteTypeRules ();
		
		setTitle( "Cambiar Programa Academico - CriolloSoft" );
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
    	title.setText("Cambiar Programa Academico"); 
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

        bExit = new JButton (new ImageIcon ("data/salirMenu.JPG"));
        exit.add(bExit,BorderLayout.EAST);
        bGoBack = new JButton (new ImageIcon ("data/volver.JPG"));
        exit.add(bGoBack,BorderLayout.CENTER);
        JPanel empty = new JPanel ();
        exit.add(empty,BorderLayout.WEST);
        empty.setPreferredSize(new Dimension(670,50)); 
        
        
        
        JPanel menu = new JPanel ();
        getContentPane().add(menu,BorderLayout.CENTER);
        menu.setLayout(new GridLayout(2,9));
        menu.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
       
        
        
        JPanel addDepartCourse = new JPanel ();
        addDepartCourse.setLayout (new BorderLayout());
        addDepartCourse.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        baddDepartCourse = new JButton (new ImageIcon("data/adicionarCursoDep.JPG"));
        addDepartCourse.add(baddDepartCourse,BorderLayout.NORTH);
        
        JPanel addCourseCurr = new JPanel ();
        addCourseCurr.setLayout (new BorderLayout());
        addCourseCurr.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        bAddCourseCurr = new JButton (new ImageIcon("data/adicionarCursoCurri.JPG"));
        addCourseCurr.add(bAddCourseCurr,BorderLayout.NORTH);
        
        JPanel setDepartmentCourse = new JPanel ();
        setDepartmentCourse.setLayout (new BorderLayout());
        setDepartmentCourse.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        bsetDepartmentCourse = new JButton (new ImageIcon("data/cambiarCursoDepart.JPG"));
        setDepartmentCourse.add(bsetDepartmentCourse,BorderLayout.NORTH);
        
        JPanel deleteDepartmentCourse = new JPanel ();
        deleteDepartmentCourse.setLayout (new BorderLayout());
        deleteDepartmentCourse.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        bdeleteDepartmentCourse = new JButton (new ImageIcon("data/borrarcursodepart.JPG"));
        deleteDepartmentCourse.add(bdeleteDepartmentCourse,BorderLayout.NORTH);
        
        JPanel deleteCurriculumCourse = new JPanel ();
        deleteCurriculumCourse.setLayout (new BorderLayout());
        deleteCurriculumCourse.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        bdeleteCurriculumCourse = new JButton (new ImageIcon("data/borrarcursocurriculo.JPG"));
        deleteCurriculumCourse.add(bdeleteCurriculumCourse,BorderLayout.NORTH);
		
        JPanel addAreaRule = new JPanel ();
        addAreaRule.setLayout (new BorderLayout());
        addAreaRule.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        baddAreaRule = new JButton (new ImageIcon("data/adicionarreglaArea.JPG"));
        addAreaRule.add(baddAreaRule,BorderLayout.NORTH); 
        
        JPanel addRule = new JPanel ();
        addRule.setLayout (new BorderLayout());
        addRule.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        baddRule = new JButton (new ImageIcon("data/adicionarregla.JPG"));
        addRule.add(baddRule,BorderLayout.NORTH);  
        
        JPanel deleteRule = new JPanel ();
        deleteRule.setLayout (new BorderLayout());
        deleteRule.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        bdeleteRule = new JButton (new ImageIcon("data/borrarregla.JPG"));
        deleteRule.add(bdeleteRule,BorderLayout.NORTH);  
        
        JPanel setRule = new JPanel ();
        setRule.setLayout (new BorderLayout());
        setRule.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        bsetRule = new JButton (new ImageIcon("data/cambiarregla.JPG"));
        setRule.add(bsetRule ,BorderLayout.NORTH);  
        
        JPanel setRuleArea = new JPanel ();
        setRuleArea.setLayout (new BorderLayout());
        setRuleArea.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        bsetRuleArea = new JButton (new ImageIcon("data/cambiarreglaarea.JPG"));
        setRuleArea.add(bsetRuleArea ,BorderLayout.NORTH);  

         
        menu.add(addDepartCourse);
        menu.add(new JLabel (""));
        menu.add(addCourseCurr);
        menu.add(new JLabel (""));
        menu.add(setDepartmentCourse);
        menu.add(new JLabel (""));
        menu.add(deleteDepartmentCourse);
        menu.add(new JLabel (""));
        menu.add(deleteCurriculumCourse);
        menu.add(addAreaRule);
        menu.add(new JLabel (""));
        menu.add(addRule);
        menu.add(new JLabel (""));
        menu.add(deleteRule);
        menu.add(new JLabel (""));
        menu.add(setRuleArea);
        menu.add(new JLabel (""));
        menu.add(new JLabel (""));
        
        
    	bAddCourseCurr.setActionCommand(ADDCOURSECURR);
    	bAddCourseCurr.addActionListener(this);
    	bsetDepartmentCourse.setActionCommand(SETDEPARTMENTCOURSE);
    	bsetDepartmentCourse.addActionListener(this);
    	bdeleteDepartmentCourse.setActionCommand(DELETEDEPARTMENTCOURSE);
    	bdeleteDepartmentCourse.addActionListener(this);
    	bdeleteCurriculumCourse.setActionCommand(DELETECURRICUCOURSE);
    	bdeleteCurriculumCourse.addActionListener(this);
    	baddDepartCourse.setActionCommand(ADDDEPARTMENTCOURSE);
    	baddDepartCourse.addActionListener(this);
    	baddAreaRule.setActionCommand(ADDAREARULE);
    	baddAreaRule.addActionListener(this);
    	baddRule.setActionCommand(ADDRULE);
    	baddRule.addActionListener(this);
    	bdeleteRule.setActionCommand(DELETERULE);
    	bdeleteRule.addActionListener(this);
    	bsetRule.setActionCommand(SETRULE);
    	bsetRule.addActionListener(this);
    	bsetRuleArea.setActionCommand(SETRULEAREA);
    	bsetRuleArea.addActionListener(this);
        bGoBack.setActionCommand(GOBACK);
    	bGoBack.addActionListener(this);
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
   	
    }
	
	

	public void actionPerformed(ActionEvent arg0) 
	{
		throwManager();
		String comando = arg0.getActionCommand();
		
		if (comando.equalsIgnoreCase(EXIT))
		{
			System.exit( 0 );
		}
		else if (comando.equalsIgnoreCase(GOBACK))
		{
			lastFrame.setVisible(true);
			this.setVisible(false);
		}
		else if (comando.equalsIgnoreCase(ADDCOURSECURR))
		{
			addCurriCourse.setLastFrame(this);
			addCurriCourse.loadDepartments();
			addCurriCourse.setVisible(true);
			setVisible(false);
		}
		else if (comando.equalsIgnoreCase(SETDEPARTMENTCOURSE))
		{
			this.setDeparCourse.setLastFrame(this);
			this.setDeparCourse.loadDepartmentCourses();
			this.setDeparCourse.setVisible(true);
			this.setVisible(false);

		}
		else if (comando.equalsIgnoreCase(DELETEDEPARTMENTCOURSE))
		{
			this.delDepCourse.setLastFrame(this);
			delDepCourse.loadDepartmentCourses();
			delDepCourse.setVisible(true);
			this.setVisible(false);
		}
		else if (comando.equalsIgnoreCase(DELETECURRICUCOURSE))
		{
			this.delCurriCourse.setLastFrame(this);
			delCurriCourse.loadCourses();
			delCurriCourse.setVisible(true);
			this.setVisible(false);
		}
		else if (comando.equalsIgnoreCase(ADDDEPARTMENTCOURSE))
		{
			this.addDepCour.setLastFrame(this);
			this.addDepCour.getTittle().setText("Adicionar Curso a Departamento");
			this.addDepCour.setVisible(true);
			this.setVisible(false);


		}
		else if (comando.equalsIgnoreCase(ADDAREARULE))
		{
			this.areaRule.setLastFrame(this);
			this.areaRule.loadDepartments();
			this.areaRule.setVisible(true);
			this.setVisible(false);
		}
		else if (comando.equalsIgnoreCase(ADDRULE))
		{
			this.addRul.setLastFrame(this);
			this.addRul.loadCurriculumCourses();
			this.addRul.setVisible(true);
			this.setVisible(false);
		}
		else if (comando.equalsIgnoreCase(DELETERULE))
		{
			delTyRules.setLastFrame(this);
			delTyRules.loadCurriculumCourses();
			delTyRules.setVisible(true);
			this.setVisible(false);
			
		}
		else if (comando.equalsIgnoreCase(SETRULEAREA))
		{
			this.changeArea.setLastFrame(this);
			this.changeArea.loadAreas();
			this.changeArea.setVisible(true);
			this.setVisible(false);
			this.changeArea.loadAreas();
		}
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: 
	 * @@aditional_description:  
	 */
	public void setManager(CManager nManager)
	{
		manager = nManager;
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: 
	 * @@aditional_description:  
	 */
	public void throwManager()
	{
		addDepCour.setManager(manager);
		addRul.setManager(manager);
		delDepCourse.setManager(manager);
		setDeparCourse.setManager(manager);		
		addCurriCourse.setManager(manager);
		delCurriCourse.setManager(manager);
		areaRule.setManager(manager);
		changeArea.setManager(manager);
		delTyRules.setManager(manager);
	}
}