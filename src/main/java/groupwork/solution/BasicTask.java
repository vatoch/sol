package groupwork.solution;

import java.util.Scanner;

public class BasicTask extends Task{

    public BasicTask(String name, String description, String creatorUsername) {
        super(name, description, creatorUsername);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void updateTask(Scanner scanner) {
        super.updateTask(scanner);
        System.out.println("Task updated successfully");
    }
}
