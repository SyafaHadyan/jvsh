import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            System.out.print("$ ");
            String userInput = input.nextLine();
            System.out.println(userInput + ": command not found");
            //
        }
        // input.close();
    }
}
