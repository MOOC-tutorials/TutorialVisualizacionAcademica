package coursemanager.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class CCurriculumCourse extends Observable
{
	/**
	 * Course code
	 */
	private String courseCode;

	/**
	 * Course name
	 */
	//private String courseName;
	
	/**
	 * Credit number of the course
	 */
	//private float creditNumber;
	
	/**
	 * ArrayList of prerrequirements
	 */
	private ArrayList<String> Pre;
	
	/**
	 * ArrayList of correquirements
	 */
	private ArrayList<String> Cor;
	
	private ArrayList<Observer> Observers;
	/**
	 * Class constructor by parameters
	 */
	public CCurriculumCourse ( String course )
	{
		courseCode = course;
		Pre = new ArrayList<String>();
		Cor = new ArrayList<String>();
		Observers = new ArrayList<Observer>();
	}
	
	/**
	 * @@brief: Gets the code of a course in the curriculum  
	 * @@pre: the course exist     
	 * @@post: The code of the course is given
	 * @@param: none   
	 * @@return: String
	 * @@aditional_description: none
	 */
	public String getCourseCode()
	{
		return courseCode;
	}
	
	/**
	 * @@brief: Turn on the related courses  
	 * @@pre: true    
	 * @@post: the related courses has been update
	 */
	public void turnOnRelatedCourses()
	{
		notifyPreObservers();
		notifyCorObservers();
	}	
	
	/**
	 * @@brief:  Add a new observer 
	 * @@pre: The arraylist exists.    
	 * @@post: A new observer has been added.
	 * @@param: Observer o The new observer  
	 */
	public void addObserver( Observer o)
	{
		Observers.add(o);	
	}
	
	
	/**
	 * @@brief: Adds a new position to the Prereqs-Observers.  
	 * @@pre: The ArrayList exists    
	 * @@post: The new position has been added to the prereqs
	 * @@param: pnRow row of the new observer  
	 * @@return: pnColumn column of the new observer
	 */
	public void addPreObserver(int pnRow, int pnColumn)
	{
		String newPre = pnRow + "," + pnColumn;
		Pre.add(newPre);		
	}
	
	/**
	 * @@brief: Adds a new position to the Prereqs-Observers.  
	 * @@pre: The ArrayList exists    
	 * @@post: The new position has been added to the prereqs
	 * @@param: pnRow row of the new observer  
	 * @@return: pnColumn column of the new observer
	 */
	public void addCorObserver( int pnRow, int pnColumn )
	{
		String newCor = pnRow + "," + pnColumn;
		Cor.add(newCor);	
	}
	
	/**
	 * @@brief: Notifies to the member of the arrayList that contains
	 * the positions of the prereqs the change.  
	 * @@pre: The arrays are succesfully created.    
	 * @@post: The observers were notified
	 */
	private void notifyPreObservers()
	{
		Iterator<Observer> it = Observers.iterator();
		Iterator<String> itPre = Pre.iterator();
		Observer o;
		while ( it.hasNext())
		{
			o = it.next();
			while ( itPre.hasNext())
			{
				o.update(this, "PRE,"+itPre.next());				
			}							
		}		
	}
	
	/**
	 * @@brief: Notifies to the member of the arrayList that contains
	 * the positions of the coreqs the change.  
	 * @@pre: The arrays are succesfully created.    
	 * @@post: The observers were notified
	 */
	private void notifyCorObservers()
	{
		Iterator<Observer> it = Observers.iterator();
		Iterator<String> itCor = Cor.iterator();
		Observer o;
		while ( it.hasNext())
		{
			o = it.next();
			while ( itCor.hasNext())
			{
				o.update(this, "COR,"+itCor.next());				
			}							
		}			
	}

	/**
	 * Reset's the arrays of prereqs and coreqs.
	 */
	public void cleanObservers() 
	{
		Pre = new ArrayList<String>();
		Cor = new ArrayList<String>();		
	}		

}