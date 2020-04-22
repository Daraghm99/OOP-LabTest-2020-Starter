package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;

public class Task {

    //Creating our private fields
    private String task;
    private int start;
    private int end;

    public Task(String task, int start, int end){

        this.task = task;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow tr) {
        this(tr.getString("task"), tr.getInt("start"), tr.getInt("end"));
    }

    //Generating our getters and setters
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    //Generating our toString() method
    @Override
    public String toString() {
        return "Task : " + task + " [Start =" + start + ", end=" + end + "]";
    }

    

}