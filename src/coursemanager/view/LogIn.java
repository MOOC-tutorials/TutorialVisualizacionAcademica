/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



/**
 * @@author Familia
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LogIn extends JFrame implements ActionListener, FocusListener, KeyListener {
	
	private final static String LOGIN = "login";
	private final static String EXIT = "exit";
	
	private CManager manager;
	
	private JButton bLogin;
	private JTextField tLogin ;
    private JPasswordField tPassword;
    private JButton bExit;
    private StudentMenu stuMenu;
    private AdvisorMenu advMenu;
    private CoordinatorMenu cordMenu;
    private SetAcademicProgram setAcadProg;

	public LogIn()
    {
    	//manager = new CManager();	
		stuMenu = new StudentMenu ();
		advMenu = new AdvisorMenu ();
		cordMenu = new CoordinatorMenu();
		setAcadProg = new SetAcademicProgram();
		
		//throwManager();
		
		setTitle( "LogIn - CriolloSoft" );
        setSize( 900, 600 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
        setSize( 900, 600 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        getContentPane().setLayout (new BorderLayout());
        JPanel picture = new JPanel ();
 		picture.setLayout(null);
		picture.setPreferredSize(new Dimension(900,120));
    	JLabel label = new JLabel(new ImageIcon("images/uniandes.JPG"));
    	JLabel title = new JLabel();
    	JLabel textArea1 = new JLabel();
    	JLabel textArea2 = new JLabel();
    	JLabel textArea3 = new JLabel();
    	textArea1.setText("Sistema de visualización y control de la");
    	textArea2.setText("información académica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
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
    	title.setBounds(15, 190, 450, 21);
    	// add components
    	picture.add(label);
    	picture.add(title);
    	picture.add(textArea1);
    	picture.add(textArea2);
    	picture.add(textArea3);
        getContentPane().add(picture,BorderLayout.NORTH);
        
        JPanel principal = new JPanel ();
        principal.setLayout(new BorderLayout());
        getContentPane().add(principal,BorderLayout.CENTER);
        JPanel exit = new JPanel ();
        exit.setLayout(new BorderLayout());
        exit.setPreferredSize(new Dimension(900,50));
        exit.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        getContentPane().add(exit,BorderLayout.SOUTH);
        
        JLabel uniPicture = new JLabel (new ImageIcon ("images/logo.JPG"));
        picture.add(uniPicture,BorderLayout.WEST);
        JLabel tittPicture = new JLabel (new ImageIcon ("images/titulo.JPG"));
        picture.add(tittPicture,BorderLayout.EAST);
        tittPicture.setPreferredSize(new Dimension (850,120));
        bExit = new JButton (new ImageIcon ("images/salirMenu.JPG"));
        exit.add(bExit,BorderLayout.EAST);
        
        JPanel menu = new JPanel ();
        getContentPane().add(menu,BorderLayout.CENTER);
        menu.setLayout(new BorderLayout());
        menu.setBorder(BorderFactory.createEmptyBorder(100,300,100,300));
        
        JPanel pLogin = new JPanel ();
        pLogin.setLayout (new GridLayout(3,2));
        pLogin.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        pLogin.setPreferredSize(new Dimension (300,100));
        JLabel lLogin = new JLabel ("Login");
    	JLabel lPassword = new JLabel ("Password");
    	tLogin = new JTextField ("");
    	tLogin.setFocusable(true);
    	tPassword = new JPasswordField ("");
    	pLogin.add(lLogin);
    	pLogin.add(tLogin);
    	pLogin.add(new JLabel (""));
    	pLogin.add(new JLabel (""));
    	pLogin.add(lPassword);
    	pLogin.add(tPassword);
    		
    	menu.add(pLogin,BorderLayout.NORTH);
    	
    	JPanel pButton = new JPanel ();
    	pButton.setLayout (new GridLayout(1,1));
    	pButton.setPreferredSize(new Dimension (300,50));
    	pButton.setBorder(BorderFactory.createEmptyBorder(25,70,55,70));
    	bLogin = new JButton ("Login");
    	pButton.add(bLogin);
    	menu.add(pButton,BorderLayout.CENTER);

    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
    	bLogin.setActionCommand(LOGIN);
    	bLogin.addActionListener(this);
    	bLogin.addKeyListener(this);
    	tLogin.addFocusListener(this);
   }
	
	public void actionPerformed(ActionEvent arg0) 
	{
		String comando = arg0.getActionCommand();
		if (comando.equalsIgnoreCase(LOGIN))
		{	
			String user = tLogin.getText();
			char[] passw = tPassword.getPassword();
			// Student Menu
			CodRes res = manager.LogIn(passw, user);					
			if (res == CodRes.STUDENT)// || user.equals("e")) 
			{
				stuMenu.setLogIn (this);
				this.stuMenu.setVisible(true);
				this.setVisible(false);				
			}
			else if(res == CodRes.COORDINATOR)// || user.equals("c")) 
			{
				this.cordMenu.setVisible(true);
				cordMenu.setLogIn(this);
				this.setVisible(false);
			}
			//Counselor Menu
			else if (res == CodRes.ADVISOR) {				
				this.advMenu.setVisible(true);
				this.setVisible(false);
			}
			else {
				JOptionPane pane = new JOptionPane();
				pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
				JOptionPane.showMessageDialog(null, "Nombre de usuario o clave incorrectos", "Error", 0);    			
			}
			tLogin.requestFocusInWindow();
		} else if(comando.equalsIgnoreCase(EXIT))
		{
			System.exit( 0 );
		}
	}
	
	/**
	 * @@brief:   
	 * @@pre:     
	 * @@post:
	 * @@param:   
	 * @@return: 
	 * @@aditional_description:  
	 */
	private void throwManager()
	{
		stuMenu.setManager(manager);
		stuMenu.throwManager();
		advMenu.setManager(manager);
		cordMenu.setManager(manager);
		cordMenu.throwManager();
	}
	public void focusGained(FocusEvent e) 
	{
		tPassword.setText("");
		tLogin.setText("");
	}

	public void keyTyped(KeyEvent e) 
	{
		String user = tLogin.getText();
		char[] passw = tPassword.getPassword();				
		CodRes res = manager.LogIn(passw, user);					
		if (res == CodRes.STUDENT)// || user.equals("e"))
		{
			stuMenu.setLogIn (this);
			this.stuMenu.setVisible(true);
			this.setVisible(false);
			bLogin.setNextFocusableComponent(tLogin);				
		}
		else if(res == CodRes.COORDINATOR)// || user.equals("c"))
		{
			this.cordMenu.setVisible(true);
			cordMenu.setLogIn(this);
			this.setVisible(false);
			bLogin.setNextFocusableComponent(tLogin);
		}
		//Counselor Menu
		else if (res == CodRes.ADVISOR)
		{				
			this.advMenu.setVisible(true);
			this.setVisible(false);
			bLogin.setNextFocusableComponent(tLogin);
		}
		else
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Nombre de usuario o clave incorrectos", "Error", 0);    			
		}
	}

	public void focusLost(FocusEvent e) 
	{	
	}

	public void keyPressed(KeyEvent e) 
	{
	}

	public void keyReleased(KeyEvent e) 
	{	
	}
	
	public void setManager(CManager manager2) 
	{
		manager = manager2;
		throwManager();//Really important change!
	}	
}