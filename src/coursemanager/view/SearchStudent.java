/*
 * @@Project  c1_Visualizacion_Control_Informacion_Academica
 * @@file     SearchStudent.java 
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import coursemanager.controller.CManager;
import coursemanager.model.*;


//--------- Own libraries import 

// -------- Class declaration and documentation



/**<br> Class specification <\br>
 * @@brief:       
 * @@invariant:   
 * @@par:  	
 */
public class SearchStudent extends JInternalFrame implements ActionListener{

	public final static String ACCEPT = "aceptar";
	
	 private JLabel label1 = new JLabel();
	
	 private JTextField textField1 = new JTextField();
	
	 private JButton button1 = new JButton();
	
	 private CManager manager;
	 
	public SearchStudent()
	{
		setName("Busqueda estudiante ");
    	setLayout(null);
    	setSize(300, 200);
    	setResizable( false );
		label1.setText("codigo del estudiante");
		label1.setBounds(10, 10, 160, 21);
		textField1.setBounds(160, 10, 160, 21);
		button1.setText("Aceptar");
		
		add(label1);
		add(textField1);
		add(button1);
		
		button1.setActionCommand(ACCEPT);
        button1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand( );
    	if( command.equals( ACCEPT ))	//Call of button to open entrance form for a new student
        {
    		PersonnellInformation pi = new PersonnellInformation(); 
    		String code = textField1.getText();
    		Integer i = new Integer(code);
    		int numberCode = i;
    		if(manager.verifyCode(numberCode))
    		{
    			pi.setManager(manager);
    			this.setVisible(false);
    			pi.setVisible(true);
    		}
    		else
    		{
    			JOptionPane pane = new JOptionPane();
        		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
        		JOptionPane.showMessageDialog(null, "estudiante no existe", "Error", 0);
    		}
        }    
	}
	
	public void setManager(CManager pManager)
	{
		manager = pManager;
	}

	public void throwManager() 
	{		
		
	}
}
