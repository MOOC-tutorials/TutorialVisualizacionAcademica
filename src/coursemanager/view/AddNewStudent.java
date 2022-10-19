/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     AddNewStudent.java 
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
public class AddNewStudent extends JFrame implements ActionListener {
	/**
     * Constants
     */
    public final static String CANCEL = "Cancelar";
    public final static String ACCEPT = "Aceptar";
    public final static String CHECKED = "true"; 
    
    private JFrame cordMenu;
    private JFrame AddTransferCourse;
    private CManager manager;
    
	private JLabel textArea1 = new JLabel();
	private JLabel textArea2 = new JLabel();
	private JLabel textArea3 = new JLabel();
	
	/**	Name label */
	private JLabel label2 = new JLabel();
	
	/**LastName label	 */
	private JLabel label3 = new JLabel();
	
	/**	Address label */
	private JLabel label4 = new JLabel();
	
	/**	Telephone label */
	private JLabel label5 = new JLabel();
	
	/**	e-mail label */
	private JLabel label6 = new JLabel();
	
	/**	Id type label */
	private JLabel label7 = new JLabel();
	
	/**	id number label */
	private JLabel label8 = new JLabel();
	
	/**	Responsible label */
	private JLabel label9 = new JLabel();
	
	/**	responsible phone label */
	private JLabel label10 = new JLabel();
	
	/**	students code */
	private JLabel label11 = new JLabel();
	
	/** Name text field */
	private JTextField textField1 = new JTextField();
	
	/**	Lastname text field */
	private JTextField textField2 = new JTextField();
	
	/**	Address text field */
	private JTextField textField3 = new JTextField();
	
	/**	Telephone text field */
	private JTextField textField4 = new JTextField();
	
	/**	e-mail text field */
	private JTextField textField5 = new JTextField();
	
	/**	id text field */
	private JTextField textField6 = new JTextField();
	
	/**	Responsible text field */
	private JTextField textField7 = new JTextField();
	
	/**	Responsible's phone text field */
	private JTextField textField8 = new JTextField();
	
	/**	Students code text field */
	private JTextField textField11 = new JTextField();
	
	/** C.C id type */
	private JRadioButton radioButton1 = new JRadioButton();
	
	/**	C.C id type */
	private JRadioButton radioButton2 = new JRadioButton();
	
	/**	C.C id type */
	private JRadioButton radioButton3 = new JRadioButton();
	
	/**	C.C id type */
	private JCheckBox checkBox1 = new JCheckBox();
	
	/**	C.C id type */
	private JCheckBox checkBox2 = new JCheckBox();
	
	/**	buttongroup to handle radio buttons */
	private ButtonGroup group = new ButtonGroup();
	
	/**	 add button */
	private JButton button1 = new JButton();
	
	/**	cancel button */
	private JButton button2 = new JButton();
	
