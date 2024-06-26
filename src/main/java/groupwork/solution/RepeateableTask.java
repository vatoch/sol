package groupwork.solution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RepeateableTask extends Task{
    
    private Integer executeNumber;
    
    private LocalDateTime executionTime;
    
    public RepeateableTask(String name, String description, String creatorUsername,Integer executeNumber, LocalDateTime executionTime) {
        super(name, description, creatorUsername);
        this.executeNumber=executeNumber;
        this.executionTime=executionTime;
    }

    public Integer getExecuteNumber() {
        return executeNumber;
    }

    public void setExecuteNumber(Integer executeNumber) {
        this.executeNumber = executeNumber;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return super.toString() + ", executeNumber=" + executeNumber + ", executionTime=" + executionTime;
    }

    @Override
    public void updateTask(Scanner scanner) {
        super.updateTask(scanner);
        scanner.nextLine();
        System.out.println("Enter new executeNumber: ");
        int numberOfExecution = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter execution time :");
        String executionTime = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime execution = LocalDateTime.parse(executionTime,formatter);

        this.executeNumber = numberOfExecution;
        this.executionTime = execution;

        System.out.println("Task updated successfully");
    }
}
