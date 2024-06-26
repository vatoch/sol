package groupwork.solution;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LimitedTimeTask extends Task{
    
    private LocalDateTime deadline;
    
    public LimitedTimeTask(String name, String description, String creatorUsername,LocalDateTime deadline) {
        super(name, description, creatorUsername);
        this.deadline=deadline;
        
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + ",Deadline:" + deadline;
    }

    @Override
    public void updateTask(Scanner scanner) {
        super.updateTask(scanner);
        scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Enter new deadline: ");
        String deadline = scanner.nextLine();

        this.deadline= LocalDateTime.parse(deadline,formatter);
        System.out.println("Task updated successfully");
    }
}
