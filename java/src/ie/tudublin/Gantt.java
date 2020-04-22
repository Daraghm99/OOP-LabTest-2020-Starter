package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	//Creating our Array List which will be used to take in the data from the csv file
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	/* 
		loadTasks() is used to populate the data from our csv file tasks.csv
		into the created ArrayList.
	*/
	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");

		for(TableRow row:table.rows()){
			Task t = new Task(row);
			tasks.add(t);
		}
	}

	/* 
		printTasks() is used to print the data from our ArrayList which
		has been populated from loadTasks()
	*/
	public void printTasks()
	{
		for(Task t:tasks){
			System.out.println(t);
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
	}
}
