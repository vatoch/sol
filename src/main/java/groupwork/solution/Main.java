package groupwork.solution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean exit = false;

        while(!exit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username : ");
            String userName = scanner.nextLine();
            printCommands();
            int command = scanner.nextInt();

            switch (command){
                case 1:
                    saveTaskCommand(scanner,userName);
                    break;
                case 2:
                    TaskStorage.allTasksInfo();
                    break;
                case 3:
                    System.out.println("Enter task name : ");
                    scanner.nextLine();
                    String taskName = scanner.nextLine();
                    Task task = TaskStorage.getTask(taskName);
                    if(task!=null) {
                        System.out.println(task);
                    }
                    break;
                case 4:
                    TaskStorage.updateTask(scanner);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Enter task name");
                    String tskName = scanner.nextLine();
                    TaskStorage.deleteTask(tskName);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    public static void saveTaskCommand(Scanner scanner,String userName) {
        scanner.nextLine();
        System.out.println("Enter task name");
        String name = scanner.nextLine();

        scanner.nextLine();
        System.out.println("Enter task description");
        String description = scanner.nextLine();

        Task task=null;
        System.out.println("Enter task type :");
        System.out.println("1.Limited time task");
        System.out.println("2.Repeatable task");
        System.out.println("3.Basic task");
        int taskType = scanner.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        switch (taskType) {
            case 1:
                scanner.nextLine();
                System.out.println("Enter deadline: ");
                String deadline = scanner.nextLine();

                LocalDateTime deadLineTime = LocalDateTime.parse(deadline,formatter);

                task = new LimitedTimeTask(name,description,userName,deadLineTime);
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Enter number of execution");
                int numberOfExecution = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter execution time :");
                String executionTime = scanner.nextLine();

                LocalDateTime execution = LocalDateTime.parse(executionTime,formatter);
                task = new RepeateableTask(name,description,userName,numberOfExecution,execution);
                break;
            case 3:
                task = new BasicTask(name,description,userName);
                break;
            default:
                System.out.println("Invalid command");
                return;
        }

        TaskStorage.addTask(task);
    }

    public static void printCommands() {
        System.out.println("Enter the command : ");
        System.out.println("1.Save task");
        System.out.println("2.Load all tasks");
        System.out.println("3.Load specific task");
        System.out.println("4.Update specific task");
        System.out.println("5.Delete specific task");
        System.out.println("6.Exit");
    }
}