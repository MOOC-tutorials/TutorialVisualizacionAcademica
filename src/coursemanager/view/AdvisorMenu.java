/*
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import coursemanager.controller.CManager;



/**
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdvisorMenu extends JFrame implements ActionListener{
	
	public final static String EXIT = "exit";
	public final static String PERSONNEL = "personnel";
	public final static String ACADEMIC = "academic";
	public final static String FOLDER = "folder";
	
	private JButton bExit ;
	private JButton bPersonInformat;
	private JButton bAcadmicInfor;
	private JButton bVirtFold;
	
	private ShowAcademicInformation acadeInf;
	private PersonnellInformation persInformation;
	private CManager manager;
	

	public AdvisorMenu()
    {
		this.persInformation = new PersonnellInformation();
		this.acadeInf = new ShowAcademicInformation();
		
		
    	setTitle( "Menu Consejero - CriolloSoft" );
        setSize( 900, 600 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        getContentPane().setLayout (new BorderLayout());
        JPanel picture = new JPanel ();
 		picture.setLayout(null);
		picture.setPreferredSize(new Dimension(900,205));
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel();
    	JLabel textArea1 = new JLabel();
    	JLabel textArea2 = new JLabel();
    	JLabel textArea3 = new JLabel();
    	JLabel tittle = new JLabel();    	
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	title.setText("Men� Consejero"); 
    	title.setFont(new Font("Serif", Font.BOLD, 20));
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
    	title.setBounds(126, 180, 450, 21);
    	// add components
    	picture.add(label);
    	picture.add(title);
    	picture.add(textArea1);
    	picture.add(textArea2);
    	picture.add(textArea3);
    	picture.add(tittle);

    	getContentPane().add(picture,BorderLayout.NORTH);
        JPanel principal = new JPanel ();
        principal.setLayout(new BorderLayout());
        getContentPane().add(principal,BorderLayout.CENTER);
        JPanel exit = new JPanel ();
        exit.setLayout(new BorderLayout());
        exit.setPreferredSize(new Dimension(900,50));
        exit.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        getContentPane().add(exit,BorderLayout.SOUTH);
        
        JLabel uniPicture = new JLabel (new ImageIcon ("data/logo.JPG"));
        picture.add(uniPicture,BorderLayout.WEST);
        JLabel tittPicture = new JLabel (new ImageIcon ("data/titulo.JPG"));
        picture.add(tittPicture,BorderLayout.EAST);
        tittPicture.setPreferredSize(new Dimension (850,120));
        bExit = new JButton (new ImageIcon ("data/salirMenu.JPG"));
        exit.add(bExit,BorderLayout.EAST);
        
        JPanel menu = new JPanel ();
        getContentPane().add(menu,BorderLayout.CENTER);
        menu.setLayout(new GridLayout(2,3));
        menu.setBorder(BorderFactory.createEmptyBorder(20,150,20,150));
       
        
        
        JPanel persoInformat = new JPanel ();
        persoInformat.setLayout (new BorderLayout());
        persoInformat.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        JLabel nPI = new JLabel ("   Ver Informacion Personal");
        persoInformat.add(nPI,BorderLayout.CENTER);
        nPI.setPreferredSize(new Dimension (150,40));
        bPersonInformat = new JButton (new ImageIcon("data/personal.JPG"));
        persoInformat.add(bPersonInformat,BorderLayout.NORTH);
		
        
        JPanel acadmicInfor = new JPanel ();
        acadmicInfor.setLayout (new BorderLayout());
        acadmicInfor.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        JLabel nAI = new JLabel (" Ver Informacion Academica");
        acadmicInfor.add(nAI,BorderLayout.CENTER);
        nAI.setPreferredSize(new Dimension (150,40));
        bAcadmicInfor = new JButton (new ImageIcon("data/academica.JPG"));
        acadmicInfor.add(bAcadmicInfor,BorderLayout.NORTH);  
        
               
		JPanel virtFold = new JPanel ();
        virtFold.setLayout (new BorderLayout());
        virtFold.setBorder(BorderFactory.createEmptyBorder(15,15,0,15));
        JLabel nFV = new JLabel ("            Folder Virtual");
        virtFold.add(nFV,BorderLayout.CENTER);
        nFV.setPreferredSize(new Dimension (150,40));
        bVirtFold = new JButton (new ImageIcon("data/folder.JPG"));
        virtFold.add(bVirtFold,BorderLayout.NORTH); 
	/*	
        JPanel virtFold = new JPanel ();
        virtFold.setLayout (new BorderLayout());
        virtFold.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        academInformat*/
        
        menu.add(persoInformat);
        menu.add(new JLabel (""));
        menu.add(acadmicInfor);
        menu.add(new JLabel (""));
        menu.add(virtFold);
        menu.add(new JLabel (""));
 
        
    	
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
    	bPersonInformat.setActionCommand(PERSONNEL);
    	bPersonInformat.addActionListener(this);
    	bAcadmicInfor.setActionCommand(ACADEMIC);
    	bAcadmicInfor.addActionListener(this);
    	bVirtFold.setActionCommand(FOLDER);
    	bVirtFold.addActionListener(this);
    }
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
		
		if (comando.equalsIgnoreCase(EXIT))
			{
			System.exit( 0 );
				}
		else if(comando.equalsIgnoreCase(PERSONNEL)){
			String code = JOptionPane.showInputDialog(this,"Ingrese el codigo del estudiante del \n cual quiere ver la informacion");
			Integer codeNum = new Integer (code);
			persInformation.setManager(manager);
			persInformation.setfields(codeNum.intValue());
			this.persInformation.setLastFrame(this);
			this.persInformation.getTittle().setText("Informacion Personal Estudiante");
			this.persInformation.setJustSeeing(true);
			this.persInformation.setVisible(true);
			this.setVisible(false);
				
			}
		else if(comando.equalsIgnoreCase(ACADEMIC)){
			String nomCarpeta = JOptionPane.showInputDialog(this,"Ingrese el codigo del estudiante del \n cual quiere ver la informacion");
			String ja [][]={{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"},{"Juan","Hola","3","5.0"}};
			this.acadeInf.setLastFrame(this);
			this.acadeInf.setTable(ja);
			this.acadeInf.setVisible(true);
			this.setVisible(false);	
			
		}
		else if(comando.equalsIgnoreCase(FOLDER)){
			JOptionPane.showMessageDialog(this,"El folder virtual se implementara en el Ciclo 2","Folder Virtual - CriolloSoft", JOptionPane.INFORMATION_MESSAGE);            		
		}

	}


	public void setManager(CManager ManManager) 
	{
		manager = ManManager;		
	}

}