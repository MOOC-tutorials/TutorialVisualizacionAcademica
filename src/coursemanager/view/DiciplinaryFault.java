/*
 * @@Project  c2_Visualizacion_Control_Informacion_Academica
 * @@file     VirtualFolderMenu.java 
 * @@brief    
 * @@version  1.0
 * @@author   CriolloSoft
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



// -------- Class declaration and documentation
/**<br> Class specification <\br>
 * @@brief: Frame to display coordinators menu.       
 * @@invariant:   
 * @@par:  	
 */
public class DiciplinaryFault extends JFrame implements ActionListener
{	/**
     * Constants
     */
    public final static String SEND = "send";
    public final static String ERASE = "erase";
    public final static String GOBACK = "goback";
    public final static String EXIT = "exit";
    
	private JLabel textArea1 = new JLabel();
    private JLabel textArea2 = new JLabel();
    private JLabel textArea3 = new JLabel();

	private JLabel rLabel = new JLabel("Enviar a :");
	
	private JTextField receptor = new JTextField();
	
	private JLabel aLabel = new JLabel("Tipo de falta :");
	
	private JTextField asunto = new JTextField();
	
	private JTextArea mensaje = new JTextArea();
	
	private JButton enviar = new JButton("Enviar");
	
	private JButton borrar = new JButton("Borrar");
	
	private JButton button = new JButton(new ImageIcon("data/salirMenu.JPG"));
	
	private JButton bGoBack= new JButton(new ImageIcon ("data/volver.JPG"));
	
	private JFrame lastFrame;
	
	private CManager manager;
	
	public DiciplinaryFault()
	{
		JLabel label1 = new JLabel("FALTAS DICIPLINARIAS");
		JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
		borrar.setToolTipText("Limpiar el formulario");
		receptor.setToolTipText("Ingrese el codigo de identificaci�n �nica del estudiante");
		//		 Frame configuration data
    	setTitle("Men� de faltas diciplinarias");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	rLabel.setFont(new Font("Serif", Font.BOLD, 16));
    	aLabel.setFont(new Font("Serif", Font.BOLD, 16));
    	
    	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label1.setBounds(15, 180, 280, 21);
    	rLabel.setBounds(40, 220, 100, 26);
    	receptor.setBounds(140, 220, 240, 26);
    	aLabel.setBounds(40, 250, 100, 26);
    	asunto.setBounds(140, 250, 240, 26);
    	mensaje.setBounds(140, 300, 600, 170);
    	enviar.setBounds(650, 480, 100, 26);
    	borrar.setBounds(760, 480, 100, 26);
    	button.setBounds(820, 520, 63, 37);
		bGoBack.setBounds(730, 523, 63, 37);
		
		add(label);
    	add(label1);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(aLabel);
    	add(asunto);
    	add(rLabel);
    	add(receptor);
    	add(mensaje);
    	add(enviar);
    	add(borrar);
    	add(button);
    	add(bGoBack);
    	
    	button.addActionListener(this);
    	button.setActionCommand(EXIT);
    	bGoBack.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
    	borrar.addActionListener(this);
    	borrar.setActionCommand(ERASE);
    	enviar.addActionListener(this);
    	enviar.setActionCommand(SEND);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		String command = event.getActionCommand();
		if( command.equalsIgnoreCase(ERASE))
		{
			cleanTextFields();
		}
		else if( command.equalsIgnoreCase(SEND))
		{
			String to = receptor.getText();
			try
			{
				Integer i = new Integer(to);
				sendDiciplinaryFault(to);
			}
			catch(Exception e)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Debe ingresar un codigo para el destinatario", "Error", 0);
				receptor.setText("");
			}			
		}
		else if (command.equalsIgnoreCase(EXIT))
    	{
			System.exit( 0 );    			
    	}
		else if(command.equalsIgnoreCase(GOBACK))
		{
				this.lastFrame.setVisible(true);
				this.setVisible(false);			
		}
		
	}

	private void sendDiciplinaryFault(String to) 
	{
		String as = asunto.getText();
		String bodyM = mensaje.getText();
		if(to.equals(""))
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "No ha ingresado ningun estudiante", "Error", 0);	
		}
		else if(bodyM.equals(""))
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Debe ingresar un comentario para la falta" , "Error", 0);
		}
		else
		{
			CodRes res = manager.sendMessage(to, as, bodyM, true);
			if(res == CodRes.SUCCESS)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Se realizo la amonestaci�n", "Transacci�n exitosa", 1);
			}
			else if(res == CodRes.INEXISTENT)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "No existe un estudiante con identificacion " + to, "Error", 0);
			}
			lastFrame.setVisible(true);
			setVisible(false);
			cleanTextFields();
		}
		
	}

	public void setManager(CManager manager2) 
	{
		manager = manager2;
	}

	public void setLastFrame(JFrame menu) 
	{
		lastFrame = menu;		
	}
	
	private void cleanTextFields()
	{
		asunto.setText("");
		receptor.setText("");
		mensaje.setText("");
	}
}