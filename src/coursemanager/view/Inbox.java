
package coursemanager.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import coursemanager.controller.CManager;



public class Inbox extends JFrame implements ActionListener{ 
	
	/**
     * Constants
     */

	private static final String EXIT = "exit";
	private static final String GOBACK = "goback";
	private static final String LASTPAGE = "lastpage";
	private static final String NEXTPGE = "nextpage";
    
	private JLabel textArea1 = new JLabel();
    private JLabel textArea2 = new JLabel();
    private JLabel textArea3 = new JLabel();
    
	private JButton button = new JButton(new ImageIcon("data/salirMenu.JPG"));
	
	private JButton bGoBack= new JButton(new ImageIcon ("data/volver.JPG"));
	
	private JButton deleteMessage = new JButton ();
	
	private JRadioButton[] radioButtons = new JRadioButton[10];
	
	private JTextArea[] subjects = new JTextArea[10];

    
	
	private JFrame lastFrame;
	
	private CManager manager;
	
	private ArrayList messagesBody = new ArrayList();
	
	private int actualPage = 1; 
	
	private int yClick = 0;
	
	private JTextArea fieldMessage = new JTextArea ();
	
	private JLabel from = new JLabel ("");
	
	private JLabel label1 = new JLabel();
	
	private JButton lastPage = new JButton (new ImageIcon ("data/atrascurso.JPG"));
	
	private JButton nextPage = new JButton (new ImageIcon ("data/siguientecurso.JPG"));

	private int sizeList = 0;
		
	public Inbox()
	{
		label1 = new JLabel("BUZON DE MENSAJES");
		JLabel label = new JLabel(new ImageIcon("data/uniandes.JPG"));
		
		JPanel listPanel = new JPanel (null);
		TitledBorder border = BorderFactory.createTitledBorder("Buzon");
    	border.setTitleColor(Color.RED);
    	listPanel.setBorder (border);    	
    	listPanel.setBounds(20,200,440,300);
    	listPanel.setBackground(new java.awt.Color(239, 239, 239));
    	
    	JPanel messagePanel = new JPanel (null);
		TitledBorder border2 = BorderFactory.createTitledBorder("Mensaje");
    	border2.setTitleColor(Color.RED);
    	messagePanel.setBorder (border2);    	
    	messagePanel.setBounds(500,200,380,300);
    	messagePanel.setBackground(new java.awt.Color(239, 239, 239));
		//		 Frame configuration data
    	setTitle("Buzon de mensajes");
    	setLayout(null);
    	setSize(900, 600);
    	setResizable( false );
    	JLabel subjectLabel = new JLabel("Asunto");
    	JLabel fromLabel = new JLabel ("De:");
    	
    	label1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setText("Sistema de visualizaci�n y control de la");
    	textArea2.setText("informaci�n acad�mica de los estudiantes de");
    	textArea3.setText("la Universidad de los Andes");
    	textArea1.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea1.setBackground(new java.awt.Color(239, 239, 239));
    	textArea2.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea2.setBackground(new java.awt.Color(239, 239, 239));
    	textArea3.setFont(new Font("Serif", Font.BOLD, 20));
    	textArea3.setBackground(new java.awt.Color(239, 239, 239));
    	subjectLabel.setFont(new Font("Serif", Font.BOLD, 14));
    	for (int i= 0; i<10; i++)
    	{
    		radioButtons[i] = new JRadioButton ();
    		subjects[i] = new JTextArea ();
    		subjects[i].setFont(new Font("Serif", Font.BOLD, 14));
    		subjects[i].setBackground(new java.awt.Color(239, 239, 239));
    		subjects[i].setEditable(false);
    		
    	}
    		
   	//    	Set components position
    	label.setBounds(10, 10, 159, 112);
    	textArea1.setBounds(330, 10, 460, 30);
    	textArea2.setBounds(330, 40, 460, 30);
    	textArea3.setBounds(330, 70, 460, 30);
    	label1.setBounds(40, 160, 400, 20);
    	fieldMessage.setBounds(20, 40, 350, 250);
    	fieldMessage.setEditable(false);
    	fromLabel.setBounds(20, 20, 50, 20);
    	from.setBounds(	60, 20, 150, 20);   	
    	subjectLabel.setBounds(200, 20, 400, 20);
    	button.setBounds(820, 520, 63, 37);
    	bGoBack.setBounds(730, 523, 63, 37);
    	lastPage.setBounds(100,260,70,30);
    	nextPage.setBounds(250,260,70,30);
    	for (int i= 0; i<10; i++)
    	{
    		subjects[i].setBounds(80, 60+(i*20), 300, 20);
    		radioButtons[i].setBounds(50, 60+(i*20), 20, 20);
    	}
    	//    	add components
    	
    	add(listPanel);
    	add(messagePanel);
    	add(label);
    	add(label1);
    	add(textArea1);
    	add(textArea2);
    	add(textArea3);
    	add(bGoBack);
    	add(button);
    	listPanel.add(subjectLabel);
    	listPanel.add(lastPage);
    	listPanel.add(nextPage);
    	messagePanel.add(fieldMessage);
    	messagePanel.add(fromLabel);
    	messagePanel.add(from);
    	
    	for (int i= 0; i<10; i++)
    	{
    		listPanel.add(subjects[i]);
        	//listPanel.add(radioButtons[i]);
    	}

    	button.addActionListener(this);
    	button.setActionCommand(EXIT);
    	bGoBack.addActionListener(this);
    	bGoBack.setActionCommand(GOBACK);
    	lastPage.addActionListener(this);
    	lastPage.setActionCommand(LASTPAGE);
    	nextPage.addActionListener(this);
    	nextPage.setActionCommand(NEXTPGE);
    	
    	for (int i = 0 ; i< 10 ; i++)
    	{
	    	yClick = i;
    		subjects[i].addMouseListener(new java.awt.event.MouseAdapter()
    		{
				int j = yClick;	
	    		public void mouseReleased(java.awt.event.MouseEvent evt) 
				{            
					seeMessage (j);
				}
    		}
			);
    	}
	}
	
	
	public void actionPerformed(ActionEvent event) 
	{
		String command = event.getActionCommand( );
		if(command.equalsIgnoreCase(GOBACK))
		{
				this.lastFrame.setVisible(true);
				this.setVisible(false);			
		}
		else if(command.equals(EXIT))
    	{
			System.exit( 0 );	
    	}
		else if(command.equals(NEXTPGE))
    	{
			actualPage++;	
			loadMessage();
    	}
		else if(command.equals(LASTPAGE))
    	{
			actualPage--;	
			loadMessage();
    	}
	}


