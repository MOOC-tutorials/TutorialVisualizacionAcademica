/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     deleteCurriculumCourse.java 
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
import coursemanager.model.CodRes;



// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class DeleteCurriculumCourse extends JFrame implements ActionListener {
	/**
	 * Constants
	 */
	private static final String ACCEPT = "accept";
	private static final String CANCEL = "cancel";
	
	private CManager manager;
	private JFrame lastFrame = new JFrame();
	
	private JLabel textArea1 = new JLabel("Sistema de visualizaci�n y control de la");
	private JLabel textArea2 = new JLabel("informaci�n acad�mica de los estudiantes de");
	private JLabel textArea3 = new JLabel("la Universidad de los Andes");
	private JLabel depBelongs = new JLabel();
	private JLabel courseDep = new JLabel();
	private JComboBox courseComboBox = new JComboBox();
	private JLabel archive = new JLabel();
	private JTextField archiveTextField = new JTextField();
	/** Accept */
	private JButton acceptButton = new JButton("Aceptar");
	
	/** cancel */
	private JButton cancelButton = new JButton("Cancelar");
	
	public DeleteCurriculumCourse()
	{
		//		Frame configuration data
    	setName("Borrar curso del curriculo");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel("ELIMINAR CURSO DEL CURRICULO");
    	
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	title.setFont(new Font("Serif", Font.BOLD, 20));
       	courseDep.setText("Curso : "); courseDep.setFont(new Font("Serif", Font.BOLD, 20));
       	cancelButton.setToolTipText("Regresar a la pantalla anterior");
       	// Set components position
       	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	title.setBounds(15, 190, 450, 21);
    	courseDep.setBounds(180, 300, 160, 30);
    	courseComboBox.setBounds(360, 300, 220, 30);
    	acceptButton.setBounds(270, 510, 120, 30);
    	cancelButton.setBounds(520, 510, 120, 30);
    	//add components
    	add(label);
    	add(title);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(courseDep);
    	add(courseComboBox);
    	add(acceptButton);
    	add(cancelButton);
    	//listeners
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
		
		if (command.equalsIgnoreCase(ACCEPT))
    	{
			String course = "";
			try
			{
				course = getCourse((String)courseComboBox.getSelectedItem());
			}
			catch (Exception e )
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "No hay cursos en el curriculo.", "Error", 0);
				
			}
			
			CodRes res = manager.deleteCourseFromCurriculum(course);
			
			if ( res == CodRes.SUCCESS )
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Curso eliminado del curriculo.", "Exito", 1);
				cleanFields();
			}		    			
    	}
		else if (command.equalsIgnoreCase(CANCEL))
    	{
			lastFrame.setVisible(true);
			setVisible(false);
    	}
	}
	
	private void cleanFields() 
	{
		courseComboBox.removeAllItems();
		loadCourses();
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

	public void loadCourses()
	{
		courseComboBox.removeAllItems();
		ArrayList codes = new ArrayList();
		ArrayList names = new ArrayList();
		manager.getListOfCurriculumCourses(codes, names);
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
