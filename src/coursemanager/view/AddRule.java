/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



/**
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddRule extends JFrame implements ActionListener
{
	private JButton bExit;
	private JButton bGoBack;
	private JLabel tittleja;
	private JComboBox courses;
	private JButton bDelete;
	private JButton bCancel;
	private static final String GOBACK = "goback";
	private static final String EXIT = "exit";
	
	private JFrame lastFrame;
	private JComboBox rule;
	private JButton bAddRulePrerrequi;
    private JRadioButton[] radioButtons = new JRadioButton[2];
    final ButtonGroup group = new ButtonGroup();
	private JButton bAdd;
	private static final String ADICIONAR = "aceptar";
	private static final String CANCEL = "cancelar";
	
	private CManager manager;


	/**
	 * @@param lastFrame The lastFrame to set.
	 */
	public void setLastFrame(JFrame lastFrame)
	{
		this.lastFrame = lastFrame;
	}
	
	public AddRule ()
	{
		setTitle( "Agregar Regla  - CriolloSoft" );
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
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	tittleja.setText("Agregar Prerrequisitos y/o Correquisitos"); 
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
    	rule.setBounds(610,260,190,25);
    	getContentPane().add(rule);
    	
    	JLabel lDeparta = new JLabel ("Curso: ");
    	lDeparta.setFont(new Font("Serif", Font.BOLD, 15));
    	lDeparta.setBounds(480,260,150,25);
    	getContentPane().add(lDeparta);

    	JPanel selectPanelRule = new JPanel ();
    	TitledBorder borderRule = BorderFactory.createTitledBorder("Selecci�n de Prerrequisito/Coorrequisito");
    	borderRule.setTitleColor(Color.RED);
    	selectPanelRule.setBorder (borderRule);    	
    	selectPanelRule.setBounds(440,200,410,150);
    	getContentPane().add(selectPanelRule);
    	   	
    	radioButtons[0] = new JRadioButton("Prerrequisito");   	
    	radioButtons[0].setFont(new Font("Serif", Font.BOLD, 15));
    	radioButtons[0].setBounds(70,380,140,25);
    	getContentPane().add(radioButtons[0]);
    	group.add(radioButtons[0]);


    	radioButtons[1] = new JRadioButton("Correquisito");
    	radioButtons[1].setFont(new Font("Serif", Font.BOLD, 15));
    	radioButtons[1].setBounds(230,380,150,25);
    	getContentPane().add(radioButtons[1]);
    	group.add(radioButtons[1]);
    	radioButtons[0].setSelected(true);

    	
    	bAdd = new JButton("Adicionar");
    	bAdd.setFont(new Font("Serif", Font.BOLD, 15));
    	bAdd.setBounds(410,400,200,25);
    	getContentPane().add(bAdd);
    	
    	bCancel = new JButton("Cancelar");
    	bCancel.setFont(new Font("Serif", Font.BOLD, 15));
    	bCancel.setBounds(650,400,200,25);
    	getContentPane().add(bCancel);
    	
    	
    	
    	bAdd.setActionCommand(ADICIONAR);
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
		else if(comando.equalsIgnoreCase(ADICIONAR))
		{
			String c2 = (String) courses.getSelectedItem();
			String c1 = (String) rule.getSelectedItem();
			String course1 = "";
			String course2 = "";
			CodRes res;
			int i=0;
			while ( c1.charAt(i+1) != '-')
			{
				course1 += c1.charAt(i);
				course2 += c2.charAt(i);
				i++;
			}
			if ( radioButtons[0].isSelected())
			{
				res = manager.addRule(course1, course2, "PRE", "");
			}
			else
			{
				res = manager.addRule(course1, course2, "COR", "");
			}
			
			if ( res == CodRes.ALREADY_EXISTS)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "Regla existente", "Advertencia", 2);
			}
			else if ( res == CodRes.SUCCESS)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "Regla a�adida", "Exito", 1);
			}
			else if ( res == CodRes.INVALID_ARGUMENTS)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "Un curso no puede ser regla de �l mismo", "Advertencia", 2);				
			}		
			
		}
		else if(comando.equalsIgnoreCase(CANCEL))
		{		
			this.lastFrame.setVisible(true);
			this.setVisible(false);		
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
		/*manager.createCourse("INGSW", "ISIS2701", 3, 2, "", "");
		manager.createCourse("Estructuras", "ISIS2202", 3, 2, "", "");
		manager.addCourseToCurriculum("ISIS", "ISIS2701", "");
		manager.addCourseToCurriculum("ISIS", "ISIS2202", "");*/
		
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
			rule.addItem(codeCourse);
		}				
	}
}