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

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



/**
 * @@author Familia
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeleteDepartamentCourse extends JFrame implements ActionListener
{
	private JButton bExit;
	private JButton bGoBack;
	private JLabel tittleja;
	private JComboBox courses;
	private JButton bDelete;
	private JButton bCancel;
	private CManager manager;
	private static final String CANCEL = "cancel";
	private static final String DELETE = "delete";
	private static final String GOBACK = "goback";
	private static final String EXIT = "exit";
	
	private JFrame lastFrame;

	/**
	 * @@param lastFrame The lastFrame to set.
	 */
	public void setLastFrame(JFrame lastFrame)
	{
		this.lastFrame = lastFrame;
	}
	
	public DeleteDepartamentCourse ()
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
    	tittleja.setText("Borrar Curso de un  Departamento"); 
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
    	
    	courses = new JComboBox ();
    	courses.setBounds(300,250,300,30);
    	getContentPane().add(courses);
    	bDelete = new JButton ("Eliminar");
    	bDelete.setFont(new Font("Serif", Font.BOLD, 18));
    	bDelete.setBounds(150, 340, 200, 40);
    	getContentPane().add(bDelete);
    	
    	bCancel = new JButton ("Cancelar");
    	bCancel.setFont(new Font("Serif", Font.BOLD, 18));
    	bCancel.setBounds(550, 340, 200, 40);
    	getContentPane().add(bCancel);
       	
    	getContentPane().add(bGoBack);
    	getContentPane().add(bExit);
    	
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
    	bGoBack.addActionListener(this);
    	bDelete.setActionCommand(DELETE);
    	bDelete.addActionListener(this);
    	bCancel.setActionCommand(CANCEL);
    	bCancel.addActionListener(this);

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
		else if(comando.equalsIgnoreCase(DELETE))
		{
			int i = 0;
			String chain = (String)courses.getSelectedItem();
			String code = "";
			CodRes res;
			while ( chain != null && chain.charAt(i+1) != '-')
			{
				code += chain.charAt(i);
				i++;
			}
			res = manager.deleteCourse(code);
			
			if ( res == CodRes.INVALID_ARGUMENTS)
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "No hay cursos para eliminar", "Advertencia", 2);			
			}
			else
			{
				JOptionPane pane = new JOptionPane();
	    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
	    		JOptionPane.showMessageDialog(null, "Curso eliminado correctamente", "Exito", 3);
	    		this.lastFrame.setVisible(true);
	    		this.setVisible(false);
			}
			
		}
		else if(comando.equalsIgnoreCase(CANCEL))
		{
			this.lastFrame.setVisible(true);
			this.setVisible(false);		
		}		
	}

	public void loadDepartmentCourses()
	{
		courses.removeAllItems();
		ArrayList codes = new ArrayList();
		ArrayList names = new ArrayList();
		manager.getListDepartmentCourses("", codes, names);
		Iterator it1 = codes.iterator();	
		Iterator it2 = names.iterator();
		String codeCourse, nameCourse, toPrint;
		while ( it1.hasNext())
		{
			codeCourse = (String)it1.next();
			nameCourse = (String)it2.next();
			toPrint = codeCourse + " - " + nameCourse;
			courses.addItem(toPrint);			
		}
	}
	
	public void setManager(CManager manager2) 
	{
		manager = manager2;
		
	}
}