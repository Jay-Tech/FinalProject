
import java.util.Scanner;

/**
 * Created by Jason on 3/25/2017.
 */
public class AuthenticationSystem
{

    private String fileName = "credentials.txt";

    public static void main(String args[])
    {

        AuthenticationSystem authSystem = new AuthenticationSystem();
        FileLoader fileLoader = new FileLoader(authSystem.fileName);
        Scanner scrn = new Scanner(System.in);

        System.out.println("Please enter user name");
        String userName = scrn.nextLine();

        System.out.println("Please enter password");
        String userPassWord = scrn.nextLine();

        Authentication auth = new Authentication(fileLoader, userName, userPassWord, scrn);
     
    }
}
