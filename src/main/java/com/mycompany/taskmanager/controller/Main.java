package com.mycompany.taskmanager.controller;

import com.mycompany.taskmanager.model.NotificationType;
import com.mycompany.taskmanager.model.Task;
import java.time.LocalDateTime;

/**
 *
 * @author St1gven
 */
public class Main 
{
	
	public static String journalPath;
	/**
     * @param args the command line arguments
     */
	public static void main(String[] args) throws InterruptedException
	{
		Controller.getController().setJournal(JournalLoader.load(journalPath));
		Controller.getController().setMainWindow(new JournalWindow);
		Controller.getController().showWindow();
	}
}
