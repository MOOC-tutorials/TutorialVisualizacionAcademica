/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     DeleteTypeRules.java 
 * @@brief    
 * @@version  1.0
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     
 * @@bug     
 */

//--------- Present package declaration
package coursemanager.view;

//--------- Standar Libraries import
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class DeleteTypeRules extends JFrame implements ActionListener {
	private JButton bExit;
	private JButton bGoBack;
	private JLabel tittleja;
	private JComboBox courses;
	private JButton bDelete;
	private JButton bCancel;
	private static final String GOBACK = "goback";
	private static final String EXIT = "exit";
	private static final String CHELED = "cheled";
	private static final String CHELED2 = "cheled2";
	private static final String ORVIA = "orvia";
	
	private ButtonGroup group = new ButtonGroup();
	private JRadioButton lCor;
	private JRadioButton lDeparta;
	private JFrame lastFrame;
	private JComboBox rule;
	private JComboBox cor;
	private JButton bAddRulePrerrequi;
	private JButton bAdd;
	private static final String ELIMINAR = "eliminar";
	private static final String CANCEL = "cancelar";
	
	private CManager manager;


	/**
	 * @@param lastFrame The lastFrame to set.
	 */
	public void setLastFrame(JFrame lastFrame)
	{
		this.lastFrame = lastFrame;
	}
	
	public DeleteTypeRules ()
	{
		setTitle( "Eliminar Regla  - CriolloSoft" );
		setSize( 900, 600 );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		getContentPane().setLayout (null);
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	tittleja = new JLabel();
    	JLabel textArea1 = new JLabel();
    	JLabel textArea2 = new JLabel();
    	JLabel textArea3 = new JLabel();
    	JLabel tittle = new JLabel();    	
    	textArea1.setText("Sistema de visualización y control de la");
    	textArea2.setText("información académica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	tittleja.setText("Eliminar Prerrequisitos y/o Correquisitos"); 
    	tittleja.setFont(new Font("Serif", Font.BOLD, 20));
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
    	tittleja.setBounds(105, 150, 450, 21);
    	// add components
    	getContentPane().add(label);
    	getContentPane().add(tittle);
    	getContentPane().add(textArea1);
    	getContentPane().add(textArea2);
    	getContentPane().add(textArea3);
    	getContentPane().add(tittleja);
    	bExit = new JButton(new ImageIcon ("data/salirMenu.JPG"));
    	bExit.setBounds(817, 523, 63, 37);
    	bGoBack = new JButton(new ImageIcon ("data/volver.JPG"));
    	bGoBack.setBounds(730, 523, 63, 37);
    	
    	courses = new JComboBox ();
    	courses.setBounds(85,260,280,25);
    	getContentPane().add(courses);
    	getContentPane().add(bGoBack);
    	getContentPane().add(bExit);

    	JPanel selectPanel = new JPanel ();
    	TitledBorder border = BorderFactory.createTitledBorder("Selecci�n del Curso");
    	border.setTitleColor(Color.RED);
    	selectPanel.setBorder (border);    	
    	selectPanel.setBounds(50,200,350,150);
    	getContentPane().add(selectPanel);
    	
    	rule = new JComboBox ();
    	rule.setBounds(630,230,190,25);
    	getContentPane().add(rule);
    	rule.setEnabled(false);
    	
    	cor = new JComboBox ();
    	cor.setBounds(630,290,190,25);
    	getContentPane().add(cor);
    	cor.setEnabled(false);
    	
    	lDeparta = new JRadioButton ("Prerrequisito: ");
    	lDeparta.setFont(new Font("Serif", Font.BOLD, 15));
    	lDeparta.setBounds(480,230,150,25);
    	getContentPane().add(lDeparta);
    	
    	lCor = new JRadioButton ("Correquisito: ");
    	lCor.setFont(new Font("Serif", Font.BOLD, 15));
    	lCor.setBounds(480,290,150,25);
    	group.add(lCor);
    	group.add(lDeparta);
    	getContentPane().add(lCor);

    	JPanel selectPanelRule = new JPanel ();
    	TitledBorder borderRule = BorderFactory.createTitledBorder("Selecci�n de Prerrequisito/Coorrequisito");
    	borderRule.setTitleColor(Color.RED);
    	selectPanelRule.setBorder (borderRule);    	
    	selectPanelRule.setBounds(440,200,410,150);
    	getContentPane().add(selectPanelRule);

    	
    	bAdd = new JButton("Eliminar");
    	bAdd.setFont(new Font("Serif", Font.BOLD, 15));
    	bAdd.setBounds(410,400,200,25);
    	getContentPane().add(bAdd);
    	
    	bCancel = new JButton("Cancelar");
    	bCancel.setFont(new Font("Serif", Font.BOLD, 15));
    	bCancel.setBounds(650,400,200,25);
    	getContentPane().add(bCancel);
    	
    	lDeparta.setActionCommand(CHELED);
    	lDeparta.addActionListener(this);
    	lCor.setActionCommand(CHELED2);
    	lCor.addActionListener(this);
    	courses.setActionCommand(ORVIA);
    	courses.addActionListener(this);
    	bAdd.setActionCommand(ELIMINAR);
    	bAdd.addActionListener(this);
    	bCancel.setActionCommand(CANCEL);
    	bCancel.addActionListener(this);
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
    	bGoBack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		
		String comando = arg0.getActionCommand();
		
		if (comando.equalsIgnoreCase(EXIT))
		{
			System.exit( 0 );    			
    	}
		else if(comando.equalsIgnoreCase(GOBACK))
		{
			this.lastFrame.setVisible(true);
			this.setVisible(false);	
		}
		else if(comando.equalsIgnoreCase(ELIMINAR))
		{
			if ( lDeparta.isSelected())  //is Prereq
			{
				String c1 = (String)courses.getSelectedItem();
				String course2 = (String)rule.getSelectedItem();
				String course1 = getCourse(c1);				
				manager.deleteRule(course2, course1, "PRE");
				loadCurriculumCourses ();
			}
			else
			{
				String c1 = (String)courses.getSelectedItem();
				String course2 = (String)rule.getSelectedItem();
				String course1 = getCourse(c1);				
				manager.deleteRule(course1, course2, "COR");
				loadCurriculumCourses ();
			}			
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "La regla se elimino correctamente", "Exito", 1);						
		}
		else if(comando.equalsIgnoreCase(CANCEL))
		{		
			this.lastFrame.setVisible(true);
			this.setVisible(false);		
		}
		else if(comando.equalsIgnoreCase(CHELED))
		{		
			cor.setEnabled(false);
			rule.setEnabled(true);
		}
		else if(comando.equalsIgnoreCase(CHELED2))
		{		
			cor.setEnabled(true);
			rule.setEnabled(false);
		}
		else if(comando.equalsIgnoreCase(ORVIA))
		{		
			rule.removeAllItems();
			cor.removeAllItems();
			ArrayList pre = new ArrayList();
			ArrayList correq = new ArrayList();
			String code = getCourse((String)courses.getSelectedItem());
			manager.getListPrereqs(code,pre);
			manager.getListCoreqs(code,correq);
			Iterator iPre = pre.iterator();
			Iterator iCor = correq.iterator();
			while (iPre.hasNext())
			{
				rule.addItem((String)iPre.next());
			}
			while (iCor.hasNext())
			{
				cor.addItem((String)iCor.next());
			}			
			
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
	public void setManager(CManager manager2) 
	{
		manager = manager2;
		
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: 
	 * @@aditional_description:  
	 */
	public void loadCurriculumCourses()
	{
		rule.removeAllItems();
		courses.removeAllItems();		
		String codeCourse;
		ArrayList arrCodes = new ArrayList();
		ArrayList arrNames = new ArrayList();
		manager.getListOfCurriculumCourses(arrCodes, arrNames);
		Iterator it1 = arrCodes.iterator();
		Iterator it2 = arrNames.iterator();
		
		while ( it1.hasNext() )
		{
			codeCourse = (String)it1.next() + " - " + (String)it2.next();
			courses.addItem(codeCourse);
		}				
	}
	
	private String getCourse(String chain)
	{
		String code = "";
		CodRes res;
		int i =0;
		while ( chain != null && chain.charAt(i+1) != '-')
		{
			code += chain.charAt(i);
			i++;
		}
		return code;
	}
	
}