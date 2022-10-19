/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     AddAreaRule.java 
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
import javax.swing.JTextField;

import coursemanager.controller.CManager;
import coursemanager.model.*;



// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class AddAreaRule extends JFrame implements ActionListener {
	
	/**
	 * Constants 
	 */
	private static final String ACCEPT = "Aceptar";
	private static final String CANCEL = "Cancelar";
	private static final String SELECT = "Seleccionar";
	
	private JFrame lastFrame;
	private CManager manager;
	
	private JLabel textArea1 = new JLabel("Sistema de visualizaci�n y control de la");
	private JLabel textArea2 = new JLabel("informaci�n acad�mica de los estudiantes de");
	private JLabel textArea3 = new JLabel("la Universidad de los Andes");
	private JLabel numLabel = new JLabel("N�mero de cursos obligatorios:");
	private JTextField numTextField = new JTextField();
	private JLabel areaLabel = new JLabel("Area del conocimiento :");
	private JTextField areaTextField = new JTextField();
	private JLabel courseLabel = new JLabel("Curso :");
	private JLabel departmentLabel = new JLabel("Departamento :");
	
	private JComboBox courseComboBox = new JComboBox();
	private JComboBox departmentComboBox = new JComboBox();
	
	private JButton acceptButton = new JButton("Aceptar");
	private JButton cancelButton = new JButton("Cancelar");
	
	
	/**
	 * Class Constructor
	 * @@pre:
	 * @@pos:
	 */
	public AddAreaRule()
	{
		//manager.addAreaCourseRule(Area, Course, numCourses, archive);
		//		Frame configuration data
    	setTitle("Agregar regla de area");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel("AGREGAR REGLA DE AREA");
    	//components boot
    	textArea1.setFont(new Font("Serif", Font.BOLD, 15));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 15));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 15));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	title.setFont(new Font("Serif", Font.BOLD, 20));
    	numLabel.setFont(new Font("Serif", Font.BOLD, 15));
    	areaLabel.setFont(new Font("Serif", Font.BOLD, 15));
    	courseLabel.setFont(new Font("Serif", Font.BOLD, 15));
    	departmentLabel.setFont(new Font("Serif", Font.BOLD, 15));
    	//  Set components position
    	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	title.setBounds(15, 190, 450, 21);
    	numLabel.setBounds(50, 250, 260, 25);
    	numTextField.setBounds(370, 250, 40, 25);
    	areaLabel.setBounds(450, 250, 200, 25);
    	areaTextField.setBounds(660, 250, 180, 25);
    	courseLabel.setBounds(200, 430, 120, 25);
    	departmentLabel.setBounds(200, 330, 120, 25);
    	courseComboBox.setBounds(400, 430, 160, 25);
    	departmentComboBox.setBounds(400, 330, 160, 25);
    	acceptButton.setBounds(270, 510, 120, 30);
    	cancelButton.setBounds(520, 510, 120, 30);
    	//    	add components
    	add(label);
    	add(title);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(numLabel);
    	add(numTextField);
    	add(areaLabel);
    	add(areaTextField);
    	add(courseLabel);
    	add(departmentLabel);
    	add(courseComboBox);
    	add(departmentComboBox);
    	add(acceptButton);
    	add(cancelButton);
    	//  	listeners
    	acceptButton.setActionCommand(ACCEPT);
    	acceptButton.addActionListener(this);
    	
    	cancelButton.setActionCommand(CANCEL);
    	cancelButton.addActionListener(this);
    	
    	departmentComboBox.setActionCommand(SELECT);
    	departmentComboBox.addActionListener(this);
	}

	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: void
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
	 * @@return: void
	 * @@aditional_description:  
	 */
	public void setLastFrame(JFrame frame)
	{
		lastFrame = frame;
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: void
	 * @@aditional_description:  
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		String command = arg0.getActionCommand();
		
		if (command.equalsIgnoreCase(SELECT))
    	{
			String dept = (String)departmentComboBox.getSelectedItem();
			loadCourses(dept);			    			
    	}
		else if (command.equalsIgnoreCase(ACCEPT))
		{
			String numC = numTextField.getText();
			String nameArea = areaTextField.getText();
			Integer i = new Integer(numC);
			int num = i;
			String course = getCourse((String)courseComboBox.getSelectedItem());		
						
			CodRes res = manager.addAreaCourseRule(nameArea, course, num, "");
			
			if ( res == CodRes.NEW_RULE)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Area creada.", "Exito", 1);							
			}
			else if ( res == CodRes.ERROR)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Campo inv�lido.", "Error", 0);							
			}
			else  //SUCCESS
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Curso agregado a area existente.", "Exito", 2);
			}			
			
		}
		else if (command.equalsIgnoreCase(CANCEL))
		{
			lastFrame.setVisible(true);
			setVisible(false);
		}
	}
	
	public void loadDepartments() 
	{		
		cleanFields();
		ArrayList arrDepts = new ArrayList();
		
		manager.getListOfDepartments(arrDepts);
		String dept;
		Iterator it = arrDepts.iterator();	

		while ( it.hasNext())
		{
			dept = (String)it.next();
			departmentComboBox.addItem(dept);			
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
	
	
	private void cleanFields() 
	{
		departmentComboBox.removeAllItems();
		courseComboBox.removeAllItems();		
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
	
}