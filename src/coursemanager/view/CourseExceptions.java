/*
 * @@Project  c2_Visualizacion_Control_Informacion_Academica
 * @@file     VirtualFolderMenu.java 
 * @@brief    
 * @@version  1.0
 * @@par                           
 * @@todo     
 * @@bug     
 */
//--------- Present package declaration
package coursemanager.view;

//--------- Standar Libraries import
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief: Frame to display coordinators menu.       
 * @@invariant:   
 * @@par:  	
 */
public class CourseExceptions extends JFrame implements ActionListener
{	/**
     * Constants
     */
    public final static String EXIT = "exit";
    public final static String GOBACK = "goback";
	
    private JLabel textArea1 = new JLabel();
    private JLabel textArea2 = new JLabel();
    private JLabel textArea3 = new JLabel();
	
    private JButton button = new JButton(new ImageIcon("data/salirMenu.JPG"));
	
	private JButton bGoBack= new JButton(new ImageIcon ("data/volver.JPG"));
	
	private JFrame lastFrame;
	
	private CManager manager;
	
	/**
	 * Class Constructor
	 */
	public CourseExceptions()
	{
		JLabel label1 = new JLabel("CREACI�N DE EXCEPCIONES");
		JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
		//		 Frame configuration data
    	setTitle("Excepciones");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	
    	label1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	//    	Set components position
    	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label1.setBounds(15, 180, 300, 21);
    	
    	button.setBounds(820, 520, 63, 37);
    	bGoBack.setBounds(730, 523, 63, 37);
    	//  	add components
    	add(label);
    	add(label1);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	
    	add(bGoBack);
    	add(button);
    	
    	button.addActionListener(this);
    	button.setActionCommand(EXIT);
    	bGoBack.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		String command = event.getActionCommand( );
		if(command.equalsIgnoreCase(GOBACK))
		{
				this.lastFrame.setVisible(true);
				this.setVisible(false);			
		}
		else if(command.equals(EXIT))
    	{
			System.exit( 0 );	
    	}		
	}

	public void setLastFrame(JFrame menu) 
	{
		lastFrame = menu;
	}

	public void setManager(CManager manager2) 
	{
		manager = manager2;
	}

}