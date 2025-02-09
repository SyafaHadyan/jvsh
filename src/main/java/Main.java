import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        while (true)
        {
            System.out.print("$ ");
            userInput = input.nextLine();
            if (userInput.equals("exit 0"))
            {
                break;
            }
            System.out.println(userInput + ": command not found");
        }
        input.close();
    }
}
