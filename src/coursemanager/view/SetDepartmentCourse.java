/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

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



/**
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SetDepartmentCourse extends JFrame implements ActionListener{
	
	/**
	 * SetDepartmentCourse.java:long. Represents 
	 */
	private static final long serialVersionUID = -1967598240272194906L;
	private JButton bExit;
	private JButton bGoBack;
	private JComboBox tCodeBox;
	private JTextField tName1;
	private JTextField tCreditNumber;
	private JTextField tLevel;
	private JButton bAccept;
	private JButton bCancel;
	private static final String EXIT = "exit";
	private static final String GOBACK = "goBack";
	private static final String ACCEPT = "accept";
	private static final String CANCEL = "cancel";
	private static final String CODEBOX = "codebox";
	private JLabel tittleja;
	private CManager manager;
	
	/**
	 * @@return Returns the title.
	 */

	
	private JFrame lastFrame;
	

	public SetDepartmentCourse  ()
	{
		setTitle( "Modificar Curso a un Departamento - CriolloSoft" );
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
    	tittleja.setText("Modificar Curso a Departamento"); 
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
    	// add components
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
    	JLabel lName = new JLabel ("Codigo");
    	lName.setFont(new Font("Serif", Font.BOLD, 15));
    	lName.setBounds(150, 250, 300, 30);
    	JLabel lCode = new JLabel ("Nombre");
    	lCode.setFont(new Font("Serif", Font.BOLD, 15));
    	lCode.setBounds(150, 290, 300, 30);
    	JLabel lCreditNumber = new JLabel ("Numero de Creditos");
    	lCreditNumber.setFont(new Font("Serif", Font.BOLD, 15));
    	lCreditNumber.setBounds(150, 330, 300, 30);
    	JLabel lLevel = new JLabel ("Nivel");
    	lLevel.setFont(new Font("Serif", Font.BOLD, 15));
    	lLevel.setBounds(150, 370, 300, 30);
    	
    	tCodeBox = new JComboBox ();
    	tCodeBox.setBounds (370, 250, 300, 30);
    	tName1 = new JTextField ("");
    	tName1.setBounds(370,290,300,30);
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
    	getContentPane().add(tCodeBox);
    	getContentPane().add(tName1);
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
    	tCodeBox.setActionCommand(CODEBOX);
    	tCodeBox.addActionListener(this);

		
	}
	
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
			int i = 0;
			String chain = "";
			try
			{
				chain = (String)tCodeBox.getSelectedItem();
				
				String code = "";
				CodRes res;
				while ( chain != null && chain.charAt(i+1) != '-')
				{
					code += chain.charAt(i);
					i++;
				}
				String credit = tCreditNumber.getText();
				Float f = new Float(credit);
				float creditNum = f;
				String level = tLevel.getText();
				Integer in = new Integer(level);
				int cLevel = in;
				res = manager.setInfoCourse(tName1.getText(), creditNum, code, cLevel);
				
				if ( res == CodRes.SUCCESS)
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "Curso modificado", "Exito", 1);
				}
				else
				{
					JOptionPane pane = new JOptionPane();
					pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
					JOptionPane.showMessageDialog(null, "Informaci�n invalida", "Error", 0);				
				}
				cleanFields();				
			}
			catch ( Exception e)
			{
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "No hay cursos creados.", "Advertencia", 2);
			}
	
		}
		else if(comando.equalsIgnoreCase(CANCEL))
		{
			this.lastFrame.setVisible(true);
			this.setVisible(false);		
		}
		else if(comando.equalsIgnoreCase(CODEBOX))
		{
			cleanFields();
			ArrayList<String> arrInfo = new ArrayList<String>();
			String chain = (String)tCodeBox.getSelectedItem();
			String code = chain.split(" - ")[0];
			manager.getInfoCourse(code, arrInfo);
			tName1.setText((String)arrInfo.get(0));
			tCreditNumber.setText((String)arrInfo.get(1));
			tLevel.setText((String)arrInfo.get(2));				
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
		tName1.setText("");
		tCreditNumber.setText("");
		tLevel.setText("");
	}
	
	public void loadDepartmentCourses()
	{
		tCodeBox.removeAllItems();
		ArrayList<String> codes = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();
		manager.getListDepartmentCourses("", codes, names);
		Iterator<String> it1 = codes.iterator();	
		Iterator<String> it2 = names.iterator();
		String codeCourse, nameCourse, toPrint;
		while ( it1.hasNext())
		{
			codeCourse = (String)it1.next();
			nameCourse = (String)it2.next();
			toPrint = codeCourse + " - " + nameCourse;
			tCodeBox.addItem(toPrint);			
		}
	}

}