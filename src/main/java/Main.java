import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    static Scanner input = new Scanner(System.in);
    private static void command(String userInput)
    {
        String[] input = userInput.split("\\s+");
        String execPath = getPath(input[0]);
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
        else if (execPath != null)
        {
            System.out.println("Program was passed " + input.length + " args (including program name).");
        }
        else
        {
            invalidCommand(userInput);
        }
    }
    private static void exit(int statusCode)
    {
        input.close();
        System.exit(statusCode);
    }
    private static void invalidCommand(String userInput)
    {
        System.out.println(userInput + ": command not found");
    }
    private static void echo(String userInput)
    {
        System.out.println(userInput);
    }
    private static void type(String userInput)
    {
        if (userInput.equals("echo") || userInput.equals("exit") || userInput.equals("type"))
        {
            System.out.println(userInput + " is a shell builtin");
        }
        else
        {
            String path = getPath(userInput);
            if (path != null)
            {
                System.out.println(userInput + " is " + path);
            }
            else
            {
                System.out.println(userInput + ": not found");
            }
            return;
        }
    }
    private static String getPath(String userInput)
    {
        for (String i : System.getenv("PATH").split(":"))
        {
            Path path = Path.of(i, userInput);
            if (Files.isRegularFile(path))
            {
                return path.toString();
            }
            if (Files.isExecutable(path))
            {
                try
                {
                    Runtime runtime = Runtime.getRuntime();
                    Process process = runtime.exec(path.toString());
                }
                catch (Exception e)
                {
                    //
                }
            }
        }
        return null;
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
