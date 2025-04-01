// Assignment1 Task1
// Name: Menna Allah Mohammed Hekal
// ID: 20230422
// Section: S15


/*
    Welcome in my To_Do_List program.
    this program helps you to manage your tasks, you can add a task with its details (task title, due date, task category,
    task priority)
    you can edit the task after you add it if you need, delete the task, mark it as completed and then delete the completed task if you want, display all
    tasks, or the tasks in a chosen category only, and a lot of things in the program.
    I hope it helps you to manage your tasks.

*/

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Main {
//    a menu that help the user and make him choose an option in the program.
    public static void displayMenu()
    {
        System.out.println();
        System.out.println("Welcome to our To_Do_List program\n" +
                "what you want to do?\n" +
                "1- Add a new task\n" +
                "2- Edit an existing task\n" +
                "3- Delete task\n" +
                "4- Mark task as completed\n" +
                "5- Display all tasks\n" +
                "6- Display all tasks in a chosen categery\n" +
                "7- Delete all tasks which is completed\n" +
                "8- Exit");
    }

//    to check that the date is valid "in the future".
    public static Date validDate(Scanner input, SimpleDateFormat sdf)
    {
        Date current = new Date();
        Date entered = null;
        boolean isValid = false;

        while(!isValid)
        {
            System.out.println("Please enter the due date (dd/mm/yyyy): ");
            String dateStr = input.nextLine();

            try {
                entered = sdf.parse(dateStr);
                if(entered.before(current)){
                    System.out.println("Invalid date. Please enter a valid date.");
                }
                else{
                    isValid = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid date format.");
            }
        }
        return entered;
    }

    public static void main(String[] args) {
        ToDoList to_do_list = new ToDoList();
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while(true)
        {
            displayMenu();
            System.out.println("Please choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice)
            {
//              Add new task:
                case 1:
                {
                    System.out.println("Please enter the task title: ");
                    String title = input.nextLine();

                    Date dueDate = validDate(input, sdf);

                    System.out.println("Please enter the priorty of your task (high/medium/low): ");
                    String priorty = input.nextLine();

                    System.out.println("Please enter the categery of your task (work/personal/study/other): ");
                    String categery = input.nextLine();
                    if (categery.equals("work") || categery.equals("personal") || categery.equals("study") || categery.equals("other")) {
                        if (priorty.equals("high") || priorty.equals("medium") || priorty.equals("low")) {
                            to_do_list.addTask(new Tasks(title, dueDate, priorty, categery));
                            System.out.println("Task added successfully.");
                        } else {
                            System.out.println("Invalid priority. Please enter a valid priority.");
                        }
                    } else {
                        System.out.println("Invalid category. Please enter a valid category.");
                    }

                    break;
                }

//              Edit an existing task:
                case 2:
                {
                    System.out.println("Please enter the task title to edit: ");
                    String title = input.nextLine();
                    Tasks task = to_do_list.getTask(title);
                    if(task != null){
                        System.out.println("Please enter the new title: ");
                        String newTitle = input.nextLine();

                        Date dueDate = validDate(input, sdf);

                        System.out.println("Please enter the priorty of your task (high/medium/low): ");
                        String priorty = input.nextLine();

                        System.out.println("Please enter the categery of your task (work/personal/study/other): ");
                        String categery = input.nextLine();

                        if (categery.equals("work") || categery.equals("personal") || categery.equals("study") || categery.equals("other")) {
                            if (priorty.equals("high") || priorty.equals("medium") || priorty.equals("low")) {
                                to_do_list.getTask(title).editTask(newTitle, dueDate, priorty, categery);
                                System.out.println("Task edited successfully.");
                            } else {
                                System.out.println("Invalid priority. Please enter a valid priority.");
                            }
                        } else {
                            System.out.println("Invalid category. Please enter a valid category.");
                        }

                    }
                    else {
                        System.out.println("Task does not exist.");
                    }
                    break;
                }

//              delete task:
                case 3:
                {
                    System.out.println("Please enter the task title you want to delete: ");
                    String title = input.nextLine();

                    System.out.println("Please enter the due date (dd/mm/yyyy): ");
                    String dateStr = input.nextLine();

                    try
                    {
                        Date dueDate = sdf.parse(dateStr);
                        Tasks task = to_do_list.getTask(title);
                        if(task != null && task.getDate().equals(dueDate)){
                            to_do_list.deleteTask(task);
                            System.out.println("Task deleted successfully.");
                        }
                        else {
                            System.out.println("Task does not exist.");
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                    }

                    break;
                }

//              mark task as completed:
                case 4:
                {
                    System.out.println("Please enter the task title you want to mark as completed: ");
                    String title = input.nextLine();

                    if(to_do_list.getTask(title) != null){
                        to_do_list.getTask(title).markCompleted();
                        System.out.println("Task marked as completed.");
                    }
                    else{
                        System.out.println("Task does not exist.");
                    }
                    break;
                }

//              display all tasks:
                case 5:
                {
                    System.out.println("1- Displaying all tasks sorted by date: ");
                    System.out.println("2- Displaying all tasks sorted by priorty: ");
                    int sortedChoice = input.nextInt();
                    if(sortedChoice == 1){
                        to_do_list.displayTasksSortedByDate();
                    }
                    else if(sortedChoice == 2){
                        to_do_list.displayTasksSortedByPriorty();
                    }
                    else{
                        System.out.println("Invalid option.");
                    }
                    break;
                }

//              display tasks in a category:
                case 6:
                {
                    System.out.println("Please enter the categery of your task (work/personal/study/other): ");
                    String categery = input.nextLine();
                    if(categery.equals("work") || categery.equals("personal")  || categery.equals("study") || categery.equals("other")) {
                        for (Tasks task : to_do_list.getTasksList()) {
                            if (task.getCategory().equals(categery)) {
                                task.displayTask();
                                System.out.println("------------");
                            }
                        }
                    }
                    else{
                        System.out.println("Invalid category. Please enter a valid category.");
                    }
                    break;
                }

//              Delete Tasks which is completed:
                case 7:
                {
                    for (int i = to_do_list.getTasksList().size() - 1; i >= 0; i--) {
                        Tasks task = to_do_list.getTasksList().get(i);
                        if (task.isCompleted()) {
                            to_do_list.deleteTask(task);
                        }
                    }
                    System.out.println("Completed tasks deleted.");
                    break;
                }

//              exit:
                case 8: {
                    System.out.println("Exiting...");
                    return;
                }

                default: {
                    System.out.println("Invalid option.");
                    break;
                }
            }
        }
    }
}