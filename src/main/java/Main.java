import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    private static void command(String userInput)
    {
        String[] input = userInput.split("\\s+");
        if (input[0].equals("exit"))
        {
            exit(Integer.parseInt(input[1]));
        }
        else if (input[0].equals("echo"))
        {
            echo(userInput.replaceFirst("echo ", ""));
        }
        else if (input[0].equals("type"))
        {
            type(userInput.replaceFirst("type ", ""));
        }
        else
        {
            System.out.println(userInput + ": command not found");
        }
    }
    private static void exit(int statusCode)
    {
        input.close();
        System.exit(statusCode);
    }
    private static void echo(String userInput)
    {
        System.out.println(userInput);
    }
    private static void type(String userInput)
    {
        if (userInput.equals("echo"))
        {
            System.out.println("echo is a shell builtin");
        }
        else if (userInput.equals("exit"))
        {
            System.out.println("exit is a shell builtin");
        }
        else if (userInput.equals("type"))
        {
            System.out.println("type is a shell builtin");
        }
        else
        {
            System.out.println(userInput + ": not found");
        }
    }
    public static void main(String[] args) throws Exception
    {
        String userInput = "";
        while (true)
        {
            System.out.print("$ ");
            userInput = input.nextLine();
            command(userInput);
        }
    }
}
