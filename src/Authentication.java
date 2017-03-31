
import java.security.*;
import java.util.Scanner;


/**
 * Created by Jason on 3/25/2017.
 */
public class Authentication
{
    private FileLoader fileLoader;
    private String userName;
    private String userPassword;
    private Boolean passed;
    private int index = 1;
    private String jobTitle;
    private Scanner scrn;

    public Authentication(FileLoader file, String userN, String userPass, Scanner scanner)
    {
        this.fileLoader = file;
        this.userName = userN;
        this.userPassword = userPass;
        this.scrn = scanner;
        userPassword = Password(userPass);
        Validate();
    }

    public String Password(String original)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest)
            {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        }
        catch (java.security.NoSuchAlgorithmException e)
        {
            return null;
        }
    }

    public void Login( )
    {
        System.out.println("Please enter user name");
        userName = scrn.nextLine();

        System.out.println("Please enter password");
        userPassword = scrn.nextLine();
    }


    public void Validate()
    {
        while(!CheckLogIn())
        {
            System.out.println("Incorrect username or password");
            if (index != 3)
            {
                Login();
                CheckLogIn();
                if(passed)
                {
                    break;
                }
                index++;
                System.out.println("Failed " + index + " login attempts");
            }
            else
            {
                System.out.println(index + " failed login in attempts program will now exit");
                System.exit(0);
                break;
            }
        }
        System.out.println("Successful Login");
        System.out.println();
        ConvertFile(jobTitle);
    }

    public Boolean CheckLogIn()
    {
        String[] loginFile = fileLoader.getFileArray();
         passed = false;
        for (String item : loginFile)
        {
          if(item.contains(userName)&& item.contains(userPassword))
          {
              passed = true;
              String[] job =item.split("\\t");
              jobTitle = job[job.length -1];
          }
        }
        return passed;
    }

    public void ConvertFile(String file)
    {
      //String [] jobFile = fileLoader.LoadFile(file + ".txt");
        fileLoader.LoadFile(file + ".txt");
        String [] jobFile = fileLoader.getFileArray();
        if(jobFile != null)
            {
                for (String item : jobFile)
                {
                    System.out.println(item);
                }
            }
            else
            {
                System.out.println("No files to load for this login");
            }
    }
}
