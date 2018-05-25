import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    public void addCondiments() {
        System.out.println("Adding suger and milk");
    }

    public boolean customerWantsCondiments() {
        String answer = getUserInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else if (answer.toLowerCase().startsWith("n")) {
            return false;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                answer = in.readLine();
            } catch (IOException ioe) {
                System.err.println("Io error trying to read your answer");
            }
            if (answer == null) {
                return "no";
            } else if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")) {
                return answer;
            }
        }
    }
}