	public void cleanMailBox ()
	{
		for (int i = 0; i<10; i++)
		{
			subjects[i].setVisible(true);
			radioButtons[i].setVisible(true);
			subjects[i].setText("");
			subjects[i].setBackground(new java.awt.Color(239, 239, 239));
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
	
	public void loadMessage ()
	{
		messagesBody = manager.getMessagesBody();
		sizeList = messagesBody.size();
		setVisibleMessage();
		fillSubjectMessage();		
		checkPage();
	}
	
	private void checkPage()
	{
//		caso base esta en la pagina 1
		if (actualPage == 1)
			lastPage.setEnabled(false);
		if ((sizeList-((actualPage-1)*10))>10)
			nextPage.setEnabled(true);
		else
			nextPage.setEnabled(false);
		if (actualPage>1)
			lastPage.setEnabled(true);		
	}
	
	private void setVisibleMessage ()
	{
		if ((sizeList-((actualPage-1)*10))<10)
		{
			int i = sizeList-((actualPage-1)*10);
			for (; i<10; i++ )
			{
				subjects[i].setVisible(false);
				radioButtons[i].setVisible(false);
			}
		}
		else
		{
			for (int j=0; j<10; j++ )
			{
				subjects[j].setVisible(true);
				radioButtons[j].setVisible(true);
			}
		}
	}
	
	private void fillSubjectMessage ()
	{
		Iterator <String> it = messagesBody.iterator();
		String chain = "", subject = "", from = "", id = "";
		boolean readed = true;
		String message[] = new String[4];
		
		int i = 0;
		int j = 0;
		while (it.hasNext())
		{
			chain = it.next();
			if(i >= (actualPage-1)*10 && i < actualPage*10)
			{
				message = chain.split("\t");
				readed = (message[0].equals("1"));
				subject = message[3];	
				subjects[j].setText(subject);
				j++;
			}
			i++;
		}		
	}
	
	public void setTittleMessage (boolean message)
	{
		if (message)
		{
			label1.setText("BUZON DE MENSAJES");
			setTitle("Buzon de mensajes");
		}
		else
		{
			label1.setText("BUZON DE AMONESTACIONES");
			setTitle("Buzon de amonestaciones");			
		}
			
	}
	
	private void seeMessage (int messagNumber)
	{
		Iterator <String> it = messagesBody.iterator();
		String chain = "", subject = "", fromBody = "", id = "";
		boolean readed = true;
		String message[] = new String[4];
		
		int i = 0;
		while (it.hasNext())
		{
			chain = it.next();
			if (i == messagNumber +((actualPage-1)*10))
			{				
				message = chain.split("\t");
				readed = (message[0].equals("1"));
				id = message[1];
				fromBody = message[2];
				subject = message[3];	
				from.setText(fromBody);
				fieldMessage.setText(manager.getSpecificMessage(id));
			}
			i++;
		}		
		
	}
}