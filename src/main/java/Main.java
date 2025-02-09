import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        while (!(userInput.equals("exit")))
        {
            System.out.print("$ ");
            userInput = input.nextLine();
            System.out.println(userInput + ": command not found");
        }
        input.close();
    }
}
