
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    // make a list to put all tasks in it.
    private List <Tasks> tasksList;

    public ToDoList() {
        tasksList = new ArrayList<>();
    }

    //add the task in the list.
    public void addTask(Tasks task){
        tasksList.add(task);
    }

    //delete the task from the list.
    public void deleteTask(Tasks task){
        tasksList.remove(task);
    }

    //to return the list of tasks.
    public List <Tasks> getTasksList(){
        return tasksList;
    }

    //to get a specific task in the list with its title.
    public Tasks getTask(String title)
    {
        for (Tasks task: tasksList){
            if(task.getTitle().equals(title)){
                return task;
            }
        }
        return null;
    }

    // to sort the tasks with its date and then display it for the user.
    public void displayTasksSortedByDate()
    {
        tasksList.sort((t1, t2) -> t1.getDate().compareTo(t2.getDate()));
        displayAllTasks();
    }

    // helper method to help me sort the priority.
    private int getPriorityValue(String priority)
    {
        switch (priority.toLowerCase()){
            case "high":
                return 3;
            case "medium":
                return 2;
            case "low":
                return 1;
            default:
                System.out.println("Invalid priorty");
                return 0;
        }
    }

    // to sort the tasks with its priority and then display it for the user.
    public void displayTasksSortedByPriorty()
    {
        tasksList.sort((t1, t2) -> {
                    // Define a mapping of priority levels to numbers
                    int priority1 = getPriorityValue(t1.getPriority());
                    int priority2 = getPriorityValue(t2.getPriority());
                    return Integer.compare(priority2, priority1);
                });
        displayAllTasks();

    }


    //to display all tasks in the list.
    public void displayAllTasks()
    {
        if(tasksList.isEmpty()){
            System.out.println("No Tasks to display");
        }
        else {
            for (Tasks task : tasksList) {
                task.displayTask();
                System.out.println("------------");
            }
        }
    }
}
