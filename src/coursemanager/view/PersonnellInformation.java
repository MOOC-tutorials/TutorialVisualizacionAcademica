
package coursemanager.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;




/**
 * Panel para presentar la informaci�n de descuentos
 */
public class PersonnellInformation extends JFrame implements ActionListener {

	public final static String EXIT = "exit";
	public final static String GOBACK = "goback";
	public final static String ACCEPT = "accept";
	public final static String CANCEL = "cancel";
    
	private JLabel textArea1 = new JLabel();
	private JLabel textArea2 = new JLabel();
	private JLabel textArea3 = new JLabel();
	
	private JLabel label2 = new JLabel();	
	private JLabel label3 = new JLabel();	
	private JLabel label4 = new JLabel();	
	private JLabel label5 = new JLabel();	
	private JLabel label6 = new JLabel();	
	private JLabel label7 = new JLabel();	
	private JLabel label8 = new JLabel();	
	private JLabel label9 = new JLabel();	
	private JLabel label10 = new JLabel();	
	private JLabel label11 = new JLabel();
	final ButtonGroup group = new ButtonGroup();
	
	/** C.C id type */
	private JRadioButton radioButton1 = new JRadioButton();
	
	/**	C.C id type */
	private JRadioButton radioButton2 = new JRadioButton();
	
	/**	C.C id type */
	private JRadioButton radioButton3 = new JRadioButton();

	
	private JTextField tName = new JTextField();
	private JTextField tLastName = new JTextField();	
	private JTextField tAddress = new JTextField();	
	private JTextField tNumberPhone = new JTextField();	
	private JTextField tEmail = new JTextField();	
	private JTextField tNumberID = new JTextField();	
	private JTextField tAssistantName = new JTextField();	
	private JTextField tAssistantNumberPhone = new JTextField();
	private JTextField textField11 = new JTextField();
	
	private JLabel tittle;
	private boolean justSeeing = false;
	
	/**
	 * @@param justSeeing The justSeeing to set.
	 */
	public void setJustSeeing(boolean justSeeing)
	{
		this.justSeeing = justSeeing;
	}
	/**
	 * @@param tittle The tittle to set.
	 */	
	private JButton bExit ;
	private JButton bGoBack;
	
	private JButton bAccept ;
	private JButton bCancel;
	
	private JFrame lastFrame;
	private CManager manager;

