/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



/**
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddDepartamentCourse extends JFrame implements ActionListener{
	
	private JButton bExit;
	private JButton bGoBack;
	private JTextField tName;
	private JTextField tCode;
	private JTextField tCreditNumber;
	private JTextField tLevel;
	private JButton bAccept;
	private JButton bCancel;
	private static final String EXIT = "exit";
	private static final String GOBACK = "goBack";
	private static final String ACCEPT = "accept";
	private static final String CANCEL = "cancel";
	private JLabel tittleja;
	private CManager manager;
	
	/**
	 * @@return Returns the title.
	 */

	
	private JFrame lastFrame;
	

	public AddDepartamentCourse  ()
	{
		setTitle( "Adicionar Curso a un Departamento - CriolloSoft" );
		setSize( 900, 600 );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		getContentPane().setLayout (null);
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	tittleja = new JLabel();
    	JLabel textArea1 = new JLabel();
    	JLabel textArea2 = new JLabel();
    	JLabel textArea3 = new JLabel();
    	JLabel tittle = new JLabel();    	
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	tittleja.setText("Adicionar Curso a Departamento"); 
    	tittleja.setFont(new Font("Serif", Font.BOLD, 20));
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
    	tittleja.setBounds(126, 180, 450, 21);
    	//add components
    	getContentPane().add(label);
    	getContentPane().add(tittle);
    	getContentPane().add(textArea1);
    	getContentPane().add(textArea2);
    	getContentPane().add(textArea3);
    	getContentPane().add(tittleja);
    	bExit = new JButton(new ImageIcon ("data/salirMenu.JPG"));
    	bExit.setBounds(817, 523, 63, 37);
    	bGoBack = new JButton(new ImageIcon ("data/volver.JPG"));
    	bGoBack.setBounds(730, 523, 63, 37);
    	getContentPane().add(bGoBack);
    	getContentPane().add(bExit);
    	JLabel lName = new JLabel ("Nombre");
    	lName.setFont(new Font("Serif", Font.BOLD, 15));
    	lName.setBounds(150, 250, 300, 30);
    	JLabel lCode = new JLabel ("Codigo");
    	lCode.setFont(new Font("Serif", Font.BOLD, 15));
    	lCode.setBounds(150, 290, 300, 30);
    	JLabel lCreditNumber = new JLabel ("Numero de Creditos");
    	lCreditNumber.setFont(new Font("Serif", Font.BOLD, 15));
    	lCreditNumber.setBounds(150, 330, 300, 30);
    	JLabel lLevel = new JLabel ("Nivel");
    	lLevel.setFont(new Font("Serif", Font.BOLD, 15));
    	lLevel.setBounds(150, 370, 300, 30);
    	
    	tName = new JTextField ("");
    	tName.setBounds (370, 250, 300, 30);
    	tCode = new JTextField ("");
    	tCode.setBounds(370,290,300,30);
    	tCreditNumber = new  JTextField ("");
    	tCreditNumber.setBounds(370,330,300,30);
    	tLevel = new JTextField ("");
    	tLevel.setBounds(370,370,300,30);
    	
    	bAccept = new JButton ("Aceptar");
    	bAccept.setFont(new Font("Serif", Font.BOLD, 18));
    	bAccept.setBounds(200, 440, 180, 40);
    	bCancel = new JButton ("Cancelar");
    	bCancel.setFont(new Font("Serif", Font.BOLD, 18));
    	bCancel.setBounds(420, 440, 180, 40);
    	
    	
    	
    	
    	getContentPane().add(lName);
    	getContentPane().add(lCode);
    	getContentPane().add(lCreditNumber);
    	getContentPane().add(lLevel);
    	getContentPane().add(tName);
    	getContentPane().add(tCode);
    	getContentPane().add(tCreditNumber);
    	getContentPane().add(tLevel);
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
	
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
		
		if (comando.equalsIgnoreCase(EXIT))
    		{
			System.exit( 0 );    			
    			}
		else if(comando.equalsIgnoreCase(GOBACK)){
				this.lastFrame.setVisible(true);
				this.setVisible(false);			
				}
		else if(comando.equalsIgnoreCase(ACCEPT))
		{
			try
			{
				CodRes res;
				String credit = tCreditNumber.getText();
				Float f = new Float(credit);
				float creditNum = f;
				String level = tLevel.getText();
				Integer i = new Integer(level);
				int cLevel = i;
				res = manager.createCourse(tName.getText(), tCode.getText(), creditNum, cLevel, "", "");
				if(res == CodRes.SUCCESS)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "Curso adicionado correctamente", "Exito", 1);
				}
				else if(res == CodRes.INVALID_ARGUMENTS)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "Campos invalidos. Intente rellenarlos nuevamente", "Error", 0);
				}
				else if(res == CodRes.ERROR)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "El departamento no existe", "Error", 0);
				}
				else if( res == CodRes.ALREADY_EXISTS)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "Curso existente", "Advertencia", 2);
					
				}
				cleanFields();
			}
			catch ( Exception e)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Ingrese todos los datos.", "Advertencia", 2);
			}
		}
		else if(comando.equalsIgnoreCase(CANCEL)){
			this.lastFrame.setVisible(true);
			this.setVisible(false);		
			}
	}


	/**
	 * @@param lastFrame The lastFrame to set.
	 */
	public void setLastFrame(JFrame lastFrame) {
		this.lastFrame = lastFrame;
	}
	/**
	 * @@return Returns the tittle.
	 */
	public JLabel getTittle() {
		return tittleja;
	}

	public void setManager(CManager manager2)
	{
		manager = manager2;		
	}
	
	public void cleanFields () 
	{
		tName.setText("");
		tCode.setText("");
		tCreditNumber.setText("");
		tLevel.setText("");
	}
}