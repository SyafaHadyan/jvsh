import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    private static void command(String userInput)
    {
        if (userInput.equals("exit 0"))
        {
            exit(userInput);
        }
        else if (userInput.contains("echo"))
        {
            echo(userInput.replaceAll("echo ", ""));
        }
        else
        {
            System.out.println(userInput + ": command not found");
        }
    }
    private static void exit(String userInput)
    {
        input.close();
        System.exit(Integer.parseInt(userInput.split("\\s+")[1]));
    }
    private static void echo(String userInput)
    {
        System.out.println(userInput);
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
