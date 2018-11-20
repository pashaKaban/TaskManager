package com.mycompany.taskmanager.model;

/**
 *
 * @author St1gven
 */
public class IdGenerator {
	static int id = 0;
	static void setCurrentId(int id)
	{
		IdGenerator.id = id;
	}
	static int getNextId()
	{
		return id++;
	}
}
