package FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOps {



    public static File selectFile(String s)
    {
        File file  = new File(s);

        if (file.exists())
        {
        return file;

        }
        else
        {
            createFile(file);
            return file;
        }
    }//method to return file from name or Path
    public static int getLinesNumber(File file)
    {   int lines=-1;
        try{
            lines = Files.readAllLines(Paths.get(file.getAbsolutePath())).size();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return lines;
    }//Return number of line is EndAz.txt file - used to know length of String[] array
    //////////////////////Supportive methods/////////


    public static void createFile(File file)
    {
        try{
            file.createNewFile();
            System.out.println("New File has been created...");
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }

    }

}
