/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     SetAcademicInformation.java 
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
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import coursemanager.controller.CManager;



//--------- Own libraries import 


// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class SetAcademicInformation extends JFrame implements ActionListener {
	/**
     * Constants
     */
    public final static String CANCEL = "Cancelar";
    
    private JFrame InterfazImpuestosCaro;
    protected JFrame PanleDescuentos;
    
    private CManager manager;
    private JFrame cordMenu;
	private JLabel textArea1 = new JLabel();
	private JLabel textArea2 = new JLabel();
	private JLabel textArea3 = new JLabel();
	
	/**	Student code label */
	private JLabel label1 = new JLabel();
	
	/**	Courses code label */
	private JLabel label2 = new JLabel();
	
	/**	Students semester label */
	private JLabel label3 = new JLabel();
	
	/**	Students credit number label */
	private JLabel label4 = new JLabel();
	
	/**	Students comments code label */
	private JLabel label5 = new JLabel();
	
	/**	Student code text field */
	private JTextField textField1 = new JTextField();
	
	/**	Courses code text field */
	private JTextField textField2 = new JTextField();
	
	/**	Students semester text field */
	private JTextField textField3 = new JTextField();
	
	/**	Students credit number text field */
	private JTextField textField4 = new JTextField();
	 /** Students comments*/
	private JTextArea textField5 = new JTextArea();
	
	/**	 accept button */
	private JButton button1 = new JButton();
	
	/**	cancel button */
	private JButton button2 = new JButton();
	
	public SetAcademicInformation()
	{
		//	Frame configuration data
		setName("Modificar Informacion Academica Estudiantes");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel();
    	// components boot
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	title.setText("Modificar Informaci�n Acad�mica Estudiantes"); title.setFont(new Font("Serif", Font.BOLD, 20));
    	label1.setText("C�digo estudiante:"); label1.setFont(new Font("Serif", Font.BOLD, 16));
    	label2.setText("C�digo del curso:"); label2.setFont(new Font("Serif", Font.BOLD, 16));
    	label3.setText("Semestre del estudiante:"); label3.setFont(new Font("Serif", Font.BOLD, 16));
    	label4.setText("N�mero de creditos estudiante:"); label4.setFont(new Font("Serif", Font.BOLD, 16));
    	label5.setText("Comentarios:"); label5.setFont(new Font("Serif", Font.BOLD, 16));
    	textField5.setRows(10);
    	button1.setText("Aceptar"); button1.setFont(new Font("Serif", Font.BOLD, 16));
    	button2.setText("Cancelar"); button2.setFont(new Font("Serif", Font.BOLD, 16));
    	// Set components position
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label.setBounds(10, 10, 159, 112);
    	title.setBounds(15, 190, 450, 21);
    	label1.setBounds(30, 250, 160, 21);
    	textField1.setBounds(180, 251, 170, 21);
    	label3.setBounds(30, 300, 200, 21);
    	textField3.setBounds(250, 301, 100, 21);
    	label4.setBounds(400, 300, 260, 21);
    	textField4.setBounds(650, 301, 160, 21);
    	label2.setBounds(30, 350, 160, 21);
    	textField2.setBounds(180, 350, 170, 21);
    	label5.setBounds(30, 380, 160, 21);
    	textField5.setBounds(30, 400, 600, 150);
    	button1.setBounds(645, 475, 120, 30);
    	button2.setBounds(645, 520, 120, 30);
    	// add components
    	add(label);
    	add(title);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(label1);
    	add(textField1);
    	add(label3);
    	add(textField3);
    	add(label4);
    	add(textField4);
    	add(label2);
    	add(textField2);
    	add(label5);
    	add(textField5);
    	add(button1);
    	add(button2);
    	//listeners
    	button2.setActionCommand(CANCEL);
        button2.addActionListener(this);
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
		String comando = event.getActionCommand( );
    	if( comando.equals( CANCEL ))	//Call of button to open entrance form for a new student
        {
    		this.setVisible(false);
    		cordMenu.setVisible(true);
        }    
    }

	public void setManager(CManager manager2) 
	{
		manager = manager2;		
	}

	public void setCordMenu(JFrame cordMenu) {
		this.cordMenu = cordMenu;
	}
}