/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     AddCurriculumCourse.java 
 * @@brief    
 * @@version  1.0
 * @@author   CriolloSoft
 * @@par      
 *                      
 * @@todo     
 * @@bug     
 */

//--------- Present package declaration


//--------- Standar Libraries import


//--------- Own libraries import 


// -------- Class declaration and documentation

package coursemanager.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class AddCurriculumCourse extends JFrame implements ActionListener{
	/**
	 * Constants
	 */
	private static final String SELECT = "selectDep";
	private static final String ACCEPT = "accept";
	private static final String CANCEL = "cancel";
	
	private CManager manager;
	private JFrame lastFrame = new JFrame();
	
	private JLabel textArea1 = new JLabel("Sistema de visualizaci�n y control de la");
	private JLabel textArea2 = new JLabel("informaci�n acad�mica de los estudiantes de");
	private JLabel textArea3 = new JLabel("la Universidad de los Andes");
	private JLabel depBelongs = new JLabel();
	private JComboBox depComboBox = new JComboBox();
	private JLabel courseDep = new JLabel();
	private JComboBox courseComboBox = new JComboBox();
	/** Accept */
	private JButton acceptButton = new JButton("Aceptar");
	
	/** cancel */
	private JButton cancelButton = new JButton("Cancelar");
	
	public AddCurriculumCourse()
	{
		//		Frame configuration data
    	setName("Agregar curso de otro departamento al curriculo");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel("AGREGAR CURSO AL CURRICULO");
    	
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	title.setFont(new Font("Serif", Font.BOLD, 20));
    	depBelongs.setText("Departamento :"); depBelongs.setFont(new Font("Serif", Font.BOLD, 18));
    	courseDep.setText("Curso : "); courseDep.setFont(new Font("Serif", Font.BOLD, 18));
    	cancelButton.setToolTipText("Regresar a la pantalla anterior");
    	//    	 Set components position
    	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	title.setBounds(15, 190, 450, 21);
    	depBelongs.setBounds(160, 250, 160, 30);
    	depComboBox.setBounds(360, 250, 220, 30);
    	courseDep.setBounds(160, 345, 160, 30);
    	courseComboBox.setBounds(360, 345, 220, 30);
    	acceptButton.setBounds(270, 510, 120, 30);
    	cancelButton.setBounds(520, 510, 120, 30);
    	//add ciomponents
    	add(label);
    	add(title);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(depBelongs);
    	add(depComboBox);
    	add(courseDep);
    	add(courseComboBox);
    	add(acceptButton);
    	add(cancelButton);
    	//listeners
    	depComboBox.setActionCommand(SELECT);
    	depComboBox.addActionListener(this);
    	acceptButton.setActionCommand(ACCEPT);
    	acceptButton.addActionListener(this);
    	cancelButton.setActionCommand(CANCEL);
    	cancelButton.addActionListener(this);	
	}

	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: 
	 * @@aditional_description:  
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		String command = arg0.getActionCommand();
		
		if (command.equalsIgnoreCase(SELECT))
    	{
			String dept = (String)depComboBox.getSelectedItem();
			loadCourses(dept);			    			
    	}
		else if (command.equalsIgnoreCase(ACCEPT))
    	{
			try
			{
				String course = getCourse((String)courseComboBox.getSelectedItem());
				String dept = (String)depComboBox.getSelectedItem();
				CodRes res = manager.addCourseToCurriculum(dept, course, "");
				
				if ( res == CodRes.SUCCESS)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "Curso agregado al curriculo.", "Exito", 1);
				}
				else if ( res == CodRes.ALREADY_EXISTS)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "El curso ya existe en el curriculo.", "Advertencia", 2);		
				}
				else
				{	  //Aca NO puede llegar.
				}
			}
			catch ( Exception e)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "No hay cursos.", "Advertencia", 2);				
			}
    	}
		else if (command.equalsIgnoreCase(CANCEL))
    	{
			lastFrame.setVisible(true);
			setVisible(false);
    	}
	}
	
	private String getCourse(String chain) 
	{
		String course = "";
		int i = 0;
		while ( chain.charAt(i+1) != '-')
		{
			course += chain.charAt(i);
			i++;
		}		
		return course;
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
	public void setLastFrame(JFrame frame)
	{
		lastFrame = frame;
	}

	public void loadDepartments() 
	{
		depComboBox.removeAllItems();
		ArrayList arrDepts = new ArrayList();
		
		manager.getListOfDepartments(arrDepts);
		String dept;
		Iterator it = arrDepts.iterator();	

		while ( it.hasNext())
		{
			dept = (String)it.next();
			depComboBox.addItem(dept);			
		}
	}
	
	private void loadCourses(String psDepName)
	{
		courseComboBox.removeAllItems();
		ArrayList codes = new ArrayList();
		ArrayList names = new ArrayList();
		if (psDepName == null )
		{
			psDepName = "";
		}
		manager.getListDepartmentCourses(psDepName, codes, names);
		
		Iterator it1 = codes.iterator();	
		Iterator it2 = names.iterator();
		String codeCourse, nameCourse, toPrint;
		while ( it1.hasNext())
		{
			codeCourse = (String)it1.next();
			nameCourse = (String)it2.next();
			toPrint = codeCourse + " - " + nameCourse;
			courseComboBox.addItem(toPrint);			
		}
	}
}