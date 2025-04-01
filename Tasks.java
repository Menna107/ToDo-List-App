
import java.util.Date;

//Class for Tasks
public class Tasks
{
    private String title;
    private Date date;
    private boolean completed;
    private String priority;
    private String category;

    //constructor to put the attributes
    public Tasks(String title, Date date, String priorty, String categery)
    {
        this.title = title;
        this.date = date;
        this.priority = priorty;
        this.category = categery;
        this.completed = false;
    }

    //setting method for the title.
    public void setTitle(String title) {
        this.title = title;
    }

    //method to get the title.
    public String getTitle() {
        return title;
    }

    //method to get the category.
    public String getCategory() {
        return category;
    }

    //setting method for the category.
    public void setCategory(String categ) {
        this.category = categ;
    }


    //setting method for the date.
    public void setDate(Date date) {
        this.date = date;
    }

    //method to get the date.
    public Date getDate() {
        return date;
    }

    //method to get the priority.
    public String getPriority() {
        return priority;
    }

    //setting method for the priority.
    public void setPriority(String priority) {
        this.priority = priority;
    }

    //getting method that return if the task completed or not.
    public boolean isCompleted(){
        return completed;
    }

    //method that make the task completed.
    public void markCompleted() {
        this.completed = true;
    }


    //method that allow the user to edit the task.
    public void editTask(String title, Date date, String priorty, String category)
    {
        this.title = title;
        this.date = date;
        this.priority = priorty;
        this.category = category;
    }

    //method to display all attributes in the task.
    void displayTask()
    {
        System.out.println("Task Title: " + this.title);
        System.out.println("Task categery: " + this.category);
        System.out.println("Due date: " + this.date);
        System.out.println("Task Priorty: " + this.priority);
        System.out.println("isCompleted? " + this.completed);

    }
}
