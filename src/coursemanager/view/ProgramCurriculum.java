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
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import coursemanager.controller.CManager;



/**
 * @@author Familia
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ProgramCurriculum extends JFrame implements ActionListener, Observer
{
	private static final String SAVE = "save";
	private static final String EXIT = "exit";
		
	private boolean esta = false;
	private Color color ;
	private JTextArea amarillo;
	private JTextArea azul;
	private JTextArea[][] courses = new JTextArea[11][11];
	private int[] nextFree = new int[10];
	private int iClick = 0;
	private int jClick = 0;
	private CManager manager;
	private JButton bExit = new JButton(new ImageIcon("data/salirMenu.JPG"));
	private JButton bSave = new JButton(new ImageIcon ("data/volver.JPG"));
	private int lastSelected = 0;
	private JFrame lastFrame = new JFrame ();
	
	
	public ProgramCurriculum ()
	{
		// Creating the frame
		setTitle( "Crear - Consultar Curriculo - CriolloSoft" );
		setSize( 900, 600 );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		getContentPane().setLayout (null);
		getContentPane().setBackground(new java.awt.Color(239, 239, 239));
		JLabel tit = new JLabel("CURRICULO DE LA CARRERA "); 
		//Creating check boxs and buttons
		tit.setFont(new Font("Arial", Font.BOLD, 15));
		tit.setBounds(20, 20, 350, 31);
		add(tit);
		bSave.setBounds(750, 520, 63, 37);
		getContentPane().add(bSave);
		bExit.setBounds(820, 520, 63, 37);
		getContentPane().add(bExit);
    			
		// Creating the curriculum panel
		JPanel curriculum = new JPanel ();
    	TitledBorder border = BorderFactory.createTitledBorder("Curriculo Planeado");
    	border.setTitleColor(Color.RED);
    	curriculum.setBorder (border);    	
    	curriculum.setBounds(70,70,645,455);
    	curriculum.setBackground(new java.awt.Color(239, 239, 239));
    	JLabel labelSemestre[] = new JLabel[10];
    	for (int j = 0 ; j<10 ; j++)
    	{
    		Integer jj = new Integer(j+1);
    		labelSemestre[j] = new JLabel (jj.toString());
    		labelSemestre[j].setFont(new Font("Serif", Font.BOLD, 15));
    		labelSemestre [j].setForeground(Color.GRAY);
    		labelSemestre[j].setBounds(40, 110+40*j, 20, 30);
    		getContentPane().add(labelSemestre[j]);   		
    	}   	
				
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
    	bSave.setActionCommand(SAVE);
    	bSave.addActionListener(this);
    	bExit.setActionCommand(EXIT);
    	bExit.addActionListener(this);
	}
	
	// load the curiculum courses to the curriculum table
	
	public void loadCurriculumCourses() 
	{
		String[][] coursesToLoad = manager.getCurriculum();
		for (int i=0; i<10 ; i++)
		{
			for (int j = 0 ; j<10 ; j++)
			{
				if (!coursesToLoad[i][j].equals(""))
				{
					this.courses[i][j].setVisible(true);
					this.courses[i][j].setText(coursesToLoad[i][j]);
					manager.addObserverProgramCurr(i, j, this);
				}
				else
					this.courses[i][j].setVisible(false);
			}
		}	
			
		
		for (int i=0; i<10 ; i++)
		{
			for (int j = 0 ; j<10 ; j++)
			{
				if (!coursesToLoad[i][j].equals(""))
				{					
					ArrayList<String> cor = new ArrayList<String>();									
					manager.getListCoreqs(coursesToLoad[i][j], cor);
					Iterator<String> it = cor.iterator();
					while ( it.hasNext() )
					{
						inscribeCor(i, j,it.next());											
					}
					
					ArrayList<String> pre = new ArrayList<String>();
					manager.getListPrereqs(coursesToLoad[i][j], pre);
					Iterator<String> it2 = pre.iterator();
					while ( it2.hasNext() )
					{
						inscribePre(i, j ,it2.next());	
					}
					
				}
				else
					this.courses[i][j].setVisible(false);
			}
		}
		
	}

	private void inscribePre(int row, int column, String pre) 
	{
		for ( int i = 0; i <= row; i++ )
		{
			for ( int j = 0; j < 10; j++ )
			{
				if ( courses[i][j].getText().equals(pre))
				{
					manager.addCourseObserver( row, column, i, j, true);								
				}				
			}
		}		
	}

	private void inscribeCor(int row, int column, String cor) 
	{	
		for ( int i = 0; i <= row; i++ )
		{
			for ( int j = 0; j < 10; j++ )
			{
				if ( courses[i][j].getText().equals(cor))
				{
					manager.addCourseObserver( row, column, i, j, false);								
				}				
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
				courses[i][j].setBounds(95+60*j, 105+40*i, 50, 30);
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
	
	private void coursesMoved(java.awt.event.MouseEvent evt, int x, int y) 
	{
		if ( !courses[x][y].getText().startsWith("*") )
		{
			if (!esta)				
			{
				/*System.out.println("Amarillo");
				 for (int i = 0; i<10 ; i++)
				 courses[x][i].setBackground(Color.GREEN);*/
				manager.turnOn(courses[x][y].getText(),x, y);
			}
			esta = true;
		}
    }
	
	private void coursesSale(java.awt.event.MouseEvent evt) 
	{
		esta = false;		
		this.cleanAllJLabel();		
    }
	
	public void actionPerformed(ActionEvent arg0)
	{
		String comando = arg0.getActionCommand();
		if (comando.equalsIgnoreCase(SAVE))
		{				
			lastFrame.setVisible(true);
			this.setVisible(false);
		}
		else if (comando.equalsIgnoreCase(EXIT))
		{				
			System.exit( 0 );
		}
	}

	public void setManager(CManager myManager) 	
	{
		this.manager = myManager;	
	}

	public void update(Observable o, Object arg) 
	{
		String type = (String)arg;
		int x, y;
		Integer i, j;		
		i = new Integer(type.split(",")[1]);
		j = new Integer(type.split(",")[2]);
		x = i;
		y = j;
		
		if ( type.startsWith("PRE"))
		{
			courses[x][y].setBackground(Color.GREEN);			
		}
		else
		{
			courses[x][y].setBackground(Color.YELLOW);			
		}
						
	}

	public void setLastFrame(JFrame lastFrame) 
	{
		this.lastFrame = lastFrame;
	}
}