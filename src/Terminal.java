import java.io.File;
import java.util.Scanner;

public class Terminal {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        do {

            System.out.print("luismi@laptop ~ $ ");

            String input = sc.nextLine();
            String command, argument = null;

            if (input.contains(" ")) {
                String[] parts = input.split(" ");
                command = parts[0];
                argument = parts[1];
            } else {
                command = input;
            }

            switch (command) {

                case "pwd":
                    fileManager.pwd();
                    break;

                case "cd":
                    fileManager.cd(argument);
                    break;

                case "ls":
                    fileManager.ls();
                    break;

                case "ll":
                    fileManager.ll();
                    break;

                case "mkdir":
                    fileManager.mkdir(argument);
                    break;

                case "rm":
                    fileManager.rm(argument);
                    break;

                case "mv":
                    System.out.println("Function not available");
                    // Function created in FileManager but not implemented
                    // if argument2/parts[2] is added, all explodes
                    break;

                case "help":
                    fileManager.help();
                    break;

                case "exit":
                    exit = true;
                    break;

                default:
                    System.out.println("Order failed");
                    break;

            }

        } while (!exit);

    }

}