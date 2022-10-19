/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import coursemanager.controller.CManager;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @@author Familia
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ShowAcademicInformation extends JFrame implements ActionListener
{
	public final static String EXIT = "exit";
	public final static String GOBACK = "goback";
	public final static String LAST = "last";
	public final static String NEXT = "next";
	
	private JFrame lastFrame;
	
	private JButton bExit ;
	private JButton bNext;
	private JButton bLast;
	private JButton bGoBack;
	private	String [][] tableCourse;
	
	private JLabel course1 = new JLabel ("");
	private JLabel course2 = new JLabel ("");
	private JLabel course3 = new JLabel ("");
	private JLabel course4 = new JLabel ("");
	private JLabel course5 = new JLabel ("");
	private JLabel course6 = new JLabel ("");
	private JLabel course7 = new JLabel ("");
	private JLabel course8 = new JLabel ("");
	private JLabel course9 = new JLabel ("");
	private JLabel course10 = new JLabel ("");
	
	private JLabel courseName1 = new JLabel ("");
	private JLabel courseName2 = new JLabel ("");
	private JLabel courseName3 = new JLabel ("");
	private JLabel courseName4 = new JLabel ("");
	private JLabel courseName5 = new JLabel ("");
	private JLabel courseName6 = new JLabel ("");
	private JLabel courseName7 = new JLabel ("");
	private JLabel courseName8 = new JLabel ("");
	private JLabel courseName9 = new JLabel ("");
	private JLabel courseName10 = new JLabel ("");
	
	private JLabel courseCredit1 = new JLabel ("");
	private JLabel courseCredit2 = new JLabel ("");
	private JLabel courseCredit3 = new JLabel ("");
	private JLabel courseCredit4 = new JLabel ("");
	private JLabel courseCredit5 = new JLabel ("");
	private JLabel courseCredit6 = new JLabel ("");
	private JLabel courseCredit7 = new JLabel ("");
	private JLabel courseCredit8 = new JLabel ("");
	private JLabel courseCredit9 = new JLabel ("");
	private JLabel courseCredit10 = new JLabel ("");
	
	private JLabel courseQualification1 = new JLabel ("");
	private JLabel courseQualification2 = new JLabel ("");
	private JLabel courseQualification3 = new JLabel ("");
	private JLabel courseQualification4 = new JLabel ("");
	private JLabel courseQualification5 = new JLabel ("");
	private JLabel courseQualification6 = new JLabel ("");
	private JLabel courseQualification7 = new JLabel ("");
	private JLabel courseQualification8 = new JLabel ("");
	private JLabel courseQualification9 = new JLabel ("");
	private JLabel courseQualification10 = new JLabel ("");
	
	private JLabel averageNow = new JLabel ("5.0");
	private JLabel averageAcumulate = new JLabel ("5.0");
	
	private CManager manager;
	
	public ShowAcademicInformation ()
	{
		lastFrame = new JFrame ();
		
		this.setTitle( "Menu Estudiante - CriolloSoft" );
		this.setSize( 900, 600 );
		this.setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		getContentPane().setLayout(null);
    	JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
    	JLabel title = new JLabel("Informacion Academica");
    	bExit = new JButton(new ImageIcon ("data/salirMenu.JPG"));
    	bExit.setBounds(817, 523, 63, 37);
    	bGoBack = new JButton(new ImageIcon ("data/volver.JPG"));
    	bGoBack.setBounds(730, 523, 63, 37);
    	bNext = new JButton("Siguiente");
    	bNext.setBounds(380, 523, 230, 25);
    	bLast = new JButton("Anterior");
    	bLast.setBounds(90, 523, 230, 25);   	
    	JLabel time = new JLabel("Semestre 2001-1");
    	time.setFont(new Font("Serif", Font.BOLD, 15));
    	time.setForeground(Color.BLUE);
    	time.setBounds(92, 200, 400, 25);
    	getContentPane().add(time);
    	JLabel textCurso = new JLabel("CODIGO");
    	textCurso.setFont(new Font("Serif", Font.BOLD, 15));
    	textCurso.setForeground(Color.RED);
    	textCurso.setBounds(130, 230, 300, 25);
    	getContentPane().add(textCurso);
    	JLabel textCodigo = new JLabel("CURSO");
    	textCodigo.setFont(new Font("Serif", Font.BOLD, 15));
    	textCodigo.setForeground(Color.RED);
    	textCodigo.setBounds(347, 230, 300, 25);
    	getContentPane().add(textCodigo);
    	JLabel textCreditos = new JLabel("CREDITOS");
    	textCreditos.setFont(new Font("Serif", Font.BOLD, 15));
    	textCreditos.setForeground(Color.RED);
    	textCreditos.setBounds(540, 230, 300, 25);
    	getContentPane().add(textCreditos);
    	JLabel textNota = new JLabel("NOTA");
    	textNota.setFont(new Font("Serif", Font.BOLD, 15));
    	textNota.setForeground(Color.RED);
    	textNota.setBounds(717, 230, 300, 25);
    	getContentPane().add(textNota);
    	
    	averageNow.setFont(new Font("Serif", Font.BOLD, 15));
    	averageNow.setBounds(440, 490, 60, 25);
    	
    	averageAcumulate.setFont(new Font("Serif", Font.BOLD, 15));
    	averageAcumulate.setBounds(725, 490, 200, 25);
    	
    	
    	JLabel textAverageNow = new JLabel("PROMEDIO SEMESTRE: ");
    	textAverageNow.setFont(new Font("Serif", Font.BOLD, 15));
    	textAverageNow.setForeground(Color.RED);
    	textAverageNow.setBounds(238, 490, 190, 25);
    	getContentPane().add(textAverageNow);
    	
    	JLabel textAverageAcumulate = new JLabel("PROMEDIO ACUMULADO: ");
    	textAverageAcumulate.setFont(new Font("Serif", Font.BOLD, 15));
    	textAverageAcumulate.setForeground(Color.RED);
    	textAverageAcumulate.setBounds(500, 490, 220, 25);
    	getContentPane().add(textAverageAcumulate);
    	
    	
    	course1.setFont(new Font("Serif", Font.BOLD, 13));
    	course1.setBackground(new java.awt.Color(239, 239, 239));
    	course1.setBounds(130, 270, 300, 25);
    	course2.setFont(new Font("Serif", Font.BOLD, 13));
    	course2.setBackground(new java.awt.Color(239, 239, 239));
    	course2.setBounds(130, 290, 300, 25);
    	course3.setFont(new Font("Serif", Font.BOLD, 13));
    	course3.setBackground(new java.awt.Color(239, 239, 239));
    	course3.setBounds(130, 310, 300, 25);
    	course4.setFont(new Font("Serif", Font.BOLD, 13));
    	course4.setBackground(new java.awt.Color(239, 239, 239));
    	course4.setBounds(130, 330, 300, 25);
    	course5.setFont(new Font("Serif", Font.BOLD, 13));
    	course5.setBackground(new java.awt.Color(239, 239, 239));
    	course5.setBounds(130, 350, 300, 25);
    	course6.setFont(new Font("Serif", Font.BOLD, 13));
    	course6.setBackground(new java.awt.Color(239, 239, 239));
    	course6.setBounds(130, 370, 300, 25);
    	course7.setFont(new Font("Serif", Font.BOLD, 13));
    	course7.setBackground(new java.awt.Color(239, 239, 239));
    	course7.setBounds(130, 390, 300, 25);
    	course8.setFont(new Font("Serif", Font.BOLD, 13));
    	course8.setBackground(new java.awt.Color(239, 239, 239));
    	course8.setBounds(130, 410, 300, 25);
    	course9.setFont(new Font("Serif", Font.BOLD, 13));
    	course9.setBackground(new java.awt.Color(239, 239, 239));
    	course9.setBounds(130, 430, 300, 25);
    	course10.setFont(new Font("Serif", Font.BOLD, 13));
    	course10.setBackground(new java.awt.Color(239, 239, 239));
    	course10.setBounds(130, 450, 300, 25);
    	
    	courseName1.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName1.setBackground(new java.awt.Color(239, 239, 239));
    	courseName1.setBounds(310, 270, 300, 25);
    	courseName2.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName2.setBackground(new java.awt.Color(239, 239, 239));
    	courseName2.setBounds(310, 290, 300, 25);
    	courseName3.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName3.setBackground(new java.awt.Color(239, 239, 239));
    	courseName3.setBounds(310, 310, 300, 25);
    	courseName4.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName4.setBackground(new java.awt.Color(239, 239, 239));
    	courseName4.setBounds(310, 330, 300, 25);
    	courseName5.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName5.setBackground(new java.awt.Color(239, 239, 239));
    	courseName5.setBounds(310, 350, 300, 25);
    	courseName6.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName6.setBackground(new java.awt.Color(239, 239, 239));
    	courseName6.setBounds(310, 370, 300, 25);
    	courseName7.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName7.setBackground(new java.awt.Color(239, 239, 239));
    	courseName7.setBounds(310, 390, 300, 25);
    	courseName8.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName8.setBackground(new java.awt.Color(239, 239, 239));
    	courseName8.setBounds(310, 410, 300, 25);
    	courseName9.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName9.setBackground(new java.awt.Color(239, 239, 239));
    	courseName9.setBounds(310, 430, 300, 25);
    	courseName10.setFont(new Font("Serif", Font.BOLD, 13));
    	courseName10.setBackground(new java.awt.Color(239, 239, 239));
    	courseName10.setBounds(310, 450, 300, 25);
    	
    	courseCredit1.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit1.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit1.setBounds(580, 270, 300, 25);
    	courseCredit2.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit2.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit2.setBounds(580, 290, 300, 25);
    	courseCredit3.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit3.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit3.setBounds(580, 310, 300, 25);
    	courseCredit4.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit4.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit4.setBounds(580, 330, 300, 25);
    	courseCredit5.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit5.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit5.setBounds(580, 350, 300, 25);
    	courseCredit6.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit6.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit6.setBounds(580, 370, 300, 25);
    	courseCredit7.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit7.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit7.setBounds(580, 390, 300, 25);
    	courseCredit8.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit8.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit8.setBounds(580, 410, 300, 25);
    	courseCredit9.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit9.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit9.setBounds(580, 430, 300, 25);
    	courseCredit10.setFont(new Font("Serif", Font.BOLD, 13));
    	courseCredit10.setBackground(new java.awt.Color(239, 239, 239));
    	courseCredit10.setBounds(580, 450, 300, 25);
    	
    	courseQualification1.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification1.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification1.setBounds(740, 270, 300, 25);
    	courseQualification2.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification2.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification2.setBounds(740, 290, 300, 25);
    	courseQualification3.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification3.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification3.setBounds(740, 310, 300, 25);
    	courseQualification4.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification4.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification4.setBounds(740, 330, 300, 25);
    	courseQualification5.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification5.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification5.setBounds(740, 350, 300, 25);
    	courseQualification6.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification6.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification6.setBounds(740, 370, 300, 25);
    	courseQualification7.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification7.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification7.setBounds(740, 390, 300, 25);
    	courseQualification8.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification8.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification8.setBounds(740, 410, 300, 25);
    	courseQualification9.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification9.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification9.setBounds(740, 430, 300, 25);
    	courseQualification10.setFont(new Font("Serif", Font.BOLD, 13));
    	courseQualification10.setBackground(new java.awt.Color(239, 239, 239));
    	courseQualification10.setBounds(740, 450, 300, 25);
    	
    	
    	
    	
    	
    	JLabel textArea1 = new JLabel();
    	JLabel textArea2 = new JLabel();
    	JLabel textArea3 = new JLabel();
    	title.setFont(new Font("Serif", Font.BOLD, 20));
    	
    	
    	
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
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
    	title.setBounds(126, 160, 450, 21);
    	// add components
    	
    	
    	

    	getContentPane().add(course1);
    	getContentPane().add(course2);
    	getContentPane().add(course3);
    	getContentPane().add(course4);
    	getContentPane().add(course5);
    	getContentPane().add(course6);
    	getContentPane().add(course7);
    	getContentPane().add(course8);
    	getContentPane().add(course9);
    	getContentPane().add(course10);
    	
    	getContentPane().add(courseName1);
    	getContentPane().add(courseName2);
    	getContentPane().add(courseName3);
    	getContentPane().add(courseName4);
    	getContentPane().add(courseName5);
    	getContentPane().add(courseName6);
    	getContentPane().add(courseName7);
    	getContentPane().add(courseName8);
    	getContentPane().add(courseName9);
    	getContentPane().add(courseName10);
    	
    	getContentPane().add(courseCredit1);
    	getContentPane().add(courseCredit2);
    	getContentPane().add(courseCredit3);
    	getContentPane().add(courseCredit4);
    	getContentPane().add(courseCredit5);
    	getContentPane().add(courseCredit6);
    	getContentPane().add(courseCredit7);
    	getContentPane().add(courseCredit8);
    	getContentPane().add(courseCredit9);
    	getContentPane().add(courseCredit10);
    	
    	getContentPane().add(courseQualification1);
    	getContentPane().add(courseQualification2);
    	getContentPane().add(courseQualification3);
    	getContentPane().add(courseQualification4);
    	getContentPane().add(courseQualification5);
    	getContentPane().add(courseQualification6);
    	getContentPane().add(courseQualification7);
    	getContentPane().add(courseQualification8);
    	getContentPane().add(courseQualification9);
    	getContentPane().add(courseQualification10);
    	
    	getContentPane().add(bGoBack);
    	getContentPane().add(bLast);
    	getContentPane().add(bNext);
    	getContentPane().add(averageNow);
    	getContentPane().add(averageAcumulate);
    	getContentPane().add(label);
    	getContentPane().add(title);
    	getContentPane().add(textArea1);
    	getContentPane().add(textArea2);
    	getContentPane().add(textArea3);
    	getContentPane().add(bExit);
    	
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
    	bNext.setActionCommand(NEXT);
    	bNext.addActionListener(this);
    	bLast.setActionCommand(LAST);
    	bLast.addActionListener(this);
    	bGoBack.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
	}

	/**
	 * @@param tableCourse The tableCourse to set.
	 */
	
	public void setTable (String [][] tableCourse)
	{
		course1.setText(tableCourse[0][0]);
    	course2.setText(tableCourse[1][0]);
    	course3.setText(tableCourse[2][0]);
    	course4.setText(tableCourse[3][0]);
    	course5.setText(tableCourse[4][0]);
    	course6.setText(tableCourse[5][0]);
    	course7.setText(tableCourse[6][0]);
    	course8.setText(tableCourse[7][0]);
    	course9.setText(tableCourse[8][0]);
    	course10.setText(tableCourse[9][0]);
    	
    	courseName1.setText(tableCourse[0][1]);
    	courseName2.setText(tableCourse[1][1]);
    	courseName3.setText(tableCourse[2][1]);
    	courseName4.setText(tableCourse[3][1]);
    	courseName5.setText(tableCourse[4][1]);
    	courseName6.setText(tableCourse[5][1]);
    	courseName7.setText(tableCourse[6][1]);
    	courseName8.setText(tableCourse[7][1]);
    	courseName9.setText(tableCourse[8][1]);
    	courseName10.setText(tableCourse[9][1]);
    	
    	courseCredit1.setText(tableCourse[0][2]);
    	courseCredit2.setText(tableCourse[1][2]);
    	courseCredit3.setText(tableCourse[2][2]);
    	courseCredit4.setText(tableCourse[3][2]);
    	courseCredit5.setText(tableCourse[4][2]);
    	courseCredit6.setText(tableCourse[5][2]);
    	courseCredit7.setText(tableCourse[6][2]);
    	courseCredit8.setText(tableCourse[7][2]);
    	courseCredit9.setText(tableCourse[8][2]);
    	courseCredit10.setText(tableCourse[9][2]);
    	
    	courseQualification1.setText(tableCourse[0][3]);
    	courseQualification2.setText(tableCourse[1][3]);
    	courseQualification3.setText(tableCourse[2][3]);
    	courseQualification4.setText(tableCourse[3][3]);
    	courseQualification5.setText(tableCourse[4][3]);
    	courseQualification6.setText(tableCourse[5][3]);
    	courseQualification7.setText(tableCourse[6][3]);
    	courseQualification8.setText(tableCourse[7][3]);
    	courseQualification9.setText(tableCourse[8][3]);
    	courseQualification10.setText(tableCourse[9][3]);    	
    
		
		}
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
		
		if (comando.equalsIgnoreCase(EXIT))
    		{
			System.exit( 0 );    			
    			}
		else if(comando.equalsIgnoreCase(LAST)){

		
			}
		else if(comando.equalsIgnoreCase(NEXT)){

			
				}
		else if(comando.equalsIgnoreCase(GOBACK)){
				this.lastFrame.setVisible(true);
				this.setVisible(false);
			
				}
	}
	/**
	 * @@param lastFrame The lastFrame to set.
	 */
	public void setLastFrame(JFrame lastFrame)
	{
		this.lastFrame = lastFrame;
	}

	public void setManager(CManager manager2) 
	{
		manager = manager2;	
	}
}