	/**
	 * Class Constructor
	 * @@pre: CManager is a reference to the manager
	 * @@pos: The frame is created correctly
	 */
	public AddNewStudent()
	{
		String[] academicPrograms = {"Programa Acad�mico"};
		// Frame configuration data
    	setName("Agregar estudiantes");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel label1 = new JLabel();
    	JComboBox comboBox = new JComboBox(academicPrograms);
    	// components boot
    	label1.setText("INGRESAR ESTUDIANTE NUEVO");
    	label1.setFont(new Font("Serif", Font.BOLD, 20));
    	label.setToolTipText("Regresar al men�");
    	label.setBounds(10, 10, 159, 112);
    	label1.setBounds(15, 210, 320, 21);
    	comboBox.setBounds(500, 461, 160, 21);
    	setFrame();
    	// add components
    	add(label);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(label1);
    	add(label2);
    	add(textField1);
    	add(label3);
    	add(textField2);
    	add(label4);
    	add(textField3);
    	add(label5);
    	add(textField4);
    	add(label6);
    	add(textField5);
    	add(label11);
    	add(textField11);
    	add(label7);
    	add(radioButton1);
    	add(radioButton2);
    	add(radioButton3);
    	add(label8);
    	add(textField6);
    	add(label9);
    	add(textField7);
    	add(label10);
    	add(textField8);
    	add(checkBox1);
    	add(checkBox2);
    	add(comboBox);
    	add(button1);
    	add(button2);
    	//listeners
    	button2.setActionCommand(CANCEL);
        button2.addActionListener(this);
        button1.setActionCommand(ACCEPT);
        button1.addActionListener(this);
       
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
    	else if(comando.equals(ACCEPT))
    	{
    		createNewStudent();
    		setVisible(false);
    		cordMenu.setVisible(true);
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
	private void setFrame()
	{
		textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	label2.setText("Nombres:"); label2.setFont(new Font("Serif", Font.BOLD, 16));
    	label3.setText("Apellidos:");label3.setFont(new Font("Serif", Font.BOLD, 16));
    	label4.setText("Direcci�n:"); label4.setFont(new Font("Serif", Font.BOLD, 16));
    	label5.setText("Tel�fono:"); label5.setFont(new Font("Serif", Font.BOLD, 16));
    	label6.setText("Correo electr�nico:"); label6.setFont(new Font("Serif", Font.BOLD, 16));
    	label11.setText("C�digo del estudiante:"); label11.setFont(new Font("Serif", Font.BOLD, 16));
    	label7.setText("Tipo de documento:"); label7.setFont(new Font("Serif", Font.BOLD, 16));
    	label8.setText("N�mero de documento:"); label8.setFont(new Font("Serif", Font.BOLD, 16));
    	label9.setText("Nombre del Acudiente:"); label9.setFont(new Font("Serif", Font.BOLD, 16));
    	label10.setText("Tel�fono del Acudiente:"); label10.setFont(new Font("Serif", Font.BOLD, 16));
    	radioButton1.setText("C.C"); radioButton1.setFont(new Font("Serif", Font.BOLD, 16));
    	radioButton2.setText("C.E"); radioButton2.setFont(new Font("Serif", Font.BOLD, 16));
    	radioButton3.setText("T.I"); radioButton3.setFont(new Font("Serif", Font.BOLD, 16));
    	checkBox1.setText("Primer Semestre"); checkBox1.setFont(new Font("Serif", Font.BOLD, 16));
    	checkBox2.setText("Transferencia"); checkBox2.setFont(new Font("Serif", Font.BOLD, 16));
    	button1.setText("Agregar"); button1.setFont(new Font("Serif", Font.BOLD, 16));
    	button2.setText("Cancelar"); button2.setFont(new Font("Serif", Font.BOLD, 16));
    	group.add(radioButton1);
    	group.add(radioButton2);
    	group.add(radioButton3);
    	// Set components position
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label2.setBounds(30, 250, 160, 21);
    	textField1.setBounds(200, 251, 160, 21);
    	label3.setBounds(490, 250, 160, 21);
    	textField2.setBounds(670, 251, 160, 21);
    	label4.setBounds(30, 290, 160, 21);
    	textField3.setBounds(200, 291, 160, 21);
    	label5.setBounds(490, 290, 160, 21);
    	textField4.setBounds(670, 291, 160, 21);
    	label6.setBounds(30, 330, 190, 21);
    	textField5.setBounds(200, 331, 160, 21);
    	label11.setBounds(490, 330, 190, 21);
    	textField11.setBounds(670, 330, 160, 21);
    	label7.setBounds(30, 370, 140, 21);
    	radioButton1.setBounds(200, 370, 55, 21);
    	radioButton2.setBounds(260, 370, 55, 21);
    	radioButton3.setBounds(320, 370, 55, 21);
    	label8.setBounds(490, 370, 160, 21);
    	textField6.setBounds(670, 371, 160, 21);
    	label9.setBounds(30, 420, 170, 21);
    	textField7.setBounds(200, 421, 160, 21);
    	label10.setBounds(490, 420, 170, 21);
    	textField8.setBounds(670, 421, 160, 21);
    	checkBox1.setBounds(100, 461, 150, 21);
    	checkBox2.setBounds(299, 461, 150, 21);
    	button1.setBounds(200, 525, 160, 30);
    	button2.setBounds(600, 525, 160, 30);
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: 
	 * @@aditional_description:  
	 */
	private void createNewStudent()
	{
		String str2 = textField11.getText();
		if (str2.compareTo("") == 0 || textField1.getText().compareTo("") == 0 || textField2.getText().compareTo("") == 0 || textField6.getText().compareTo("") == 0)
		{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "No ha ingresado un codigo para el estudiante", "Error", 0);
		}
		else if(str2.compareTo("") != 0 )
		{
			if(checkBox2.isSelected())
			{
				String str ="C�digo estudiante: ";
				str = str.concat(str2);
				AddTransferCourse atc = new AddTransferCourse(manager, str);
    			atc.setVisible(true);
    		}
			else
			{	
				JOptionPane pane = new JOptionPane();
				String type = "";
				if(radioButton1.isSelected())
				{
					type = "CC";
				}
				else if(radioButton2.isSelected())
				{
					type = "CE";
				}
				else if(radioButton3.isSelected())
				{
					type = "TI";
				}

				try
				{
					String code = textField11.getText();
					Integer i = new Integer(code);
					int numCode = i;
					
					manager.addStudent(textField1.getText(), textField2.getText(), textField5.getText(), numCode, textField3.getText(), type, textField6.getText(), textField4.getText(), textField7.getText(), textField8.getText(), "ISIS");//, "n-cardz");
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "El estudiante ha sido ingresado correctamente", "Atenci�n", JOptionPane.INFORMATION_MESSAGE);
				}
				catch (Exception e)
				{
					JOptionPane panel = new JOptionPane();
		    		panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
		    		JOptionPane.showMessageDialog(null, "El codigo debe ser num�rico", "Error", 0);					
				}
				

			}
		}
	}

	public void setManager(CManager manager2) 
	{
		manager = manager2;		
	}

	public void setCordMenu(JFrame menu) 
	{
		cordMenu = menu;		
	}
}