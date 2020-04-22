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

	public void displayTasks(){		
	
		//Calculating size of the border
        float border = width * 0.1f;
        //left border
		float left = width * 0.05f;
		//height
		float h = height * 0.1f;
		//There will be 30 numbers ranging from 1 - 30 on top of each line
		int nums = 30;

        for(int i = 0 ; i < tasks.size() ; i++){
            
            //Use .get to get an element from an array list
            Task t = tasks.get(i);

			//Figuring out the y coordanite for each task
            float y = map(i, 0, tasks.size(), border, height - border);
            //text will be white
            fill(255);
            textAlign(LEFT, CENTER);
            //Otputting each task
            text(t.getTask(), left - 10, y + (h/2));	
		}
		
		//Drawing the lines
		stroke(255);
		for(int i = 1;i <= nums;i++){
			float x = map(i, 0, nums, border, width - border);
			line(x, border, x, height - border); 
			text(i, x, border / 2);
		}

		
		//Drawing the boxes
		colorMode(HSB);
		noStroke();
		float cGap = 255 / (float) tasks.size();
		for(int i = 0;i < tasks.size();i++){
			Task task = tasks.get(i);
			//Total takes in the length of each rectangle we must plot
			float total = task.getEnd() - task.getStart();
			fill(i * cGap, 255, 255);
			//Each rectangle will start at the start of each in the csv file 
			float x = map(task.getStart(), 0, 30, border, width - border);
			float y = map(i, 0, tasks.size(), left + 55, height - border);
			//Each line is 22 pixels in width on the screen so we multiply to get
			//each rectangle passing the correct number of lines
			rect(x, y, total * 22, h/2); 	
		}
	}

	public void mousePressed()
	{
		//float border = width * 0.1f;
		float left = width * 0.05f;
		float h = height * 0.1f;
		for(int i = 0;i < tasks.size();i++){
			Task t = tasks.get(i);
			//float x = map(t.getStart(), 0, 30, border, width - border);
			float y = map(i, 0, tasks.size(), left + 55, width - height);
			if(mouseX > t.getStart() && mouseX < (t.getEnd() - t.getStart())*20 
				&& mouseY > y && mouseY < y + h){
				System.out.println("Clicked");
			}
		}
		//println("Mouse pressed");		
	}
	

	public void mouseDragged()
	{
		//println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{	
		background(0);
		colorMode(HSB);		
		displayTasks();
	}
}
