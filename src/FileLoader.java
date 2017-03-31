import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jason on 3/25/2017.
 */
public class FileLoader
{

    private List<String> fileList;
    private String[] fileArray;
    private String fileName;

    public void setFileArray(String[] loadFileArray)
    {
        fileArray = loadFileArray;
    }

    public String[] getFileArray()
    {
        return fileArray;
    }

    public FileLoader(String file)
    {
        this.fileName = file;
        LoadFile(fileName);
    }

    public String[] LoadFile(String fileName)
    {
        try
        {
            FileInputStream fileStream = new FileInputStream(fileName);
            Scanner inFS = new Scanner(fileStream);
            fileList = new ArrayList<>();

           while(inFS.hasNextLine())
           {
              String file = inFS.nextLine();
              fileList.add(file);
           }
            String [] loadedFileArray = fileList.toArray(new String[0]);
            fileStream.close();
            setFileArray(loadedFileArray);
            return loadedFileArray;
        }
        catch (IOException e)
        {
            setFileArray(null);
            return null;
        }
    }

}
