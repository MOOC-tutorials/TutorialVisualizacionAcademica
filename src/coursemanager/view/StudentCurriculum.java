/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package coursemanager.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import coursemanager.controller.CManager;
import coursemanager.model.CodRes;



/**
 * @@author Familia
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StudentCurriculum extends JFrame implements ActionListener, Observer
{
	private static final String CURR_COUR_COMBO = "course_curr_course";
	private static final String CBUA_COMBO = "cbua_course";
	private static final String CBUB_COMBO = "cbub_course";
	private static final String MOVEUP = "moveup";
	private static final String SAVE = "save";
	private static final String EXIT = "exit";
	private static final String MOVEDOWN = "movedown";
	private static final String ADDCOURSE = "addcourse";
	private static final String CURRI = "curriculo";
	private static final String MOVEOUT = "moveOut";
	private static final String AREA = "area";
	
	private boolean esta = false;
	private Color color ;
	private JTextArea amarillo;
	private JTextArea azul;
	private JComboBox curricCourses;
	private JTextArea[][] courses = new JTextArea[11][11];
	private JButton[] addButtons = new JButton[7];
	private JTextArea[] addCourses = new JTextArea[7];
	private JComboBox[] addSemes = new JComboBox[7];
	private JComboBox areas = new JComboBox();
	private JComboBox cbub = new JComboBox();
	private JButton forward = new JButton (new ImageIcon ("data/atrascurso.JPG"));
	private JButton next = new JButton  (new ImageIcon ("data/siguientecurso.JPG"));
	private JButton moveOutCourse = new JButton (new ImageIcon ("data/borrar.JPG"));
	private int[] nextFree = new int[10];
	private int iClick = 0;
	private int jClick = 0;
	private JLabel cumpliminetoCurriculo = new JLabel("Cumplimiento del Curriculo:");
	private JTextField cumCurr = new JTextField();
	private JButton curriButton = new JButton("Cumplimiento de curriculo");
	private JLabel lookLabel = new JLabel (new ImageIcon ("data/ver.JPG"));
	private JRadioButton look = new JRadioButton ();
	private JLabel selectLabel = new JLabel (new ImageIcon ("data/ver.JPG"));
	private JRadioButton select = new JRadioButton ();
	final ButtonGroup group = new ButtonGroup();
	private CManager manager;
	private JButton bMoveUp = new JButton (new ImageIcon("data/flechaArriba.JPG"));
	private JButton bMoveDown = new JButton (new ImageIcon("data/flechaAbajo.JPG"));
	private JButton bExit = new JButton(new ImageIcon("data/salirMenu.JPG"));
	private JButton bSave = new JButton(new ImageIcon ("data/volver.JPG"));
	private int lastSelected = 0;
	private JFrame lastFrame = new JFrame ();
	
	
	public StudentCurriculum ()
	{
		// Creating the frame
		setTitle( "Crear - Modificar Curriculo - CriolloSoft" );
		setSize( 900, 600 );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		getContentPane().setLayout (null);
		getContentPane().setBackground(new java.awt.Color(239, 239, 239));
		
		// Creating the tittle
		JLabel textArea1 = new JLabel();
		JLabel tittle = new JLabel();    
		textArea1.setText("CURRICULO A PLANEAR");
		textArea1.setFont(new Font("Arial", Font.BOLD, 25));		
		textArea1.setBounds(50, 30, 460, 30);		
		getContentPane().add(textArea1);
		
		//Creating check boxs and buttons
		lookLabel.setBounds(30, 530, 100, 20);		
		getContentPane().add(lookLabel);
		look.setBounds(20, 530, 20, 20);
		look.setBackground(new java.awt.Color(239, 239, 239));
		getContentPane().add(look);
		selectLabel.setBounds(150, 530, 100, 20);		
		getContentPane().add(selectLabel);
		select.setBounds(140, 530, 20, 20);
		select.setBackground(new java.awt.Color(239, 239, 239));
		getContentPane().add(select);
		group.add(look);
		group.add(select);
		bMoveUp.setBounds(350, 520, 80, 40);
		bMoveUp.setBackground(new java.awt.Color(239, 239, 239));
		getContentPane().add(bMoveUp);
		bMoveDown.setBounds(480, 520, 80, 40);
		moveOutCourse.setBounds(590, 520, 80, 40);
		bMoveDown.setBackground(new java.awt.Color(239, 239, 239));
		getContentPane().add(bMoveDown);
		bSave.setBounds(750, 520, 63, 37);
		getContentPane().add(bSave);
		bExit.setBounds(820, 520, 63, 37);
		getContentPane().add(bExit);
    		areas.setVisible(false);
    		cbub.setVisible(false);
		// Creating the curriculum panel
		JPanel curriculum = new JPanel ();
    	TitledBorder border = BorderFactory.createTitledBorder("Curriculo");
    	border.setTitleColor(Color.RED);
    	curriculum.setBorder (border);    	
    	curriculum.setBounds(10,80,625,435);
    	curriculum.setBackground(new java.awt.Color(239, 239, 239));
    	JLabel labelSemestre[] = new JLabel[10];
    	for (int j = 0 ; j<10 ; j++)
    	{
    		Integer jj = new Integer(j+1);
    		labelSemestre[j] = new JLabel (jj.toString());
    		labelSemestre[j].setFont(new Font("Serif", Font.BOLD, 15));
    		labelSemestre [j].setForeground(Color.GRAY);
    		labelSemestre[j].setBounds(15,110+40*j,20,30);
    		getContentPane().add(labelSemestre[j]);   		
    	}
    		
    	// Creating the add course panel
    	JPanel addCourse = new JPanel ();
    	TitledBorder borderAdd = BorderFactory.createTitledBorder("Agregar Curso");
    	borderAdd.setTitleColor(Color.RED);
    	addCourse.setBorder (borderAdd);    
    	JLabel course = new JLabel ("Curso");
    	addCourse.setBounds(650,80,230,435);
    	addCourse.setBackground(new java.awt.Color(239, 239, 239));
    	areas.setBounds(680, 135, 170, 20);
    	getContentPane().add(areas);
    	cbub.setBounds(680, 160, 170, 20);
    	getContentPane().add(cbub);
    	curricCourses = new JComboBox ();
    	curricCourses.setBounds(680,110,170,20);
    	getContentPane().add(curricCourses);
    	course.setBounds(820,200,50,20);
    	getContentPane().add(course);
    	JLabel semes = new JLabel ("Semestre");    	
    	semes.setBounds(740,200,60,20);
    	getContentPane().add(semes);
    	String[] semestreNumber = {"1","2","3","4","5","6","7","8","9","10"};
    	for (int i=0; i<7;i++)
    	{
    		addButtons[i] = new JButton (new ImageIcon ("data/flecha.JPG"));
    		addButtons[i].setBounds(670,230+i*40,50,30);
    		getContentPane().add(addButtons[i]);
    		addCourses[i] =  new JTextArea ();
    		addCourses[i].setFont(new Font ("Serif", Font.BOLD, 10));
    		addCourses[i].setCaretColor(Color.WHITE);
    		addCourses[i].setForeground(new java.awt.Color(255, 255, 255));
    		addCourses[i].setBackground(Color.BLUE);
    		addCourses[i].setBounds(810,230+i*40,50,30);
    		getContentPane().add(addCourses[i]);
    		addSemes[i] = new JComboBox (semestreNumber);   
    		addSemes[i].setBounds(740,230+i*40,50,30);
    		getContentPane().add(addSemes[i]);
    	}
    	cumCurr.setEnabled(false);
    	cumCurr.setVisible(false);
    	cumCurr.setBounds(745, 425, 30, 22);
    	getContentPane().add(cumCurr);
    	curriButton.setBounds(660, 400, 195, 20);
    	getContentPane().add(curriButton);
    	forward.setBounds(685,475,70,30);
    	forward.setBackground(new java.awt.Color(239, 239, 239));
    	next.setBounds(780,475,70,30);
    	next.setBackground(new java.awt.Color(239, 239, 239));
    	getContentPane().add(forward);
    	getContentPane().add(next);   
    	getContentPane().add(moveOutCourse);
    	
				
		// Creating labels from curriculum 
    	createAllJLabel();
		cleanAllJLabel();
		createPosition();
		addAllJLabel();
		setColorAllJPanel();
		courses[1][1].setBackground(Color.RED);
		for (int k = 0; k<10 ; k++)
		{
			nextFree[k] = 0;
		}
		
		// Adding curriculum panel and add course panel
		getContentPane().add(curriculum);
		getContentPane().add(addCourse);
		
		
//		 Da click y llama a jLabel2MouseReleased
		
		for (int i = 0 ; i<10; i++)
		{
			iClick = i;
			for (int j = 0 ; j<10; j++)
			{
				jClick = j;
				// Da click y llama a jLabel2MouseReleased
				courses[i][j].addMouseListener(new java.awt.event.MouseAdapter() 
			    {
					int i = iClick;
					int j = jClick;
					boolean isClicked = true;
					public void mouseReleased(java.awt.event.MouseEvent evt) 
					{            
						coursesClick(evt,i,j, isClicked);
						isClicked = !isClicked;
					}
					public void mouseExited(java.awt.event.MouseEvent evt) 
					{
						int i = iClick;
						int j = jClick;
						coursesSale(evt);		            
					}
			    }
				);
			
				//	 Pasa el mouse y va a 	
				courses[i][j].addMouseMotionListener(new java.awt.event.MouseMotionAdapter() 
			    {
					int i = iClick;
					int j = jClick;
					public void mouseMoved(java.awt.event.MouseEvent evt) 
					{
						coursesMoved(evt,i,j);
					}	
			    }
				);				
			}
		}		
		//When it is clicked anyspace from the frame then every label are clenead
		addMouseListener(new java.awt.event.MouseAdapter() 
	    {
			public void mouseReleased(java.awt.event.MouseEvent evt) 
			{            
				cleanAllJLabel();
			}
	    }
		);
		
//    	listeners
    	curricCourses.setActionCommand(CURR_COUR_COMBO);
    	curricCourses.addActionListener(this);
    	curriButton.setActionCommand(CURRI);
    	curriButton.addActionListener(this);
    	areas.setActionCommand(AREA);
    	areas.addActionListener(this);	
    	cbub.setActionCommand(CBUB_COMBO);
    	cbub.addActionListener(this);
    	bMoveUp.setActionCommand(MOVEUP);
    	bMoveUp.addActionListener(this);
    	bMoveDown.setActionCommand(MOVEDOWN);
    	bMoveDown.addActionListener(this);
    	bSave.setActionCommand(SAVE);
    	bSave.addActionListener(this);
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
  		addButtons[0].setActionCommand(ADDCOURSE);
  		addButtons[0].addActionListener(this);
  		moveOutCourse.setActionCommand(MOVEOUT);
  		moveOutCourse.addActionListener(this);
  		
	}
	
	// load the curiculum courses to the curriculum table
	
	public void loadCourses() 
	{
		String[][] coursesToLoad = manager.getPlannedCurriculum();
		for (int i=0; i<10 ; i++)
		{
			for (int j = 0 ; j<10 ; j++)
			{
				if (!coursesToLoad[i][j].equals(""))
				{
					this.courses[i][j].setVisible(true);
					this.courses[i][j].setText(coursesToLoad[i][j]);
				}
				else
					this.courses[i][j].setVisible(false);
			}
		}
		
	}

	// Load the curriculum courses to the Combo Box
	public void loadCurricCoursesComboBox( )
	{
		// LLamar al metodo que da los cursos de un curriculo y se meten en el Combo Box
		ArrayList<String> arrSCodes = new ArrayList<String>(); 
		ArrayList<String> arrSNames = new ArrayList<String>();
		
		this.manager.getListOfCurriculumCourses(arrSCodes, arrSNames);
		String tempCourse;
		for (int i = 0; i < arrSCodes.size(); i++)
		{
			tempCourse = arrSCodes.get(i) + " - " +arrSNames.get(i); 	
			this.curricCourses.addItem(tempCourse);
		}
	}

	public void loadCbuaCourses(String co)
	{
		ArrayList arrSCodes = new ArrayList(); 
		ArrayList arrSNames = new ArrayList();
		ArrayList arrNum = new ArrayList();
		boolean flag = false;
		manager.getListOfAreas(arrSNames, arrNum);
		for(int i = 0; i < arrSNames.size() && !flag; i++)
		{
			if(arrSNames.get(i).equals(co))
			{
				flag = true;
			}
		}
		manager.getCoursesFromArea(co, arrSCodes);
		String tempCourse;
		if(arrSCodes.isEmpty())
		{
			cbub.setEnabled(false);
		}
		else
		{
			for (int i=0; i<arrSCodes.size();i++)
			{
				tempCourse = (String)arrSCodes.get(i) + " - " +(String)arrSNames.get(i); 
				areas.addItem(tempCourse);
			}	
		}
	}
	
	public void loadAreas() 
	{
		areas.removeAllItems();
		ArrayList arrNum = new ArrayList();
		ArrayList arrSNames = new ArrayList();
		manager.getListOfAreas(arrSNames, arrNum);
		String tempCourse;
		for (int i=0; i<arrSNames.size();i++)
		{
			tempCourse = (String)arrSNames.get(i) + " - " +(String)arrNum.get(i); 
			areas.addItem(tempCourse);
		}			
	}
	
	private void setTextAllJPanel( )
	{
		for (int i = 0 ; i<10; i++)
		{
			for (int j = 0 ; j<10; j++)
			{
				courses[i][j].setText("ja");
			}
		}		
	}


	private void setColorAllJPanel()
	{
		for (int i = 0 ; i<10; i++)
		{
			for (int j = 0 ; j<10; j++)
			{
				courses[i][j].setBackground(new java.awt.Color(147,205,236));
			}
		}		
	}

	private void createPosition( )
	{
		for (int i = 0 ; i<10; i++)
		{
			for (int j = 0 ; j<10; j++)
			{
				courses[i][j].setBounds(35+60*j,110+40*i,50,30);
			}
		}
	}


	private void addAllJLabel( )
	{
		for (int i = 0 ; i<10; i++)
		{
			for (int j = 0 ; j<10; j++)
			{
				getContentPane().add(courses[i][j]);
			}
		}
		
	}


	private void cleanAllJLabel( )
	{
		for (int i = 0 ; i<10; i++)
		{
			for (int j = 0 ; j<10; j++)
			{
				courses[i][j].setBackground(new java.awt.Color(147,205,236));
			}
		}
	}
	
	private void cleanAllJLabelExcept(int row )
	{
		for (int i = 0 ; i<10; i++)
		{
			for (int j = 0 ; j<10; j++)
			{
				if (row != i)
					courses[i][j].setBackground(new java.awt.Color(147,205,236));
			}
		}
	}


	private void createAllJLabel( )
	{
		courses = new JTextArea[11][11];
		for (int i = 0 ; i<10; i++)
		{
			for (int j = 0 ; j<10; j++)
			{
				courses[i][j] = new JTextArea ();
				courses[i][j].setFont(new Font("Serif", Font.BOLD, 10));
				courses[i][j].setEditable(false);
			}
		}
		
	}

	private void coursesClick(java.awt.event.MouseEvent evt, int x, int y, boolean is) {
		if(select.isSelected())
		{
			if (is)
			{
				cleanAllJLabelExcept(y);
				courses[x][y].setBackground(Color.YELLOW);
				lastSelected  = x;	   
			}
	        else 
	        	courses[x][y].setBackground(new java.awt.Color(147,205,236));
		}       	
    }
	
	private void coursesMoved(java.awt.event.MouseEvent evt, int x, int y) {
		if(look.isSelected())
		{
			if (!esta){
				System.out.println("Amarillo");
				for (int i = 0; i<10 ; i++)
					courses[x][i].setBackground(Color.GREEN);
			}
			esta = true;
		}
		
		
    }
	
	private void coursesSale(java.awt.event.MouseEvent evt) {
		if(look.isSelected())
		{
			esta = false;
			System.out.println("Afuera");
			this.cleanAllJLabel();
		}
			
    }
	
	public void actionPerformed(ActionEvent arg0)
	{
		String comando = arg0.getActionCommand();
		String temp [] = new String[2];
		String course = "";
		if (comando.equalsIgnoreCase(CURR_COUR_COMBO))
		{
			String courseSelectedTemp = (String)this.curricCourses.getSelectedItem();
			temp = courseSelectedTemp.split(" -");
			course = temp[0];			
			setNameAddLabels (0, course);
			setVisibleFields(1);
			forward.setVisible(true);
			next.setVisible(true);
		}
		else if(comando.equalsIgnoreCase(AREA))
		{
			String courseSelectedTemp = (String)areas.getSelectedItem();
			temp = courseSelectedTemp.split(" -");
			course = temp[0] + temp[1];
			loadCbuaCourses(course);		
		}
		else if (comando.equalsIgnoreCase(CURRI))
		{
			if(true)//manager.canGraduate())
			{
				cumCurr.setText("Si");
				cumCurr.setVisible(true);
			}
			else
			{
				cumCurr.setText("No");
				cumCurr.setVisible(true);
			}

		}
		else if (comando.equalsIgnoreCase(CBUB_COMBO))
		{
			String courseSelectedTemp = (String)cbub.getSelectedItem();
			temp = courseSelectedTemp.split(" -");
			course = temp[0];			
			setNameAddLabels (0, course);
			setVisibleFields(1);
			forward.setVisible(true);
			next.setVisible(true);
		}
		else if (comando.equalsIgnoreCase(ADDCOURSE))
		{
			add ();			
		}
		else if (comando.equalsIgnoreCase(MOVEDOWN))
		{				
			move(true);
			cleanAllJLabel();
			loadCourses();
			
		}
		else if (comando.equalsIgnoreCase(MOVEUP))
		{				
			move(false);
			cleanAllJLabel();
			loadCourses();
		}
		else if (comando.equalsIgnoreCase(MOVEOUT))
		{				
			moveoOut();
			loadCourses();
		}
		else if (comando.equalsIgnoreCase(SAVE))
		{				
			lastFrame.setVisible(true);
			this.setVisible(false);
			cbub.setEnabled(true);
		}
		else if (comando.equalsIgnoreCase(EXIT))
		{				
			System.exit( 0 );
		}

		
	}
	
	private void moveoOut() 
	{
		CodRes moved = CodRes.SUCCESS;
		boolean foundSelection = false;
		boolean finished = false;
		if(select.isSelected() == false)
		{
			JOptionPane pane = new JOptionPane();
    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
    		JOptionPane.showMessageDialog(null, "Para eliminar un curso tiene que tener seleccionado alguno", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			for (int i = 0; i <10 && !finished; i++)
			{
				if(courses[lastSelected][i].getBackground().equals(Color.YELLOW))
				{			
					moved = manager.removeCoursePlannedCurriculum(lastSelected,i);					
					foundSelection = true;
					if ( moved == CodRes.SUCCESS)
					{
						finished = true;						
					}					
				}				
			}
			if ( !finished)
			{
				showError(moved);
			}

			if ( !foundSelection)
			{
				JOptionPane pane = new JOptionPane();
        		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
        		JOptionPane.showMessageDialog(null, "Para mover un curso tiene que tener seleccionado alguno", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}		
		
	}

	private void add()
	{
		String semes = (String)addSemes[0].getSelectedItem();
		Integer sem = new Integer (semes);
		int semester = sem - 1;
		CodRes added;
		added = manager.addCourseToPlannedCurriculum(addCourses[0].getText(),semester);
		if (added ==  CodRes.SUCCESS)
		{
			loadCourses();
		}
		else
		{
			showError(added);			
		}		
	}
	
	private void move(boolean moveUp)
	{
		CodRes moved = CodRes.SUCCESS;
		boolean foundSelection = false;
		boolean finished = false;
		if(select.isSelected() == false)
		{
			JOptionPane pane = new JOptionPane();
    		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
    		JOptionPane.showMessageDialog(null, "Para mover un curso tiene que tener seleccionado alguno", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			for (int i = 0; i <10 && !finished; i++)
			{
				if(courses[lastSelected][i].getBackground().equals(Color.YELLOW))
				{			
					moved = manager.moveCoursePlannedCurriculum(lastSelected,i,moveUp);
					if (moved == CodRes.SUCCESS)
					{
						JOptionPane pane = new JOptionPane();
		        		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
		        		String courseSelectedTemp = (String)this.curricCourses.getSelectedItem();			
		        		loadCourses();	
		        		finished = true;
					}
					foundSelection = true;
				}				
			}
			if ( !finished)
			{
				showError(moved);
			}

			if ( !foundSelection)
			{
				JOptionPane pane = new JOptionPane();
        		pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
        		JOptionPane.showMessageDialog(null, "Para mover un curso tiene que tener seleccionado alguno", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}

	private void loadCoursesToAdd(String courseSelected)
	{
		int sizeCorr = 0;
		int sizePrerr = 0;
		//pedir los prerrequisitos en una lista
		//pedir los correquisitos en una lista
		if (sizeCorr+sizePrerr+1 > 7 )
		{
			forward.setVisible(true);
			next.setVisible(true);
			forward.setEnabled(false);
		}
		else
		{
			forward.setVisible(false);
			next.setVisible(false);
			setVisibleFields (sizeCorr+sizePrerr+1);
			//setNameAddLabels(0,courseSelected.getCodigo, courseSelected.getCreditos);
			for (int i=0; i<sizePrerr;i++)
			{
				//setNameAddLabels(i+1,listaCorr.getCodigo, listaCorr.getCreditos);
			}
			for (int i=0; i<sizeCorr;i++)
			{
				//setNameAddLabels(i+1+sizePrerr,listaCorr.getCodigo, listaCorr.getCreditos);
			}
		}
		
	}
	

	private void setVisibleFields(int size)
	{
		for (int i = size ; i<7; i++)
		{
			addButtons[i].setVisible(false);
			addCourses[i].setVisible(false);
			addSemes[i].setVisible(false);
		}
	}

	private void setNameCurriculumLabels (int x, int y, String courseCode, String courseCredit)
	{
		courses[x][y].setText(courseCode);
	}
	
	private void setNameAddLabels (int y, String courseCode)
	{
		addCourses[y].setText(courseCode);
		
	}

	public void setManager(CManager myManager) 	
	{
		this.manager = myManager;
		
	}

	public void update(Observable o, Object arg) 
	{
						
	}

	public void setLastFrame(JFrame lastFrame) 
	{
		this.lastFrame = lastFrame;
	}
	
	private void showError(CodRes added) 
	{
		if ( added == CodRes.ALREADY_EXISTS)
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Curso ya agregado", "Error", 0);			
		}
		else if ( added == CodRes.PREREQ)
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Violaci�n de Prerrequisito(s)", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if ( added == CodRes.COREQ)
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Violaci�n de Correquisito(s)", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if ( added == CodRes.INVALID_MOVE)
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Movimiento inv�lido", "Error",	JOptionPane.ERROR_MESSAGE);
		}	
		else if ( added == CodRes.FULL)
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Semestre lleno", "Error", JOptionPane.ERROR_MESSAGE);
		}	
		else if ( added == CodRes.LEVEL_ERROR)
		{
			JOptionPane pane = new JOptionPane();
			pane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 3, true));
			JOptionPane.showMessageDialog(null, "Violaci�n de niveles entre cursos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void loadPlannedCurriculum()
	{
		String[][] coursesToLoad = manager.getPlannedCurriculum();
		String courseInfo[] = new String[5];
		for (int i=0; i<10 ; i++)
		{
			for (int j = 0 ; j<10 ; j++)
			{
				if (!coursesToLoad[i][j].equals(""))
				{
					String course = coursesToLoad[i][j];
					if ( course.startsWith("1"))  //es ya visto
					{
						courseInfo = course.split("_");
						String code = courseInfo[1];
						this.courses[i][j].setVisible(true);
						this.courses[i][j].setText(coursesToLoad[i][j]);
					}
					else
					{
						this.courses[i][j].setVisible(true);
						this.courses[i][j].setText(coursesToLoad[i][j]);
					}
				}
				else
					this.courses[i][j].setVisible(false);
			}
		}
	}	
}