	/**
	 * Class Constructor
	 * @@pre:
	 * @@pos:
	 */
	public PersonnellInformation()
	{
		
		lastFrame = new JFrame();
		String[] academicPrograms = {"Programa Acad�mco"};
		// Frame configuration data
		setTitle( "Informacion personal - CriolloSoft" );
        setSize( 900, 600 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        getContentPane().setLayout (null);
        
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel textArea1 = new JLabel();
    	JLabel textArea2 = new JLabel();
    	JLabel textArea3 = new JLabel();
    	tittle = new JLabel();    	
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	tittle.setText("Men� Estudiante"); 
    	tittle.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	// Set components position
    	textArea1.setBounds(280, 30, 460, 30);
    	textArea2.setBounds(280, 60, 460, 30);
    	textArea3.setBounds(280, 90, 460, 30);
    	label.setBounds(30, 20, 159, 112);
    	tittle.setBounds(126, 180, 450, 21);
    	bExit = new JButton(new ImageIcon ("data/salirMenu.JPG"));
    	bExit.setBounds(817, 523, 63, 37);
    	bGoBack = new JButton(new ImageIcon ("data/volver.JPG"));
    	bGoBack.setBounds(730, 523, 63, 37);
    	getContentPane().add(bGoBack);
    	getContentPane().add(bExit);
        
    	// components boot
       	radioButton1.setText("C.C"); radioButton1.setFont(new Font("Serif", Font.BOLD, 16));
       	group.add(radioButton1);
    	radioButton2.setText("C.E"); radioButton2.setFont(new Font("Serif", Font.BOLD, 16));
    	group.add(radioButton2);
    	radioButton3.setText("T.I"); radioButton3.setFont(new Font("Serif", Font.BOLD, 16));
    	group.add(radioButton3);
    	label2.setText("Nombres:"); label2.setFont(new Font("Serif", Font.BOLD, 16));
    	label3.setText("Apellidos:");label3.setFont(new Font("Serif", Font.BOLD, 16));
    	label4.setText("Direcci�n:"); label4.setFont(new Font("Serif", Font.BOLD, 16));
    	label5.setText("Tel�fono:"); label5.setFont(new Font("Serif", Font.BOLD, 16));
    	label6.setText("Correo electr�nico:"); label6.setFont(new Font("Serif", Font.BOLD, 16));
    	label7.setText("Tipo de documento:"); label7.setFont(new Font("Serif", Font.BOLD, 16));
    	label8.setText("N�mero de documento:"); label8.setFont(new Font("Serif", Font.BOLD, 16));
    	label9.setText("Nombre del Acudiente:"); label9.setFont(new Font("Serif", Font.BOLD, 16));
    	label10.setText("Tel�fono del Acudiente:"); label10.setFont(new Font("Serif", Font.BOLD, 16));
    	label11.setText("C�digo del estudiante:"); label11.setFont(new Font("Serif", Font.BOLD, 16));
    	label2.setBounds(30, 250, 160, 21);
    	tName.setBounds(200, 251, 160, 21);
    	label3.setBounds(490, 250, 160, 21);
    	tLastName.setBounds(670, 251, 160, 21);
    	label4.setBounds(30, 290, 160, 21);
    	tAddress.setBounds(200, 291, 160, 21);
    	label5.setBounds(490, 290, 160, 21);
    	tNumberPhone.setBounds(670, 291, 160, 21);
    	label11.setBounds(490, 330, 190, 21);
    	textField11.setBounds(670, 330, 160, 21);
    	label6.setBounds(30, 330, 190, 21);
    	tEmail.setBounds(200, 331, 160, 21);
    	label7.setBounds(30, 370, 140, 21);
    	label8.setBounds(490, 370, 160, 21);
    	tNumberID.setBounds(670, 371, 160, 21);
    	label9.setBounds(30, 420, 170, 21);
    	tAssistantName.setBounds(200, 421, 160, 21);
    	label10.setBounds(490, 420, 170, 21);
    	tAssistantNumberPhone.setBounds(670, 421, 160, 21);
    	radioButton1.setBounds(200, 370, 55, 21);
    	radioButton2.setBounds(260, 370, 55, 21);
    	radioButton3.setBounds(320, 370, 55, 21);

    	
    	bCancel = new JButton("Cancelar");
    	bCancel.setBounds(380, 480, 230, 40);
    	bAccept = new JButton("Aceptar");
    	bAccept.setBounds(90, 480, 230, 40);   
    	
    	// add components
    	getContentPane().add(radioButton1);
    	getContentPane().add(radioButton2);
    	getContentPane().add(radioButton3);
    	getContentPane().add(label);
    	getContentPane().add(textArea1);
    	getContentPane().add(textArea2);
    	getContentPane().add(textArea3);
    	getContentPane().add(tittle);
    	getContentPane().add(label2);
    	getContentPane().add(tName);
    	getContentPane().add(label3);
    	getContentPane().add(tLastName);
    	getContentPane().add(label4);
    	getContentPane().add(tAddress);
    	getContentPane().add(label5);
    	getContentPane().add(tNumberPhone);
    	add(label11);
    	add(textField11);
    	getContentPane().add(label6);
    	getContentPane().add(tEmail);
    	getContentPane().add(label7);
    	getContentPane().add(label8);
    	getContentPane().add(tNumberID);
    	getContentPane().add(label9);
    	getContentPane().add(tAssistantName);
    	getContentPane().add(label10);
    	getContentPane().add(tAssistantNumberPhone);
    	getContentPane().add(bAccept);
    	getContentPane().add(bCancel);

    	
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
    	bGoBack.addActionListener(this);
    	bAccept.setActionCommand(ACCEPT);
    	bAccept.addActionListener(this);
    	bCancel.setActionCommand(CANCEL);
    	bCancel.addActionListener(this);

	}
	
	
	
	/**
     * @@brief: Answer to the events in the elements of the interface.    
     * @@pre:     
     * @@post:
     * @@param: ActionEvent  
     * @@return: void
     * @@aditional_description:   
     */
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
				
		if (comando.equalsIgnoreCase(EXIT))
    	{
			System.exit( 0 );    			
    	}
		else if(comando.equalsIgnoreCase(GOBACK))
		{
				this.lastFrame.setVisible(true);
				this.setVisible(false);			
		}
		else if(comando.equalsIgnoreCase(ACCEPT))
		{
			//The student is looking at the information
			if (this.justSeeing)   //See personal info
			{				
				this.lastFrame.setVisible(true);
				this.setVisible(false);	
			}           
			else   //Change personal info
			{
				String newAddress = tAddress.getText();
				String newResp = tAssistantName.getText();
				String newRespPhone = tAssistantNumberPhone.getText();
				String newPhone = tNumberPhone.getText();
				String newEmail = tEmail.getText();
				String code = textField11.getText();
				Integer i = new Integer(code);
				int cod = i;
				CodRes res = manager.changeStudentPersonalInfo(cod, newPhone, newAddress, newEmail, newResp, newRespPhone);
				
				if ( res == CodRes.SUCCESS)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "Informaci�n modificada.", "Exito", 1);					
				}
				
			}	
		}
		else if(comando.equalsIgnoreCase(CANCEL))
		{
			this.lastFrame.setVisible(true);
			this.setVisible(false);		
		}
	}

	public void setManager(CManager ManManager) 
	{
		manager = ManManager;
		
	}

	public void setfields(int code) 
	{
		ArrayList personalData = new ArrayList();
		ArrayList responsibleData = new ArrayList();
		
		if(manager.verifyCode(code))
		{
			manager.showStudentPersonalInfo(code, personalData, responsibleData);
			
			//Info of the student.
			tName.setText( (String) personalData.get(0));
			tLastName.setText( (String) personalData.get(1));
			tAddress.setText( (String) personalData.get(2));
			tNumberPhone.setText( (String) personalData.get(3));
			tEmail.setText( (String) personalData.get(4));
			textField11.setText( (String) personalData.get(5));
			tNumberID.setText ((String) personalData.get(7));
			
			//Info of the responsible.
			tAssistantName.setText( (String) responsibleData.get(0));
			tAssistantNumberPhone.setText( (String) responsibleData.get(1));
			if (personalData.get(6).equals("CC"))
			{
				radioButton1.setSelected(true);
				radioButton2.setSelected(false);
				radioButton3.setSelected(false);
			} else if (personalData.get(6).equals("CE"))
			{
				radioButton1.setSelected(false);
				radioButton2.setSelected(true);
				radioButton3.setSelected(false);
			} else if (personalData.get(6).equals("TI"))
			{
				radioButton1.setSelected(false);
				radioButton2.setSelected(false);
				radioButton3.setSelected(true);
			}
		} 
		else 
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Estudiante no encontrado.", "Error", 0);
		}		
		
	}

	public void enableFieldsModify() 
	{
		tName.enable(false);
		tLastName.enable(false);	
		tEmail.enable(false);
		tNumberID.enable(false);
		textField11.enable(false);
		radioButton1.enable(false);
		radioButton2.enable(false);
		radioButton3.enable(false);
	}
	
	public void enableFieldsShow()
	{
		enableFieldsModify();
		tAssistantName.enable(false);
		tAssistantNumberPhone.enable(false);
		tAddress.enable(false);
		tNumberPhone.enable(false);
	}
	
	public void disable ()
	{
		tName.enable(true);
		tLastName.enable(true);	
		tEmail.enable(true);
		tNumberID.enable(true);
		textField11.enable(true);
		radioButton1.enable(true);
		radioButton2.enable(true);
		radioButton3.enable(true);
		tAssistantName.enable(true);
		tAssistantNumberPhone.enable(true);
		tAddress.enable(true);
		tNumberPhone.enable(true);

	}



	public void setLastFrame(JFrame menu) 
	{
		lastFrame = menu;
		
	}

	public JLabel getTittle() 
	{
		return tittle;
	}
}
