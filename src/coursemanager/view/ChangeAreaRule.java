/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     ChangeAreaRule.java 
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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class ChangeAreaRule extends JFrame implements ActionListener {
	/**
	 * Constants 
	 */
	private static final String ACCEPT = "Aceptar";
	private static final String CANCEL = "Cancelar";
	private static final String ADD = "Adicionar";
	private static final String DELETE = "Eliminar";
	private static final String DEPBOX = "depBox";
	private static final String AREABOX = "areaBox";
	
	private JFrame lastFrame;
	private CManager manager;
	
	private JLabel textArea1 = new JLabel("Sistema de visualizaci�n y control de la");
	private JLabel textArea2 = new JLabel("informaci�n acad�mica de los estudiantes de");
	private JLabel textArea3 = new JLabel("la Universidad de los Andes");
	private JLabel areaRuleLabel;
	private JComboBox areaComboBox;
	private JLabel numLabel;
	private JTextField numTextField; 
	private JLabel courseLabel = new JLabel("Curso :");
	private JComboBox courseComboBox = new JComboBox();
	private JLabel depLabel;
	private JComboBox depComboBox;
	private JLabel addLabel;
	private JComboBox addComboBox;
	private JLabel deleteLabel;
	private JComboBox deleteComboBox;
	private JButton addButton;
	private JButton deleteButton;
	private JButton acceptButton = new JButton("Aceptar");
	private JButton cancelButton = new JButton("Cancelar");
	
	public ChangeAreaRule()
	{
		//	Frame configuration data
    	setTitle("Cambiar regla de area");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel("CAMBIAR REGLA DE AREA");
    	//components boot
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	title.setFont(new Font("Serif", Font.BOLD, 20));
    	
    	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	title.setBounds(15, 170, 450, 21);
    	acceptButton.setBounds(270, 520, 120, 22);
    	cancelButton.setBounds(520, 520, 120, 22);
    	
    	add(label);
    	add(title);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	   	
    	JPanel panelConfiguration = new JPanel();
    	panelConfiguration.setLayout(null);
    	TitledBorder border = BorderFactory.createTitledBorder("Configuraci�n");
    	border.setTitleColor(Color.RED);
    	panelConfiguration.setBounds(20, 100, 850, 50);
    	
    	areaRuleLabel  = new JLabel("Seleccione un area :");
    	areaRuleLabel.setBounds(40, 210, 230, 21);
    	getContentPane().add(areaRuleLabel);   	
    	areaComboBox = new JComboBox();
    	areaComboBox.setBounds(230, 210, 180, 21);
    	getContentPane().add(areaComboBox);
    	numLabel = new JLabel("N�mero de cursos de esta area:");
    	numLabel.setBounds(450, 210, 220, 21);
    	getContentPane().add(numLabel);
    	numTextField= new JTextField();
    	numTextField.setBounds(650, 210, 40, 21);
    	numTextField.setEnabled(false);
    	getContentPane().add(numTextField);
    	addButton = new JButton("Adicionar");
    	addButton.setBounds(450, 270, 140, 21);
    	getContentPane().add(addButton);
    	deleteButton  = new JButton("Eliminar");
    	deleteButton.setBounds(670, 270, 140, 21);
    	getContentPane().add(deleteButton);
    	getContentPane().add(panelConfiguration);
    	
    	JPanel panelCourses = new JPanel(); 
    	panelCourses.setBorder(border);
    	TitledBorder border2 = BorderFactory.createTitledBorder("Curso");
    	border2.setTitleColor(Color.RED);
    	panelCourses.setBorder(border2);
    	panelCourses.setBounds(20, 350, 850, 150);
    	
    	depLabel = new JLabel("Departamento :");
    	depLabel.setBounds(40, 380, 120, 21);
    	getContentPane().add(depLabel);
    	depComboBox = new JComboBox();
    	depComboBox.setBounds(170, 380, 160, 21);
    	depComboBox.setEnabled(false);
    	getContentPane().add(depComboBox);
    	addLabel = new JLabel("Curso :");
    	addLabel.setBounds(40, 440, 120, 21);
    	getContentPane().add(addLabel);
    	addComboBox = new JComboBox();
    	addComboBox.setBounds(170, 440, 160, 21);
    	addComboBox.setEnabled(false);
    	getContentPane().add(addComboBox);
    	deleteLabel = new JLabel("Curso :");
    	deleteLabel.setBounds(470, 420, 120, 21);
    	getContentPane().add(deleteLabel);
    	deleteComboBox = new JComboBox();
    	deleteComboBox.setBounds(600, 420, 160, 21);
    	deleteComboBox.setEnabled(false);
    	getContentPane().add(deleteComboBox);
    	add(panelCourses);
    	getContentPane().add(acceptButton);
    	getContentPane().add(cancelButton);
 
    	//  	listeners
    	depComboBox.setActionCommand(DEPBOX);
    	depComboBox.addActionListener(this);
    	addButton.setActionCommand(ADD);
    	addButton.addActionListener(this);
    	deleteButton.setActionCommand(DELETE);
    	deleteButton.addActionListener(this);
    	acceptButton.setActionCommand(ACCEPT);
    	acceptButton.addActionListener(this);
    	cancelButton.setActionCommand(CANCEL);
    	cancelButton.addActionListener(this);	
    	areaComboBox.setActionCommand(AREABOX);
    	areaComboBox.addActionListener(this);	
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
		
		if (command.equalsIgnoreCase(ACCEPT))
		{
			
			CodRes res = null, res2 = null;
			if(deleteComboBox.isEnabled())
			{
				String code = (String)deleteComboBox.getSelectedItem();
				res = manager.deleteAreaCourseRule((String)areaComboBox.getSelectedItem(), code);
				loadCoursesArea();
			}
			if(addComboBox.isEnabled())
			{
				String chain = (String)addComboBox.getSelectedItem();
				int i = 0;
				String code = "";
				while ( chain != null && chain.charAt(i+1) != '-')
				{
					code += chain.charAt(i);
					i++;
				}
				String num = numTextField.getText();
				Integer in = new Integer(num);
				int number = in;
				res2 = manager.addAreaCourseRule((String)areaComboBox.getSelectedItem(), code, number, "");
			}
			if(res == CodRes.INVALID_ARGUMENTS)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "Los campos ingresados no son validos", "Error", 0);
			}
			else if(res == CodRes.INEXISTENT)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "No existe tal curso, verifique los datos", "Error", 0);
			}
			else if(res == CodRes.SUCCESS)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "El curso fue eliminado correctamente", "Exito", 2);
			}
			if(res2 == CodRes.SUCCESS)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "El curso fue adicionado exitosamente", "Exito", 2);
			}
			else if(res2 == CodRes.ERROR)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "Los datos fueron ingresados incorrectamente", "Error", 0);
			}
			else if(res2 == CodRes.NEW_RULE)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "Se agrego una nueva regla", "Aviso", 2);
			}
		}
		else if (command.equalsIgnoreCase(CANCEL))
		{
			lastFrame.setVisible(true);
			setVisible(false);
		}
		else if (command.equalsIgnoreCase(ADD))
		{
			depComboBox.setEnabled(true);
			addComboBox.setEnabled(true);
			deleteComboBox.setEnabled(false);
			loadDepartments();
		}
		else if (command.equalsIgnoreCase(DELETE))
		{
			depComboBox.setEnabled(false);
			addComboBox.setEnabled(false);
			deleteComboBox.setEnabled(true);
			loadCoursesArea();
		}
		else if (command.equalsIgnoreCase(DEPBOX))
		{
			loadCourses();
		}
		else if (command.equalsIgnoreCase(AREABOX))
		{
			boolean found = false;
			ArrayList areas = new ArrayList();
			ArrayList courses = new ArrayList();
			manager.getListOfAreas(areas, courses);
			Iterator it = areas.iterator();
			Iterator it2 = courses.iterator();
			while(it.hasNext() && !found)
			{
				String name = (String)it.next(); 
				String num = (String) it2.next();
				if(name.equals((String)areaComboBox.getSelectedItem()))
				{
					numTextField.setText(num);
					found = true;
				}
			}
		}
	}

	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:  none 
	 * @@return: void
	 * @@aditional_description:  
	 */
	private void loadCourses() 
	{
		ArrayList codes = new ArrayList();
		ArrayList names = new ArrayList();
		String course;
		addComboBox.removeAllItems();
		manager.getListDepartmentCourses((String)depComboBox.getSelectedItem(), codes, names);
		Iterator it = codes.iterator();
		Iterator it2 = names.iterator();
		while(it.hasNext())
		{
			course = (String)it.next() + " - " + (String)it2.next();
			addComboBox.addItem(course);
		}
	}

	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param: void  
	 * @@return: none
	 * @@aditional_description:  
	 */
	private void loadDepartments() 
	{
		String depto;
		ArrayList departments = new ArrayList();
		depComboBox.removeAllItems();
		manager.getListOfDepartments(departments);
		Iterator it = departments.iterator();
		while(it.hasNext())
		{
			depto = (String)it.next();
			depComboBox.addItem(depto);
		}
	}

	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param: none 
	 * @@return: void
	 * @@aditional_description:  
	 */
	private void loadCoursesArea() 
	{
		String area;
		ArrayList areaCourse = new ArrayList();
		deleteComboBox.removeAllItems();
		manager.getCoursesFromArea((String)areaComboBox.getSelectedItem(), areaCourse);
		Iterator it = areaCourse.iterator();
		while(it.hasNext())
		{
			area = (String)it.next();
			deleteComboBox.addItem(area);
		}
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post: 
	 * @@param: none  
	 * @@return: void
	 * @@aditional_description:  
	 */
	public void loadAreas() 
	{
		ArrayList areas = new ArrayList();
		ArrayList numberCourses = new ArrayList();
		String codeCourse;
		areaComboBox.removeAllItems();
		manager.getListOfAreas(areas, numberCourses);
		Iterator it = areas.iterator();
		while ( it.hasNext() )
		{
			codeCourse = (String)it.next();
			areaComboBox.addItem(codeCourse);
		}
	}
}