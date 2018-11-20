package com.mycompany.taskmanager.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author St1gven
 */
public class JournalLoader {
	public Journal loadJournal(String filename) throws IOException, ClassNotFoundException
	{
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename));
		return (Journal)stream.readObject();
	}
	public void storeJournal(Journal journal, String filename)throws IOException, ClassNotFoundException
	{
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename));
		stream.writeObject(journal);
	}
}
