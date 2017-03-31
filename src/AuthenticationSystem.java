
import java.util.Scanner;

/**
 * Created by Jason on 3/25/2017.
 */
public class AuthenticationSystem
{
//    private String userName;
//    private String userPass;
//    private Boolean checkLogIn;
//    private Integer index = 1;
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
       // auth.Login();
        //auth.Password(auth.getUserPassword());
       // fileLoader.LoadFile(authSystem.fileName);
        //auth.Validate();
        //System.out.println();
       // String jobTile = auth.getJobTitle();
        //String [] jobFile = fileLoader.LoadFile(jobTile+".txt");
        //String jobOutput = fileLoader.ConvertFile(jobFile);
       // System.out.println(auth.getConvertFile());
        //test
    }
}
