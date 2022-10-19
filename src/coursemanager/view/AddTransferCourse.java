/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     AddTransferCourse.java 
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
import javax.swing.*;

import coursemanager.controller.CManager;


//--------- Own libraries import 

// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class AddTransferCourse extends JFrame implements ActionListener {
	 /**
     * Constants
     */
    public final static String INSERT = "Adjuntar y Agregar Materia";
    public final static String COMMIT = "Adjuntar Materia";
    public final static String CANCEL = "Cancelar";
    
    private JFrame PlanDescuentos;
    
    private CManager manager;
    
	private JLabel textArea1 = new JLabel();
	private JLabel textArea2 = new JLabel();
	private JLabel textArea3 = new JLabel();
	
	/** commit and add other */
	private JButton button1 = new JButton();
	
	/** commit */
	private JButton button2 = new JButton();
	
	/** cancel */
	private JButton button3 = new JButton();
	
	/** Course label */
	private JLabel label2 = new JLabel();
	
	/**	Students code label */
	private JLabel label3 = new JLabel();
	
	/** Course textField */
	private JTextField textField1 = new JTextField();
	
	public AddTransferCourse(CManager pNManager, String str)
	{
		manager = pNManager;
		//	Frame configuration data
    	setName("Agregar materia estudiantes transferencia");
    	setLayout(null);
    	setSize(750, 500);
    	setResizable( false );
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel label1 = new JLabel();
    	//    	 components boot
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	label1.setText("AGREGAR MATERIA EXTERNA");
    	label1.setFont(new Font("Serif", Font.BOLD, 20));
    	label2.setText("Materia:");
    	label2.setFont(new Font("Serif", Font.BOLD, 20));
    	label3.setText(str); label3.setFont(new Font("Serif", Font.BOLD, 16));
    	button1.setText("Adjuntar y Agregar Materia"); button1.setFont(new Font("Serif", Font.BOLD, 14));
    	button2.setText("Adjuntar Materia"); button2.setFont(new Font("Serif", Font.BOLD, 14));
    	button3.setText("Cancelar"); button3.setFont(new Font("Serif", Font.BOLD, 14));
    	//    	 Set components position
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label.setBounds(10, 10, 159, 112);
    	label1.setBounds(15, 210, 320, 21);
    	label2.setBounds(400, 260, 200, 21);
    	textField1.setBounds(500, 260, 160, 21);
    	label3.setBounds(30, 260, 260, 21);
    	button1.setBounds(100, 330, 210, 30);
    	button2.setBounds(400, 330, 210, 30);
    	button3.setBounds(270, 400, 210, 30);
    	//    	 add components
    	add(label);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(label1);
    	add(label2);
    	add(textField1);
    	add(label3);
    	add(button1);
    	add(button2);
    	add(button3);
    	// listeners
    	button1.setActionCommand(INSERT);
    	button1.addActionListener(this);
    	button2.setActionCommand(COMMIT);
    	button2.addActionListener(this);
    	button3.setActionCommand(CANCEL);
    	button3.addActionListener(this);
    	
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
		AddNewStudent iic = new AddNewStudent();
		
		String comando = event.getActionCommand( );
    	if( comando.equals(INSERT))	//Call of button to open entrance form for a new student
        {
    		//metodo de insertar materia
    		textField1.setText("");
        }    
    	else if( comando.equals(COMMIT))	//Call of button to open entrance form for a new student
        {
    		//    		metodo de insertar materia
    		this.setVisible(false);
        }   
    	else if( comando.equals(CANCEL))	//Call of button to open entrance form for a new student
        {
    		this.setVisible(false);
        }   
    }

}