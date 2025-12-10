package app;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class PlaylistApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner input = new Scanner(System.in);
        boolean keepRunning = true;
        while(keepRunning) {
            displayMenu();

            String choice = input.nextLine();


            switch(choice){
                // if(case.equals("1")
                case "1":
                    handleHello();
                    break;
                case "2":
                    handleGoodbye();
                    break;
                case "3":
                    handleWhat();
                    break;
                case "0":
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Please enter a valid option!!!");
            }
        }

        System.out.println("Program terminating. Goodbye!");
    }

    private static void handleHello(){
        System.out.println("Hi!!");
    }

    private static void handleGoodbye() {
        System.out.println("Bye!!");
    }

    private static void handleWhat(){
        System.out.println("Whaaaaaaaaaaaaaaaaaat?!");
    }

    private static void displayMenu() {
        System.out.printf("Please select from the following options: ");
        System.out.println("1) Say hi");
        System.out.println("2) Say bye");
        System.out.println("3) Say what?!");
        System.out.println("0) Exit");
        System.out.println("This is a naive change!");
    }
}
